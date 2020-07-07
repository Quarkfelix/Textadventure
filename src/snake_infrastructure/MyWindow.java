package snake_infrastructure;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;

import libary_version_2.Button;
import snake_objects.GameField;
import snake_ui.InformationPanel;

public class MyWindow {
	private int selectedAlgorythm = 0;
	public static GameField gf;
	public static InformationPanel infPanel;
	public HashMap<String, Button> buttons = new HashMap<String, Button>();
	
//constructor------------------------------------------------------------------------------------------------------------
	public MyWindow() {
		buttons.put("play", new Button(1030, 685, 120, 50, Color.BLACK, Color.RED));
		buttons.put("quit", new Button(860, 685, 120, 50, Color.BLACK, Color.RED));
		buttonSetup();
		infPanel = new InformationPanel();
	}
	
//methods------------------------------------------------------------------------------------------------------------
	private void buttonSetup() {
		buttons.get("play").setText("PLAY");
		buttons.get("quit").setText("QUIT");
		
		for (String key : buttons.keySet()) {
			buttons.get(key).setTextColor(Settings.ButtonTextColor);
			buttons.get(key).setColor(Settings.ButtonBackgroundColor);
			buttons.get(key).setFramingColor(Settings.ButtonBorderColor);
		}
	}
	
	public void createGameField() {
		if (gf != null) {
			gf.stopGameField();
		}
		gf = null;
		gf = new GameField();
	}
		
//paint------------------------------------------------------------------------------------------------------------
	public void draw(Graphics2D g) {
		g.setColor(Settings.windowBackgroundColor);
		g.fillRect(0, 0, 1200, 800);
		
		try {
			gf.setupDraw(g);
		} catch (Exception e) {}
	
		infPanel.draw(g);
	
		for (String key : buttons.keySet()) {
			buttons.get(key).paint(g);
		}
	}
}
