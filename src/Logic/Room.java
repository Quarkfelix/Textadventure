package Logic;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Infrastructure.Settings;
import Objects.Enemy;

public class Room {
	private int randomZahl;
	public String story = "";
	public String name = "";
	public ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	public Room() {
		roomsetup();
		enemysetup();
	}
	
	
	private void enemysetup() {
		randomZahl = (int)((Math.random()) * 4); //zahl von 0 bis 4\
		switch (randomZahl) {
		case 4:
			enemys.add(new Enemy());
		case 3:
			enemys.add(new Enemy());
		case 2:
			enemys.add(new Enemy());
		case 1:
			enemys.add(new Enemy());
		case 0: 
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + randomZahl);
		}
	}
	
	/*
	 *	Dem erstellten Raum wird eine von 6 möglichen storys zugewiesen.
	 */
	private void roomsetup() {
		randomZahl = (int)((Math.random()) * 6 + 1); //zahl von 1 bis 6
		switch (randomZahl) {
		case 1:
			name = "Küche";
			story = "In der Küche liegt ein blutiges Messer. Was ist hier wohl passiert?";
			break;
		case 2:
			name = "Badezimmer";
			story = "Hier liegt eine Haarbürste.";
			break;
		case 3:
			name = "Arbeitszimmer";
			story = "Ein mann starrt dich an.";
			break;
		case 4:
			name = "Esszimmer";
			story = "Überall liegen Brotkrümel. hoffentlich zieht das keine ratten an!";
			break;
		case 5:
			name = "Spielzimmer";
			story = "Jemand benutzt gerade die VR Brille.";
			break;
		case 6:
			name = "SchalfZimmer";
			story = "Auf dem Bett liegt ein Frau und Schläft.";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + randomZahl);
		}
	}
	
	
	
	public void paint(Graphics2D g) {

	}
	
}
