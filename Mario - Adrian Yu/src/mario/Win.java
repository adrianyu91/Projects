package mario;

import java.awt.*;
import java.awt.event.KeyEvent;
/*
 * Win screen when mario reaches the flag
 */

public class Win extends GameState{
	Image victory;//background image 
	
	/*
	 * constructor
	 */
	public Win(GameStateManager gsm) {
		super(gsm);
		Toolkit kit = Toolkit.getDefaultToolkit();
		victory = kit.getImage("marioImages/victory.jpg");
	}
	public void init() {}//not used
	public void update() {}//not used
	
	/*
	 * method to draw images and strings onto the screen
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		//draws background image
		g2.drawImage(victory,0,0,null);
		
		//drawing strings
		g.setFont(new Font("Montserrat",Font.BOLD, 24));
		g.setColor(Color.WHITE);
		g.drawString("Score: "+ LevelOne.score,200,400);//draws score
		g.drawString("Time: "+ LevelOne.time/100+" seconds",425,400);//draws time
		g.drawString("Press enter to return to menu",Background.WIDTH/2,490);//draws text to return to menu
	}
	
	/*
	 * key pressed method
	 */
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_ENTER) {//when enter is pressed
			gsm.gameStates.push(new Menu(gsm));//returns to the menu page
		}
	}
	public void keyReleased(int k) {}//not used
}
