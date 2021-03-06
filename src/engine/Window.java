package engine;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import engine.Game;
public class Window extends Canvas{
	private static final long serialVersionUID = -418629015428621174L;
	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(game);
		game.start();
	}
}
