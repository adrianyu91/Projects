package mario;

import java.awt.*;
/*
 * Level One
 * Description: Where most game objects are called and used in the game
 * block, coin, mario, castle, flag
 */

public class LevelOne extends GameState{
	static boolean finished = false;
	Mario mario;//creating the mario object
	Block [] blocks;//arrays of block objects for the floor
	Castle castle;//creating a castle object
	Flag flag;//creating a flag object
	BackgroundOne mainBackground;
	Coin [] coin;
	int floor;//y coordinate of the floor
	static int score = 0;
	int [] coinY; //array of initial y coordinate of the coin;
	static int time=0;//time variable, in seconds
	
	//constructor
	public LevelOne(GameStateManager gsm) {
		super(gsm);//caling constructor of parent class
	}
	/*
	 * method to initializing objects
	 */
	public void init() {
		floor=350;//initial y coordinate of the floor
		mario = new Mario(30, 55);//creates a mario object 30 pixel wide and 55 pixels tall
		castle=new Castle(3750,140);//creates castle object
		flag = new Flag(3650,53);//creates a flag object
		mainBackground = new BackgroundOne(0,0);
		
		//map creation
		
		//creating block objects
		blocks = new Block[202];//creating blocks array
			//giving each block its own unique position on the map
		for(int i=0;i<130;i++) {
			blocks[i] = new Block(i*32,floor);
			if(i==15 || i==16) {
				blocks[i] = new Block(i*32, 200);
			}
			if(i>=32 && i<=47) {
				blocks[i] = new Block(i*32, 200);
			}
		}
		blocks[130] = new Block(400,318);
		blocks[131] = new Block(544,318);
		blocks[132] = new Block(630,250);
		for(int i=133;i<138;i++) {
			int num = i-133;
			blocks[i] = new Block(768 +(32*num) , 250);
		}
		blocks[138] = new Block(1600, 280);
		blocks[139] = new Block(1824,318);
		blocks[140] = new Block(1824,286);
		blocks[141] = new Block(2144,318);
		blocks[142] = new Block(2144,286);
		for(int i=0;i<4;i++) {
			blocks[143+i] = new Block(2240+i*32,250-i*32);
		}
		for(int i=0;i<10;i++) {
			blocks[147+i]=new Block(2816+i*32,318-i*32);
		}
		for(int i=0;i<9;i++) {
			blocks[157+i] = new Block(2848+i*32,318-i*32);
		}
		for(int i=0;i<8;i++) {
			blocks[166+i] = new Block(2880+i*32,318-i*32);
		}
		for(int i=0;i<7;i++) {
			blocks[174+i] = new Block(2912+i*32,318-i*32);
		}
		for(int i=0;i<6;i++) {
			blocks[181+i] = new Block(2944+i*32,318-i*32);
		}
		for(int i=0;i<5;i++) {
			blocks[187+i] = new Block(2976+i*32,318-i*32);
		}
		for(int i=0;i<4;i++) {
			blocks[192+i] = new Block(3008+i*32,318-i*32);
		}
		for(int i=0;i<3;i++) {
			blocks[196+i] = new Block(3040+i*32,318-i*32);
		}
		for(int i=0;i<2;i++) {
			blocks[199+i] = new Block(3072+i*32,318-i*32);
		}
		blocks[201] = new Block(3104,318);
		
		//creating coin objects
		coin = new Coin[28];
		coin[0] = new Coin(300,300);
		coin[1] = new Coin(350,300);
		coin[2] = new Coin(600,300);
		coin[3] = new Coin(650,300);
		coin[4] = new Coin(700,300);
		coin[5] = new Coin(750,300);
		coin[6] = new Coin(1050,160);
		coin[7] = new Coin(1100,160);
		coin[8] = new Coin(1150,160);
		coin[9] = new Coin(1200,160);
		coin[10] = new Coin(1250,160);
		coin[11] = new Coin(1300,160);
		coin[12] = new Coin(1000,300);
		coin[13] = new Coin(1900,300);
		coin[14] = new Coin(1950,300);
		coin[15] = new Coin(2000,300);
		coin[16] = new Coin(2050,300);
		coin[17] = new Coin(2240,150);
		
		for(int i=0;i<10;i++) {
			coin[18+i] = new Coin(2816+32*i,280-32*i);
		}
		
		boolean once=false;
		//to get the initial y coordinate of y for to reset the map and add coins to where it used to be
		coinY = new int[coin.length];
		if(once==false) {
			for(int i=0;i<coinY.length;i++) {
				coinY[i]=coin[i].y;
			}
			once=true;
		}	
	}
	
	/*
	 * method to update changes that are being applied to the game, collision.
	 */
	public void update() {
		mario.update(blocks, coin, coinY);
		if(finished) {
			gsm.gameStates.push(new Win(gsm));
		}
		//System.out.println(GameState.xOffset);
	}
	
	/*
	 * method to draw objects
	 * pre:none
	 * post: paints: flag, coin, blocks, mario, castle, strings(score and time)
	 */
	public void draw(Graphics g) {
		mainBackground.draw(g);
		
		flag.draw(g);
		
		for(int i=0;i<coin.length;i++) {
			coin[i].draw(g);
		}
		mario.draw(g);
		for(int i=0;i<blocks.length;i++) {
			blocks[i].draw(g);
		}
		castle.draw(g);
		
		g.setFont(new Font("Montserrat", Font.BOLD, 24));
		g.setColor(Color.WHITE);
		g.drawString("Score: "+ score,625,40);//draws a score text on the top right corner of the screen
		
		g.drawString("Time: "+ time/100,400,40);//draws a time text on the top middle of the screen
			time+=2;
	}
	/*
	 * key pressed method
	 */
	public void keyPressed(int k) {
		mario.keyPressed(k);
	}
	/*
	 * key released method
	 */
	public void keyReleased(int k) {
		mario.keyReleased(k);
	}
}
