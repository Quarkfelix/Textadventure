package logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;

import libary_version_2.Button;
import ui.DrawGame;

public class ControlPad {
	private int x, y;
	private HashMap<String, Button> buttons = new HashMap<String, Button>();
	
//constructor-------------------------------------------------------------------------------------------------------
	public ControlPad(int x, int y) {
		this.x = x;
		this.y = y;
		buttonSetup();
	}
	

//methods------------------------------------------------------------------------------------------------------------
	//Setup der Buttons in D-Pad form. 
	private void buttonSetup() {
		buttons.put("up", new Button(40 + x, y, 30, 40));
		buttons.get("up").setColor(new Color(28, 28, 28));
		buttons.get("up").setFramingColor(new Color(28, 28, 28));
		
		buttons.put("down", new Button(40 + x, 70 + y, 30, 40));
		buttons.get("down").setColor(new Color(28, 28, 28));
		buttons.get("down").setFramingColor(new Color(28, 28, 28));
		
		buttons.put("right", new Button(70 + x, 40 + y, 40, 30));
		buttons.get("right").setColor(new Color(28, 28, 28));
		buttons.get("right").setFramingColor(new Color(28, 28, 28));
		
		buttons.put("left", new Button(x, 40 + y, 40, 30));
		buttons.get("left").setColor(new Color(28, 28, 28));
		buttons.get("left").setFramingColor(new Color(28, 28, 28));
		
		buttons.put("middle", new Button(40 + x, 40 + y, 30, 30));
		buttons.get("middle").setColor(new Color(28, 28, 28));
		buttons.get("middle").setFramingColor(new Color(28, 28, 28));
	}
	
	/*
	 *	Kann aus anderen Klassen aufgerufen werden um zu schauen ob da ControlPad gedrueckt wurde. 
	 *	es wird der bereich zurueckgegeben der gedrueckt wurde oder NAN wenn nichts gedrueckt wurde.
	 */
	public String checkButtonPress(int x, int y) {
		if (buttons.get("up").contains(x, y)) {
			return "up";
		} else if (buttons.get("down").contains(x, y)) {
			return "down";
		} else if (buttons.get("right").contains(x, y)) {
			return "right";
		} else if (buttons.get("left").contains(x, y)) {
			return "left";
		} else {
			return "NAN";
		}	
	}
	
	
//paint------------------------------------------------------------------------------------------------------------
	public void paint(Graphics2D g) {
		buttons.get("up").paint(g);
		buttons.get("down").paint(g);
		buttons.get("right").paint(g);
		buttons.get("left").paint(g);
		buttons.get("middle").paint(g);
	}
	
}
