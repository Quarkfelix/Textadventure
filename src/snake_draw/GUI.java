package snake_draw;

import javax.swing.JFrame;

import snake_io.KeyHandler;

public class GUI extends JFrame{
	public JFrame jf; 
	public DrawThread drawT;
	
	public GUI() {
		jf = new JFrame();
		drawT = new DrawThread();
		jf.setSize(1200, 800);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setUndecorated(true);
		
		jf.addKeyListener(new KeyHandler());
		jf.add(drawT.draw);
		jf.setVisible(true);
	}
}
