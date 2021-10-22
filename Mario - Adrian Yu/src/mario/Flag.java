package mario;

import java.awt.*;
/*
 * Class to create a flag object
 */
public class Flag {
	Image flag;//image of the flag
	int x,y;//x and y coordinate of the flag
	final int width=61, height=300;//width and height of the flag
	/*
	 * constructor
	 */
	public Flag(int x, int y) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		this.x=x;//getting x coordinate of the flag
		this.y=y;//getting y coordinate of the flag
		flag = kit.getImage("marioImages/Flag Pole.png");//castle image
	}	
	/*
	 * method to draw the flag
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(flag,x-(int)GameState.xOffset, y-(int)GameState.yOffset, null); //drawing the flag at the certain x and y coordinate
	}
}
