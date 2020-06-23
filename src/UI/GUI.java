package UI;

import javax.swing.JFrame;

import IO.KeyHandler;
import IO.MouseHandler;
import Infrastructure.Settings;

public class GUI extends JFrame{

	public static JFrame jf;
	public static DrawGame dg = new DrawGame();
	
	public void create() {
		jf = new JFrame();
		jf.setSize(Settings.windowWidth, Settings.windowHeight);
		jf.setLocationRelativeTo(null);
		jf.setResizable(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jf.addKeyListener(new KeyHandler());
		jf.add(dg);
		jf.requestFocus();
		jf.setVisible(true);
	}
}
