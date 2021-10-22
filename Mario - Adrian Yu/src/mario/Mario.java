package mario;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
/*
 * mario class
 * mario object that allows it to move and jump, with collision
 */
public class Mario{
	//movement
	boolean right =false;
	boolean endRight=false;
	boolean left=false;
	boolean endLeft=false;
	boolean jumping = false, falling=false;
	boolean topCollision = false;
	
	//moving speed
	double moveSpeed =2.5;
	
	//jump speed
	double jumpSpeed = 5;
	double currentJumpSpeed=jumpSpeed;
	
	//fall speed
	double maxFallSpeed = 5;
	double currentFallSpeed = 0.1;
	
	//reset
	boolean reset = false;
	
	
	//rect hitbox of mario
	Rectangle2D.Double marioBox;
	
	Image marioDefault,standingR,standingL,marioJump;
	
	//arrarys of mario running images to animate mario running
	Image [] marioRunningR = new Image[3];
	Image [] marioRunningL = new Image[3];

	private int width, height;//width and heigh of mario
	private double x,y;//cooridinates of mario
	
	/*
	 * constructor
	 */
	public Mario(int width, int height) {
		x=150;
		y=280;
		this.width=width;
		this.height=height;
		
		marioBox = new Rectangle2D.Double((int)x,(int)y,30,55);//creating a rectangle hitbox for the coins
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		standingR = kit.getImage("marioImages/marioStanding.png");//mario standing right
		standingL = kit.getImage("marioImages/marioStanding2.png");//mario standing left
	
		marioJump = kit.getImage("marioImages/marioJumpR.png");
		
		marioRunningR[0] = kit.getImage("marioImages/marioRight2.png");//mario running right 2
		marioRunningR[1] = kit.getImage("marioImages/marioRight.png");//mario running right
		marioRunningR[2] = kit.getImage("marioImages/marioRight3.png");//mario running right 3
		
		marioRunningL[0] = kit.getImage("marioImages/marioLeft2.png");//mario running left 2
		marioRunningL[1] = kit.getImage("marioImages/marioLeft.png");//mario running left 
		marioRunningL[2] = kit.getImage("marioImages/marioLeft3.png");//mario running left 3
		
		marioDefault = standingR;//default mario
	}
	/*
	 * method to update changes to the game
	 * pre: block, coin, coinY (array of objects)
	 * post: stops movement on block collision and score is added on coin collision
	 */
	public void update(Block[] blocks, Coin [] coin, int [] coinY) {
		int ix = (int)x;//changes double to int
		int iy = (int)y;//changes double to int
		
		//collision with mario and block
		for(int i=0;i<blocks.length;i++) {//using point collision
			//right side collision
			if(Collision.playerBlock(new Point(ix+width+(int)GameState.xOffset,iy+(int)GameState.yOffset+2), blocks[i]) //top right of mario
					|| Collision.playerBlock(new Point(ix+width+(int)GameState.xOffset, iy+height+(int)GameState.yOffset-1),blocks[i])){//bottom right of mario
				right=false;
			}
			//left side collision
			if(Collision.playerBlock(new Point(ix+(int)GameState.xOffset-1, iy+(int)GameState.yOffset+2), blocks[i])
				|| Collision.playerBlock(new Point(ix+(int)GameState.xOffset-1,iy+height+(int)GameState.yOffset-1),blocks[i])){
				left=false;
			}
			//top collision
			if(Collision.playerBlock(new Point(ix+(int)GameState.xOffset+1,iy+(int)GameState.yOffset),blocks[i])
					|| Collision.playerBlock(new Point(ix+width+(int)GameState.xOffset-1,iy+(int)GameState.yOffset), blocks[i])) {
				jumping = false;
				falling =true;
			}
			if(Collision.playerBlock(new Point(ix+(int)GameState.xOffset+2, iy+height+(int)GameState.yOffset+1),blocks[i])
					||Collision.playerBlock(new Point(ix+width+(int)GameState.xOffset-1,iy+height+(int)GameState.yOffset+1),blocks[i])) {
				y=blocks[i].getY()-height-GameState.yOffset;
				falling = false;
				topCollision=true;
			} else {
				//when mario is not on top of a block
				if(!topCollision && !jumping) {
					falling = true;
				}
			}
		}
		
		//coin collision
		boolean [] coinCollision=new boolean[coin.length];
		for(int i=0;i<coin.length;i++) {//uses rectangle collision
			//coin collision
			if(marioBox.intersects(coin[i].x-GameState.xOffset,coin[i].y-GameState.yOffset,30,30)){
				coinCollision[i]=true;
				LevelOne.score += 100;//each coin gives +1000 score
			}
			if(coinCollision[i]==true) {
				coin[i].y=2000;
			}
			if(reset ==true) {
				for(int j=0;j<coin.length;j++) {
					coin[j].y=coinY[j];//when falling off the map, resets the y coordinate of the coin
				}
			}
			reset = false;//reset the map when falling off the map
		}
		
		topCollision = false;//reset top collision
		
		//reaching the end of the map 
		if(endRight) {//mario moving right without the screen moving with it
			x += moveSpeed;
		}
		//reaching end of the map
		if(endLeft) {//mario moving left without the screen moving with it
			x -=moveSpeed;
		}
		if(right) {
			//moves mario right
			GameState.xOffset += moveSpeed;
		}
		if(left) {
			//moves mario left
			GameState.xOffset -= moveSpeed;
		}
		//jumping
		if(jumping) {
			GameState.yOffset -=currentJumpSpeed;
			currentJumpSpeed -= 0.125;
			if(currentJumpSpeed <=0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		//when falling
		if(falling) {
			GameState.yOffset += currentFallSpeed;
			if(currentFallSpeed<maxFallSpeed) {
				currentFallSpeed += 1;
			}
		}
		//when not falling
		if(!falling) {
			currentFallSpeed = 0.1;
		}
		//changes mario's image when moving right
		if(right || endRight) {
			int i=0;
			for(i=0;i<marioRunningR.length;i++) {
				marioDefault = marioRunningR[i];
			}
		}
		//changes mario's image when moving left
		if(left || endLeft) {
			for(int i=0;i<marioRunningL.length;i++) {
				marioDefault = marioRunningL[i];
			}
		}
		
		//reset mario if he falls off the map
		if(GameState.yOffset>250) {
			reset = true;
			if(reset) {
			GameState.xOffset=50;//reset x position of mario
			GameState.yOffset=-100;//reset y position of mario
			LevelOne.score=0;//reset the score to zero
			LevelOne.time += 1000;//add ten seconds
			}
		}
	}
	/*
	 * method to draw mario
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(marioDefault,(int)x,(int)y,null);
	}
	
	/*
	 * method for keyboard inputs, key press
	 */
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_LEFT || k == KeyEvent.VK_A){//when left arrow or A is pressed, mario moves left
			if(GameState.xOffset<=20) {//stops mario from going left at the start
				left=false;
			}
			else {
				left=true;
			}
			if(GameState.xOffset>=3200) {//when the point is hit during the map, the background stops scrolling and only mario moves
				left=false;
				endLeft=true;
				if(x<20) {
					endLeft=false;
				}
				if(x>450) {//stops all movements when at the flag
					endRight=false;
					endLeft=false;
					jumping=false;
				}
			}
		}
		else if(k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D){//when right arrow key or D is pressed, mario moves right
			if(GameState.xOffset>=3200) {//when the point is hit during the map, the background stops scrolling and only mario moves
				right=false;
				endRight=true;
				if(x>450) {//stops all movements when at the flag
					endRight=false;
					endLeft=false;
					jumping=false;
					LevelOne.finished=true;
				}
			}
			else {
				right=true;
			}
		}
		else if( (k == KeyEvent.VK_UP || k == KeyEvent.VK_W) && !jumping && !falling ) {//when up arrow or W key is pressed, mario jumps
			jumping=true;marioDefault = marioJump;
			if(x>450) {//stops all movements when at the flag
				endRight=false;
				endLeft=false;
				jumping=false;
			}
		}
	}
	/*
	 * method for key released
	 */
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_LEFT || k == KeyEvent.VK_A){left=false;endLeft=false;marioDefault=standingL;}
		else if(k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D){right=false;endRight=false;marioDefault=standingR;}
	}

}
