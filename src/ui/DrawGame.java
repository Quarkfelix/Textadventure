package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import infrastructure.Main;
import infrastructure.Settings;
import io.KeyHandler;
import io.MouseHandler;
import libary_version_2.TextWriter;
import logic.Surface;

public class DrawGame extends JPanel{
	public static Surface surface;
	private TextWriter tw = new TextWriter();
	
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
		tw.drawText(g, 10, 15, "linksbuendig", new Font("TimesRoman", Font.PLAIN, 15), Color.BLACK, "FPS: " + Main.t.fps);
	}
}
