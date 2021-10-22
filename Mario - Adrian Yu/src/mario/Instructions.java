package mario;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
/*
 * Instruction page
 * description: gives the user controls, and objectives
 */
public class Instructions extends GameState{
	Image background, keyboard, object;
	//constructor
	public Instructions(GameStateManager gsm) {
		super(gsm);
		Toolkit kit = Toolkit.getDefaultToolkit();
		background = kit.getImage("marioImages/instructions.jpg");
		keyboard = kit.getImage("marioImages/instructions2.png");
		object = kit.getImage("marioImages/instructions3.png");
	}
	public void init() {}//not used in this class
	public void update() {}//not used in this class
	
	/*
	 * method to draw images and strings onto the screen
	 * pre:none
	 * post: draws images, strings and shapes on the screen
	 */
	public void draw(Graphics g) {
		Graphics2D ga = (Graphics2D) g;
		
		//drawing the image on the background
		ga.drawImage(background,0,0,null);
		
		//drawing white rectangle
		g.setColor(Color.WHITE);
		Rectangle2D.Double rect = new Rectangle2D.Double(100,50,600,400);
		ga.setPaint(Color.WHITE);
		ga.fill(rect);
		ga.draw(rect);
		
		//mario and luigi picture
		ga.drawImage(object,450,325,null);
		
		//drawing line in white rectangle
		ga.setPaint(Color.BLACK);
		ga.draw(new Line2D.Double(Background.WIDTH/2,100,Background.WIDTH/2,250));
		
		//keyboard/controls image
		ga.drawImage(keyboard,100,120,null);
		
		//controls text
		g.setFont(new Font("Montserrat",Font.BOLD, 24));
		g.setColor(Color.BLACK);
		g.drawString("W/↑ - Jump",475,125);
		g.drawString("A/← - Left",475,175);
		g.drawString("D/→ - Right",475,225);
		
		//objective text
		g.drawString("Objective: Reach the flag without dying...", 150,300);
		
		//menu text
		g.setColor(Color.RED);
		g.drawString("<-- Menu",120,425);
	}
	/*
	 * key pressed method
	 */
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_ENTER) {//when enter is pressed
			gsm.gameStates.push(new Menu(gsm));//goes back to the penu page
		}
	}
	public void keyReleased(int k) {}

}
