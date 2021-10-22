package mario;

import java.awt.*;
/*
 * block
 * description: creates a block object that is called in level one
 */

public class Block extends Rectangle{
	Image block;//image for the block
	static final int blockSize = 32;//size of block
	
	//constructor
	public Block(int x, int y) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		setBounds(x,y,blockSize,blockSize);//set initial bounds the block(x coordinate, y coordinate, width, height)
		block = kit.getImage("marioImages/block.jpg");//block
	}
	/*
	 * method to draw block object on the screen
	 * pre:none
	 * post: block image on screen
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(block,x-(int)GameState.xOffset,y-(int)GameState.yOffset,null); //draws the image of the block
	}
}
