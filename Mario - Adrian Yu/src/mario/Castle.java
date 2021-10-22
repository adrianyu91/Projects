package mario;
import java.awt.*;
/*
 * class to creates a castle object
 */
public class Castle {
	Image castle;//image for the castle
	int x,y;//x and y coordinates of the castle
	/*
	 * constructor
	 */
	public Castle(int x, int y) {
		this.x=x;//getting the x coordinate of the castle
		this.y=y;//getting the y coordinate of the castle
		Toolkit kit = Toolkit.getDefaultToolkit();
		castle = kit.getImage("marioImages/Castle.png");//castle image
	}
	/*
	 * method to draw the castle
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(castle,x-(int)GameState.xOffset, y-(int)GameState.yOffset, null);//drawing the castle at the x and y coordinates
	}

}
