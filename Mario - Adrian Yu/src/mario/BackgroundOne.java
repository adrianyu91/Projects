package mario;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
/*
 * class to create an object of the main background(game background)
 */
public class BackgroundOne {
	Image mainBackground;//image for the main background
	int x,y;
	/*
	 * constructor
	 */
	public BackgroundOne(int x, int y) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		this.x=x;//getting x coordinate of the background, at 0
		this.y=y;//getting y coordinate of the background, at 0
		mainBackground = kit.getImage("marioImages/mainBackground.jpg");//background image
	}
	/*
	 * method to draw the background onto the screen
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(mainBackground,x, y, null);//drawing the background at the x and y coordinates
	}

}
