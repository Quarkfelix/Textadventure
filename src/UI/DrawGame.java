package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import IO.KeyHandler;
import IO.MouseHandler;
import Infrastructure.Main;
import Infrastructure.Settings;
import Logic.Surface;

public class DrawGame extends JPanel{
	public static Surface surface = new Surface();
	
	public DrawGame() {
		this.addMouseListener(new MouseHandler());
	}
	
	public void paint(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Settings.windowColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		surface.paint(g);
	}
}
