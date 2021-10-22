package mario;

import java.awt.*;
import javax.swing.*;

/*
 * Adrian Yu
 * Game class that runs the background class and sets the whole frame for the game
 */

public class Game {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Super Mario");//naming the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes the frame when pressing exit
		frame.setResizable(false);//does not allow the frame to change size
		frame.setLayout(new BorderLayout());//layout of the frame is border layout
		frame.add(new Background(), BorderLayout.CENTER);//puts background object in the centre
		frame.pack();//the frame size is set automatically
		frame.setVisible(true);
	}

}
