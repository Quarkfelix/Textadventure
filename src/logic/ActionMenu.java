package logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import infrastructure.Main;
import infrastructure.Settings;
import libary_version_2.Button;
import objects.Muellpicker;
import objects.Player;
import ui.DrawGame;

//ausklappmenue mit allen aktionen die in einem Raum moeglich sind 
public class ActionMenu {
	public static int selectedButton = 0;
	private ArrayList<Integer> selectedButtonsStack = new ArrayList<Integer>();
	private int x = 45;
	private int y = 45;
	private int bWidth = 100;
	private int bHeight = 40;
	private boolean actionMenuActive = false;
	private boolean moveMenuActive = false;
	private boolean attackMenuActive = false;
	private boolean pickUpMenuActive = false;
	private boolean enemyMenuActive = false;
	private boolean itemMenuActive = false;
	private boolean itemMenuStage2Active = false;
	private ArrayList<Button> buttons = new ArrayList<Button>();

//constructor------------------------------------------------------------------------------------------------------------
	// butten array muss erstmal durchdeklariert werden damit set oder add mit
	// positionsangabe funktioniert
	public ActionMenu() {
		for (int i = 0; i < 70; i++) {
			buttons.add(null);
		}
		buttons.set(0, new Button(x, y, bWidth, bHeight));
		// moveButtons
		buttons.set(1, new Button(x, y, bWidth, bHeight));
		buttons.set(10, new Button(x, y, bWidth, bHeight));
		buttons.set(11, new Button(x, y + bHeight + 5, bWidth, bHeight));
		buttons.set(12, new Button(x, y + 2 * bHeight + 10, bWidth, bHeight));
		buttons.set(13, new Button(x, y + 3 * bHeight + 15, bWidth, bHeight));
		// enemyButtons
		buttons.set(2, new Button(x, y + bHeight + 5, bWidth, bHeight));
		buttons.set(20, new Button(x, y, bWidth, bHeight));
		buttons.set(21, new Button(x, y + bHeight + 5, bWidth, bHeight));
		buttons.set(22, new Button(x, y + 2 * bHeight + 10, bWidth, bHeight));
		buttons.set(23, new Button(x, y + 3 * bHeight + 15, bWidth, bHeight));
		// pickUpbuttons
		buttons.set(3, new Button(x, y + 2 * bHeight + 10, bWidth, bHeight));
		buttons.set(30, new Button(x, y, bWidth, bHeight));
		buttons.set(31, new Button(x, y + bHeight + 5, bWidth, bHeight));
		buttons.set(32, new Button(x, y + 2 * bHeight + 10, bWidth, bHeight));
		buttons.set(33, new Button(x, y + 3 * bHeight + 15, bWidth, bHeight));
		// weaponButtons
		buttons.set(66, new Button(x + 110, y + 6 * bHeight + 30, bWidth, bHeight));
		buttons.set(65, new Button(x + 110, y + 5 * bHeight + 25, bWidth, bHeight));
		buttons.set(64, new Button(x + 110, y + 4 * bHeight + 20, bWidth, bHeight));
		buttons.set(63, new Button(x + 110, y + 3 * bHeight + 15, bWidth, bHeight));
		buttons.set(62, new Button(x + 110, y + 2 * bHeight + 10, bWidth, bHeight));
		buttons.set(61, new Button(x + 110, y + bHeight + 5, bWidth, bHeight));
		buttons.set(60, new Button(x + 110, y, bWidth, bHeight));
		
		//useButtons
		buttons.set(4, new Button(x, y + 3 * bHeight + 15, bWidth, bHeight));
		buttons.set(40, new Button(x, y, bWidth, bHeight));
		buttons.set(41, new Button(x, y + bHeight + 5, bWidth, bHeight));
		buttons.set(42, new Button(x, y + 2 * bHeight + 10, bWidth, bHeight));
		buttons.set(43, new Button(x, y + 3 * bHeight + 15, bWidth, bHeight));
		buttons.set(44, new Button(x, y + 4 * bHeight + 20, bWidth, bHeight));
		buttons.set(45, new Button(x, y + 5 * bHeight + 25, bWidth, bHeight));
		buttons.set(46, new Button(x, y + 6 * bHeight + 30, bWidth, bHeight));
		buttons.set(48, new Button(x + 110, y, bWidth, bHeight));
		buttons.set(49, new Button(x + 110, y + bHeight + 5, bWidth, bHeight));

		
		buttonSetup();
	}

	
//methods-----------------------------------------------------------------------------------------------------------------	
	// enemys button werden standartmaessig auf die hintergrundfarbe gesetzt also
	// unsichtbar (hÃ¤tte man auch mit alpha value machen kÃ¶nnen)
	public void buttonSetup() {
		//general
		for (int i = 0; i < 70; i++) {
			try {
				buttons.get(i).setFramingActive(false);
				buttons.get(i).setTextFontSize(20);
				buttons.get(i).setColor(new Color(54, 54, 54));
				buttons.get(i).setFramingColor(new Color(225, 0, 0));
				buttons.get(i).setTextColor(Color.black);
			} catch (Exception e) {
			}
		}
		buttons.get(0).setFramingActive(true);
		buttons.get(0).setText("actions");

		// move
		buttons.get(1).setText("move");
		buttons.get(10).setText("UP");
		buttons.get(11).setText("DOWN");
		buttons.get(12).setText("RIGHT");
		buttons.get(13).setText("LEFT");

		// attack
		buttons.get(2).setText("attack");
		
		// pick up
		buttons.get(3).setText("pick Up");
		for (int i = 0; i < Surface.getCurrentRoom().items.size(); i++) {
			buttons.get(30 + i).setText(Surface.getCurrentRoom().items.get(i).getDescription());
		}
		// enemys
		
		//use
		buttons.get(4).setText("use Items");
		buttons.get(48).setText("use");
		buttons.get(49).setText("drop");

	}

	// setzt selectedButton und malt des frame passend neu
	public void setSelectedButton(int buttonindex) {
		buttons.get(selectedButton).setFramingActive(false);
		selectedButton = buttonindex;
		buttons.get(selectedButton).setFramingActive(true);
	}

	public void move(String direction) {
		try {
			switch (direction) {
			case "up":
				if (buttons.get(selectedButton - 1 ) != null) {
					setSelectedButton(selectedButton - 1);
				}
				break;
			case "down":
				if (buttons.get(selectedButton + 1 ) != null) {
					setSelectedButton(selectedButton + 1);
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + direction);
			}	
		} catch (Exception e) {
			System.out.println("please dont do that");
		}
		
	}

	/*
	 * wird aus Surface/keyhandler aufgerufen wenn ein button gedrueckt wird es wird
	 * der aktive button "gerdueckt" der gedrueckte button wird auf den stack
	 * geschrieben damit spaeter der weg zurueckverfolgt werden kann
	 * könnte noch in eine eigen klasse
	 */
	public void pressButton() {
		switch (selectedButton) {
		case 0:
			actionMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(1);
			update();
			break;
			//move menu
		case 1:
			actionMenuActive = false;
			moveMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(10);
			update();
			break;
		case 10:
			Surface.player.setY(Surface.player.getY() - 1);
			checkEnteredRoom();
			moveMenuActive = false;
			setSelectedButton(0); // actionsButton
			update();
			break;
		case 11:
			Surface.player.setY(Surface.player.getY() + 1);
			checkEnteredRoom();
			moveMenuActive = false;
			setSelectedButton(0); // actionsButton
			update();
			break;
		case 12:
			Surface.player.setX(Surface.player.getX() + 1);
			checkEnteredRoom();
			moveMenuActive = false;
			setSelectedButton(0); // actionsButton
			update();
			break;
		case 13:
			Surface.player.setX(Surface.player.getX() - 1);
			checkEnteredRoom();
			moveMenuActive = false;
			setSelectedButton(0); // actionsButton
			update();
			break;
			//attack/enemys
		case 2:
			actionMenuActive = false;
			attackMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(20);
			update();
			break;
		case 20:
			if (Surface.getCurrentRoom().enemys.size() != 0) {
				enemyMenuActive = true;
				selectedButtonsStack.add(selectedButton);
				Surface.getCurrentRoom().untagEnemys();
				Surface.getCurrentRoom().enemys.get(0).setTagged(true);
				setSelectedButton(60);
				update();
			}
			break;
		case 21:
			if (Surface.getCurrentRoom().enemys.size() != 0) {
				enemyMenuActive = true;
				selectedButtonsStack.add(selectedButton);
				Surface.getCurrentRoom().untagEnemys();
				Surface.getCurrentRoom().enemys.get(1).setTagged(true);
				setSelectedButton(60);
				update();
			}
			break;
		case 22:
			if (Surface.getCurrentRoom().enemys.size() != 0) {
				enemyMenuActive = true;
				selectedButtonsStack.add(selectedButton);
				Surface.getCurrentRoom().untagEnemys();
				Surface.getCurrentRoom().enemys.get(2).setTagged(true);
				setSelectedButton(60);
				update();
			}
			break;
		case 23:
			if (Surface.getCurrentRoom().enemys.size() != 0) {
				enemyMenuActive = true;
				selectedButtonsStack.add(selectedButton);
				Surface.getCurrentRoom().untagEnemys();
				Surface.getCurrentRoom().enemys.get(3).setTagged(true);
				setSelectedButton(60);
				update();
			}
			break;
		case 60:
			Surface.player.attack(Player.weapons.get(0));
			Player.weapons.remove(0);
			update();
			break;
		case 61:
			Surface.player.attack(Player.weapons.get(1));
			Player.weapons.remove(1);
			update();
			break;
		case 62:
			Surface.player.attack(Player.weapons.get(2));
			Player.weapons.remove(2);
			update();
			break;
		case 63:
			Surface.player.attack(Player.weapons.get(3));
			Player.weapons.remove(3);
			update();
			break;
			//pick up
		case 3:
			actionMenuActive = false;
			pickUpMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(30);
			update();
			break;
		case 30:
			try {
				Surface.player.pickUp(0);
			} catch (Exception e) {}
			buttons.get(30).setText("");
			update();
			break;
		case 31:
			try {
				Surface.player.pickUp(1);
			} catch (Exception e) {}
			buttons.get(31).setText("");
			update();
			break;
		case 32:
			try {
				Surface.player.pickUp(2);
			} catch (Exception e) {}
			buttons.get(32).setText("");
			update();
			break;
		case 33:
			try {
				Surface.player.pickUp(3);
			} catch (Exception e) {}
			buttons.get(34).setText("");
			update();
			break;
		case 34:
			try {
				Surface.player.pickUp(4);
			} catch (Exception e) {}
			buttons.get(34).setText("");
			update();
			break;
		case 35:
			try {
				Surface.player.pickUp(5);
			} catch (Exception e) {}
			buttons.get(35).setText("");
			update();
			break;
		case 36:
			try {
				Surface.player.pickUp(6);
			} catch (Exception e) {}
			buttons.get(36).setText("");
			update();
			break;
		case 37:
			try {
				Surface.player.pickUp(7);
			} catch (Exception e) {}
			buttons.get(37).setText("");
			update();
			break;
			//item use
		case 4: 
			actionMenuActive = false;
			itemMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(40);
			update();
			break;
		case 40:
			Surface.player.setSelectedItem(0);
			selectedButtonsStack.add(selectedButton);
			itemMenuStage2Active = true;
			setSelectedButton(48);
			update();
			break;
		case 41:
			Surface.player.setSelectedItem(1);
			selectedButtonsStack.add(selectedButton);
			itemMenuStage2Active = true;
			setSelectedButton(48);
			update();
			break;
		case 42:
			Surface.player.setSelectedItem(2);
			selectedButtonsStack.add(selectedButton);
			itemMenuStage2Active = true;
			setSelectedButton(48);
			update();
			break;
		case 43:
			Surface.player.setSelectedItem(3);
			selectedButtonsStack.add(selectedButton);
			itemMenuStage2Active = true;
			setSelectedButton(48);
			update();
			break;
		case 44:
			Surface.player.setSelectedItem(4);
			selectedButtonsStack.add(selectedButton);
			itemMenuStage2Active = true;
			setSelectedButton(48);
			update();
			break;
		case 45:
			Surface.player.setSelectedItem(5);
			selectedButtonsStack.add(selectedButton);
			itemMenuStage2Active = true;
			setSelectedButton(48);
			update();
			break;
		case 46:
			Surface.player.setSelectedItem(6);
			selectedButtonsStack.add(selectedButton);
			itemMenuStage2Active = true;
			setSelectedButton(48);
			update();
			break;
		case 48:
			Surface.player.useItem();
			update();
			break;
		case 49: 
			Surface.player.dropItem();
			update();
			break;

		default:
			System.out.println("fehler in der buttonaktionszuweisung");
			throw new IllegalArgumentException("Unexpected value: " + selectedButton);
		}
	}

	/*
	 * wird aufgerufen wenn in Surface der B button gedrueckt wird. setzt die
	 * untermenues aktiv und deaktiviert sie. (wurde so gemacht aufgrund von damals
	 * nicht vorhandner funktion in button klasse) wenn ein menue zurueckgegangen
	 * wird wird vom stack die letzte butttonnummer genommen und aktiv gesetzt.
	 * anschliesssend wird die nummer geloescht.
	 */
	public void back() {
		if (actionMenuActive) {
			actionMenuActive = false;
			setSelectedButton(selectedButtonsStack.get(selectedButtonsStack.size() - 1)); // actionsButton
		}
		if (moveMenuActive) {
			moveMenuActive = false;
			actionMenuActive = true;
			setSelectedButton(selectedButtonsStack.get(selectedButtonsStack.size() - 1)); // moveButton
		}
		if (attackMenuActive && !enemyMenuActive) {
			attackMenuActive = false;
			actionMenuActive = true;
			setSelectedButton(selectedButtonsStack.get(selectedButtonsStack.size() - 1)); // attackButton
		}
		if (pickUpMenuActive) {
			pickUpMenuActive = false;
			actionMenuActive = true;
			setSelectedButton(selectedButtonsStack.get(selectedButtonsStack.size() - 1)); // pickUpButton
		}
		if (enemyMenuActive) {
			enemyMenuActive = false;
			setSelectedButton(selectedButtonsStack.get(selectedButtonsStack.size() - 1)); //vorheriger button
		}
		if (itemMenuStage2Active) {
			itemMenuStage2Active = false;
			setSelectedButton(selectedButtonsStack.get(selectedButtonsStack.size() - 1));
		} else if(itemMenuActive) {
			itemMenuActive = false;
			actionMenuActive = true;
			setSelectedButton(selectedButtonsStack.get(selectedButtonsStack.size() - 1));
		}
		
		selectedButtonsStack.remove(selectedButtonsStack.size() - 1);
	}

	/*
	 * hier kommt alles rein was bei raumbeginn oder so erneuert werden muss
	 */
	public void update() {
		// enemybuttons
		for (int i = 20; i < 29; i++) {
			try {
				buttons.get(i).setText("");
				buttons.get(i).setColor(new Color(54, 54, 54));
			} catch (Exception e) {}
		}
		switch (Surface.getCurrentRoom().enemys.size()) {
		case 4:
			if (Surface.getCurrentRoom().enemys.get(3).isAlive()) {
				buttons.get(23).setText("HP: " + Surface.getCurrentRoom().enemys.get(3).getHealth());
			}			
		case 3:
			if (Surface.getCurrentRoom().enemys.get(2).isAlive()) {
				buttons.get(22).setText("HP: " + Surface.getCurrentRoom().enemys.get(2).getHealth());
			}
		case 2:
			if (Surface.getCurrentRoom().enemys.get(1).isAlive()) {
				buttons.get(21).setText("HP: " + Surface.getCurrentRoom().enemys.get(1).getHealth());
			}			
		case 1:
			if (Surface.getCurrentRoom().enemys.get(0).isAlive()) {
				buttons.get(20).setText("HP: " + Surface.getCurrentRoom().enemys.get(0).getHealth());
			}
		case 0:
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + DrawGame.surface);
		}

		// weaponbuttons
		for (int i = 60; i < 70; i++) {
			try {
				buttons.get(i).setText("");
			} catch (Exception e) {
			}
		}
		try {
			switch (Player.weapons.size()) {
			case 7:
				buttons.get(66).setText("atk: " + Player.weapons.get(6).getAttackdamage());
			case 6:
				buttons.get(65).setText("atk: " + Player.weapons.get(5).getAttackdamage());
			case 5:
				buttons.get(64).setText("atk: " + Player.weapons.get(4).getAttackdamage());
			case 4:
				buttons.get(63).setText("atk: " + Player.weapons.get(3).getAttackdamage());
			case 3:
				buttons.get(62).setText("atk: " + Player.weapons.get(2).getAttackdamage());
			case 2:
				buttons.get(61).setText("atk:" + Player.weapons.get(1).getAttackdamage());
			case 1:
				buttons.get(60).setText("atk:" + Player.weapons.get(0).getAttackdamage());
			case 0:
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + Player.weapons.size());
			}
		} catch (Exception e) {
			System.out.println("weapons full");
		}
		

		// items in room
		for (int i = 30; i < 47; i++) {
			try {
				buttons.get(i).setText("");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		Room cRoom = Surface.getCurrentRoom();
		for (int i = 0; i < cRoom.weapons.size(); i++) {
			try {
				buttons.get(30 + i).setText(cRoom.weapons.get(i).getDescription());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 0; i < cRoom.items.size(); i++) {
			try {
				buttons.get(30 + cRoom.weapons.size() + i).setText(Surface.getCurrentRoom().items.get(i).getDescription());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//itembuttons
		try {
			buttons.get(40).setText(Player.items.get(0).getDescription());
			buttons.get(41).setText(Player.items.get(1).getDescription());
			buttons.get(42).setText(Player.items.get(2).getDescription());
			buttons.get(43).setText(Player.items.get(3).getDescription());
			buttons.get(44).setText(Player.items.get(4).getDescription());
			buttons.get(45).setText(Player.items.get(5).getDescription());
			buttons.get(46).setText(Player.items.get(6).getDescription());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void checkEnteredRoom() {
		if(Surface.getCurrentRoom().hasSecretDoor) {
			Main.mc.playSound("soundeffects2", "File 1");
		}
	}
	
	
//paint---------------------------------------------------------------------------------------------------------------------	
	public void paint(Graphics2D g) {
		
		//hab ich damals schlampig gearbeitet weil es als switch case besser gewesen wäre(weniger laufzeit)
		if (actionMenuActive) {
			buttons.get(1).paint(g);
			buttons.get(2).paint(g);
			buttons.get(3).paint(g);
			buttons.get(4).paint(g);
		} else if (moveMenuActive) {
			for (int i = 10; i < 20; i++) {
				try {
					buttons.get(i).paint(g);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else if (attackMenuActive) {
			for (int i = 20; i < 30; i++) {
				try {
					buttons.get(i).paint(g);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if (enemyMenuActive) {
				for (int i = 60; i < 70; i++) {
					try {
						buttons.get(i).paint(g);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		} else if (pickUpMenuActive) {
			for (int i = 30; i < 40; i++) {
				try {
					buttons.get(i).paint(g);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else if(itemMenuActive) {
			for (int i = 40; i < 47; i++) {
				try {
					buttons.get(i).paint(g);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if (itemMenuStage2Active) {
				buttons.get(48).paint(g);
				buttons.get(49).paint(g);
			}
		}else {
			buttons.get(0).paint(g);
		}

	}

}
