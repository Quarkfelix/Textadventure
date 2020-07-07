package logic;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import infrastructure.Settings;
import objects.Enemy;
import objects.Item;
import objects.Key;
import objects.Muellpicker;
import objects.Potion;

//content of room is displayed in TextArea in Surface
public class Room {
	private int randomZahl;
	public boolean hasSecretDoor = false;
	public String story = "";
	public String name = "";
	public ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	public ArrayList<Item> weapons = new ArrayList<Item>();
	public ArrayList<Item> items = new ArrayList<Item>();
	
	
//constructor------------------------------------------------------------------------------------------------------------
	public Room() {
		roomsetup();
		createItems();
		enemysetup();
	}
	

//methods------------------------------------------------------------------------------------------------------------
	public void createItems() {		
		//attack
		if(Math.random() <= Settings.muellpickerSpawnchance) {
			weapons.add(new Muellpicker());
		}
		
		//heal
		if(Math.random() <= Settings.potionSpawnchance) {
			items.add(new Potion());
		}
		
		//key
		if(Math.random() <= Settings.keySpawnchance) {
			items.add(new Key());
		}
	
	}
	
	//fuegt zwischen 0 und 4 gener in den raum hinzu
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
	
	
	//Dem erstellten Raum wird eine von 6 moeglichen storys zugewiesen.
	private void roomsetup() {
		randomZahl = (int)((Math.random()) * 6 + 1); //zahl von 1 bis 6
		switch (randomZahl) {
		case 1:
			name = "Black";
			story = "Black Room";
			break;
		case 2:
			name = "White";
			story = "White Room";
			break;
		case 3:
			name = "Red";
			story = "Red Room";
			break;
		case 4:
			name = "Blue";
			story = "Blue Room";
			break;
		case 5:
			name = "Pink";
			story = "Pink Room";
			break;
		case 6:
			name = "Green";
			story = "Green Room";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + randomZahl);
		}
		
		if ((Math.random()) <= Settings.secretDoorSpawnChance) {
			hasSecretDoor = true;
		}
	}
	
	public void untagEnemys() {
		for (Enemy enemy : enemys) {
			enemy.setTagged(false);
		}
	}
	
	
//getter-setter------------------------------------------------------------------------------------------------------------
	public Item getItem(int index) {
		return items.get(index);
	}
	
	public Item getWeapon(int index) {
		return weapons.get(index);
	}
	
	public void paint(Graphics2D g) {

	}
	
}
