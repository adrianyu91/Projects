package mario;

import java.awt.*;
import java.awt.event.*;
/*
 * Menu for mario game
 */

public class Menu extends GameState {
	
	String[] options = {"Start", "Instructions", "Quit"};//all choices on the menu screen
	int currentChoice = 0;//selecting which button
	Image menuBackground;//background image for the menu
	
	/*
	 * Constructor
	 */
	public Menu(GameStateManager gsm) {
		super(gsm);//parent class constructor
		Toolkit kit = Toolkit.getDefaultToolkit();
		menuBackground = kit.getImage("marioImages/MenuBackground.jpg");
	}

	public void init() {}//not used
	public void update() {}//not used

	/*
	 * method to draw strings and images on the menu
	 * pre: none
	 * post: draws: image of background, strings(options for the game)
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(menuBackground,0,0,null);
		g.setFont(new Font("Montserrat", Font.BOLD, 24));//setting the font size
		
		for(int i=0; i<options.length;i++) {
			if(i==currentChoice) {
				//when selected, text turns red
				g.setColor(Color.RED);
			}
			else {
				//text is white
				g.setColor(Color.WHITE);
			}
			//centering the text
			if(i==1) {
				//instruction text
				g.drawString(options[i],Background.WIDTH/2-65,325+i*30);//drawing the text on screen
			}
			else {
				//play and exit text
				g.drawString(options[i],Background.WIDTH/2-25,325+i*30);//drawing the text on screen
			}
		}
		
	}
	/*
	 * key pressed method
	 */
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_ENTER) {//when enter is pressed
			if(currentChoice==0) {
				//start choice
				gsm.gameStates.push(new LevelOne(gsm));//puts the user on the first level
			}
			else if(currentChoice==1) {
				//instruction choice
				gsm.gameStates.push(new Instructions(gsm));//puts the user on the instructions page
			}
			else if(currentChoice==2) {
				//quit
				System.exit(0);//exits the game
			}		
		}
		else if(k==KeyEvent.VK_UP) {//when up arrow key is pressed
			currentChoice--;//goes up a string/option
			if(currentChoice==-1) {
				currentChoice = 2;//resets to the quit button
			}
		}
		else if(k==KeyEvent.VK_DOWN) {//when down arrow key is pressed
			currentChoice++;//goes down a string/options=
			if(currentChoice==3) {
				currentChoice=0;//resets to the play button
			}
		}
	}
	
	public void keyReleased(int k) {}//not used
	
}
