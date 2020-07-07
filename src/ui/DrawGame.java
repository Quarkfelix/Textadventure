package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import infrastructure.Main;
import infrastructure.Settings;
import io.KeyHandler;
import io.MouseHandler;
import logic.Surface;

public class DrawGame extends JPanel{
	public static Surface surface;
	
//constructor------------------------------------------------------------------------------------------------------------
	public DrawGame() {
		this.addMouseListener(new MouseHandler());
		surface = new Surface();
	}
	
//paint------------------------------------------------------------------------------------------------------------
	public void paint(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Settings.windowColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		try {
			surface.paint(g);			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
