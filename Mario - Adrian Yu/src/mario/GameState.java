package mario;

import java.awt.*;

//abstract class - a class that is declared abstract, cannot be instantiated, but can be subclassed
public abstract class GameState {
	GameStateManager gsm;
	static double xOffset, yOffset;//game x and y coordinate
	final static double x=3200, y=0;
	
	/*
	 * constructor
	 * used to initialize every subclass, since this is the parent class
	 */
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		
		//moving the blocks to the left
		xOffset = 0;//the x coordinate of the whole game
		yOffset = 0;//the y coordinate of the whole game
		
		init();//runs the init method, init is like a second constructor for sub classes
	}
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);

}
