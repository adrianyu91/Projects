package mario;
import java.awt.*;
/*
 * class to determine collision when mario hits/walks on a block
 */
public class Collision {
	/*
	 * method to determine if mario hits/walks on a block
	 * pre:point, and block object(rectangle bound)
	 * post: true if block contains point, and false if block does not contain point
	 */
	public static boolean playerBlock(Point p, Block b) {
		return b.contains(p);//when a player touches a block it returns true
	}
}
