package mario;

import java.awt.*;
import java.util.Stack;
/*
 * Class to managed all states of the game
 */
public class GameStateManager {
	public Stack<GameState> gameStates;
	//public static final int MENU = 0;
	//public static final int LEVELONE = 1;//level one of the game
	/*
	 * constructor
	 */
	public GameStateManager() {
		gameStates = new Stack<GameState>();//creating a stack of objects
		gameStates.push(new Menu(this));//menu loaded up at the start, pushes item to the top of the stack
		
	}
	/*
	 * method to initialize game state
	 */
	public void init() {
		gameStates.peek().init();//looks at object without removing it from the stack
	}
	/*
	 * method to update game state
	 */
	public void update() {
		gameStates.peek().update();//looks at object without removing it from the stack
	}
	/*
	 * method to draw game state
	 */
	public void draw(Graphics g) {
		gameStates.peek().draw(g);//looks at object without removing it from the stack
	}
	/*
	 * method for key pressed
	 */
	public void keyPressed(int k) {
		gameStates.peek().keyPressed(k);//looks at object without removing it from the stack
	}
	//method for key released
	public void keyReleased(int k) {
		gameStates.peek().keyReleased(k);//looks at object without removing it from the stack
	}
}
