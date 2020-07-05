package Logic;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Infrastructure.Settings;
import Objects.Enemy;
import Objects.Item;
import Objects.Key;
import Objects.Muellpicker;
import Objects.Potion;

//content of room is displayed in TextArea in Surface
public class Room {
	private int randomZahl;
	public boolean hasSecretDoor = false;
	public String story = "";
	public String name = "";
	public ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	public ArrayList<Item> roomInventory = new ArrayList<Item>();
	
	public Room() {
		roomsetup();
		createItems();
		enemysetup();
	}
	
	public void createItems() {		
		//attack
		if(Math.random() <= Settings.muellpickerSpawnchance) {
			roomInventory.add(new Muellpicker());
		}
		
		//heal
		if(Math.random() <= Settings.potionSpawnchance) {
			roomInventory.add(new Potion());
		}
		
		//key
		if(Math.random() <= Settings.keySpawnchance) {
			roomInventory.add(new Key());
		}
	
	}
	
	//fügt zwischen 0 und 4 gener in den raum hinzu
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
	 *	Dem erstellten Raum wird eine von 6 moeglichen storys zugewiesen.
	 */
	private void roomsetup() {
		randomZahl = (int)((Math.random()) * 6 + 1); //zahl von 1 bis 6
		switch (randomZahl) {
		case 1:
			name = "Kueche";
			story = "Kueche";
			break;
		case 2:
			name = "Badezimmer";
			story = "Badezimmer";
			break;
		case 3:
			name = "Arbeitszimmer";
			story = "Arbeitszimmer";
			break;
		case 4:
			name = "Esszimmer";
			story = "Esszimmer";
			break;
		case 5:
			name = "Spielzimmer";
			story = "Spielzimmer";
			break;
		case 6:
			name = "SchalfZimmer";
			story = "SchalfZimmer";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + randomZahl);
		}
		
		if ((Math.random()) <= Settings.secretDoorSpawnChance) {
			hasSecretDoor = true;
			System.out.println("secret");
		}
	}
	
	public void untagEnemys() {
		for (Enemy enemy : enemys) {
			enemy.setTagged(false);
		}
	}
	
	public Item getItem(int index) {
		return roomInventory.get(index);
	}
	
	public void paint(Graphics2D g) {

	}
	
}
