package mario;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * background
 * panel for the game
 */
public class Background extends JPanel  implements Runnable, KeyListener{
	
	public static final int WIDTH = 800;//size of panel, 800 pixels
	public static final int HEIGHT = 500;//size of panel, 400 pixels
	
	private Thread thread;
	private boolean running = false;
	
	private int FPS=60;//frames per seconds
	private long targetTime = 1000/FPS;
	
	private GameStateManager gsm;//creating game state manager object
	
	//constructor
	public Background() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		addKeyListener(this);
		setFocusable(true);
		start();//runs the thread
	}
	
	/*
	 * method to start the thread
	 * pre:none
	 * post:thread starts
	 */
	private void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/*
	 * method the is used to run everything on the game
	 * pre:none
	 * post:runs thread
	 */
	public void run() {
		long start, elapsed, wait;
		gsm = new GameStateManager();
		
		while(running) {
			start = System.nanoTime();
			update();
			repaint();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed/1000000;
			if(wait<=0) {
				wait=5;
			}
			try {
				Thread.sleep(wait);
				}
			catch(Exception e) {
				e.printStackTrace();//prevents black screens
			}
		}
	}
	/*
	 * method that updates everything in the GameStateManager class
	 */
	public void update() {
		gsm.update();
	}
	/*
	 * method to paint/repaint
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0,0,WIDTH,HEIGHT);//repaints the screen
		gsm.draw(g);
	}
	public void keyTyped(KeyEvent e) {}
	//key pressed method
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}
	//key released method
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}
}
