package mario;
import java.awt.*;
/*
 * coin object
 * rectangle parameters are used to make it simpler
 */
public class Coin extends Rectangle{
	Image coin;//get image for the coin
	int height=30, width=30;;//dimensions of coin
	
	/*
	 * constructor
	 */
	public Coin(int x, int y) {
		setBounds(x,y,height,width);
		Toolkit kit = Toolkit.getDefaultToolkit();
		coin = kit.getImage("marioImages/coin.png");//coin picture
	}
	
	/*
	 * method to draw the coin onto the screen
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(coin,x-(int)GameState.xOffset,y-(int)GameState.yOffset,null);
	}
}
