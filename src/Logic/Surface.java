package Logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Infrastructure.Settings;
import Objects.Player;
import libary_version_2.Button;
import libary_version_2.MusicPlayer;
import libary_version_2.TextArea;

public class Surface {
	public TextArea textArea;

	public ControlPad controlPad;
	private Button aButton;
	private Button bButton;
	public static Room[][] rooms;
	public static Player player;
	public static ActionMenu actionMenu;
	public static MusicPlayer mp;
	
	public Surface() {
		mp = new MusicPlayer("res/gmbs.wav");
		rooms = new Room[50][50];
		roomSetup();
		player = new Player();
		actionMenu = new ActionMenu();
		textArea = new TextArea(Settings.textAreaX, Settings.textAreaY, Settings.textAreaWidth, Settings.textAreaHeight);
		textArea.setBackgroundColor(Settings.displayColor);
		textArea.setThicness(15);
		textArea.setFramingColor(new Color(31, 31, 31));
		controlPad = new ControlPad(Settings.controlPadX, Settings.controlPadY);
		buttonSetup();
		updateTextAreas();
	}
	
	public static Room getCurrentRoom() {
		return rooms[player.getX()][player.getY()];
	}
	
	/*
	 * erstellt die raeume. wird einmal beim programmstart durch konstruktor aufgerufen
	 */
	private void roomSetup() {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				rooms[i][j] = new Room();
			}
		}
		try {
			updateTextAreas();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Rooms created");
	}
	
	//a und b butons werden erstellt. wird einmal beim programmstart durch konstruktor aufgerufen
	private void buttonSetup() {
		aButton = new Button(Settings.aButtonX,Settings.aButtonY, Settings.aButtonWidth, Settings.aButtonHeight, Settings.aButtonAngle);
		aButton.setOval(true);
		aButton.setText("A");
		aButton.setTextFontSize(30);
		aButton.setColor(new Color(171, 14, 48));
		aButton.setFramingColor(new Color(171, 14, 48));
		aButton.setTextColor(new Color(0,0,0));
		
		bButton = new Button(Settings.bButtonX,Settings.bButtonY, Settings.bButtonWidth, Settings.bButtonHeight, Settings.bButtonAngle);
		bButton.setOval(true);
		bButton.setText("B");
		bButton.setTextFontSize(30);
		bButton.setColor(new Color(171, 14, 48));
		bButton.setFramingColor(new Color(171, 14, 48));
		bButton.setTextColor(new Color(0,0,0));
	}
	
	/*
	 * mit dieser methode kann �berpr�ft werden ob ein Button gedr�ckt wurde
	 * wenn a button gedr�ckt wurde wird im actionMenu der aktive button gedr�ckt 
	 * wenn b button gedr�ckt wird, wird ins vorhherige men� zur�ckgegangen und der zuletzt ausgew�hlte button markiert
	 * wenn auf controlPad up oder down gedr�ckt wird, wird der button dr�ber oder drunter aktiv gesetzt.
	*/
	public void checkButtonPress(int x, int y) {
		if(aButton.contains(x, y)) {
			actionMenu.pressButton();
			updateTextAreas();
			System.out.println("A Button");
		}
		if(bButton.contains(x, y)) {
			actionMenu.back();
			System.out.println("B Button");
		}
		
		switch (controlPad.checkButtonPress(x, y)) {
		case "up":
			actionMenu.move("up");
			break;
		case "down":
			actionMenu.move("down");
			break;
		case "right":
			System.out.println("right");
			break;
		case "left":
			System.out.println("left");
		break;
		case "NAN":
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + controlPad.checkButtonPress(x, y));
		}
	}
	
	/*
	 * Textarea wird im aktuellen raum aktualisiert 
	 */
	public void updateTextAreas() {
		textArea.setText(rooms[player.getX()][player.getY()].story);
	}
	
	
	
	
	//  *paint bereich* //
	public void paint(Graphics2D g) {
		rooms[player.getX()][player.getY()].paint(g);
		textArea.paint(g);
		actionMenu.paint(g);
		controlPad.paint(g);
		aButton.paint(g);
		bButton.paint(g);
		
	}

}
