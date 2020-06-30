package Logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

import Infrastructure.Settings;
import Objects.Muellpicker;
import Objects.Player;
import UI.DrawGame;
import libary_version_2.Button;

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
	private ArrayList<Button> buttons = new ArrayList<Button>();

	// butten array muss erstmal durchdeklariert werden damit set oder add mit
	// positionsangabe funktioniert
	public ActionMenu() {
		for (int i = 0; i < 50; i++) {
			buttons.add(null);
		}
		buttons.set(0, new Button(x, y, bWidth, bHeight));
		// moveButtons
		buttons.set(1, new Button(x, y, bWidth, bHeight));
		buttons.set(10, new Button(x, y, bWidth, bHeight));
		buttons.set(11, new Button(x, y + bHeight + 5, bWidth, bHeight));
		buttons.set(12, new Button(x, y + 2 * bHeight + 10, bWidth, bHeight));
		buttons.set(13, new Button(x, y + 3 * bHeight + 15, bWidth, bHeight));
		// attackButtons
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
		// enemys
		buttons.set(47, new Button(x + 80, y + 7 * bHeight + 35, bWidth, bHeight));
		buttons.set(46, new Button(x + 80, y + 6 * bHeight + 30, bWidth, bHeight));
		buttons.set(45, new Button(x + 80, y + 5 * bHeight + 25, bWidth, bHeight));
		buttons.set(44, new Button(x + 80, y + 4 * bHeight + 20, bWidth, bHeight));
		buttons.set(43, new Button(x + 80, y + 3 * bHeight + 15, bWidth, bHeight));
		buttons.set(42, new Button(x + 80, y + 2 * bHeight + 10, bWidth, bHeight));
		buttons.set(41, new Button(x + 80, y + bHeight + 5, bWidth, bHeight));
		buttons.set(40, new Button(x + 80, y, bWidth, bHeight));
		buttonSetup();
	}

	// enemys button werden standartmaessig auf die hintergrundfarbe gesetzt also
	// unsichtbar (hätte man auch mit alpha value machen können)
	public void buttonSetup() {
		//general
		for (int i = 0; i < 50; i++) {
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
		for (int i = 0; i < Surface.getCurrentRoom().roomInventory.size(); i++) {
			System.out.println(Surface.getCurrentRoom().roomInventory.size());
			buttons.get(30 + i).setText(Surface.getCurrentRoom().roomInventory.get(i).getDescription());
		}
		// enemys
		for (int i = 40; i < 50; i++) {
			try {
				buttons.get(i).setColor(new Color(54, 54, 54));
			} catch (Exception e) {
			}
		}

	}

	// setzt selectedButton und malt des frame passend neu
	public void setSelectedButton(int buttonindex) {
		buttons.get(selectedButton).setFramingActive(false);
		selectedButton = buttonindex;
		buttons.get(selectedButton).setFramingActive(true);
	}

	public void move(String direction) {
		switch (direction) {
		case "up":
			setSelectedButton(selectedButton - 1);
			break;
		case "down":
			setSelectedButton(selectedButton + 1);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + direction);
		}
	}

	/*
	 * wird aus Surface/keyhandler aufgerufen wenn ein button gedrueckt wird es wird
	 * der aktive button "gerdueckt" der gedrueckte button wird auf den stack
	 * geschrieben damit spaeter der weg zurueckverfolgt werden kann
	 */
	public void pressButton() {
		switch (selectedButton) {
		case 0:
			actionMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(1);
			break;
		case 1:
			actionMenuActive = false;
			moveMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(10);
			break;
		case 10:
			Surface.player.setY(Surface.player.getY() - 1);
			moveMenuActive = false;
			setSelectedButton(0); // actionsButton
			update();
			break;
		case 11:
			Surface.player.setY(Surface.player.getY() + 1);
			moveMenuActive = false;
			setSelectedButton(0); // actionsButton
			update();
			break;
		case 12:
			Surface.player.setX(Surface.player.getX() + 1);
			moveMenuActive = false;
			setSelectedButton(0); // actionsButton
			update();
			break;
		case 13:
			Surface.player.setX(Surface.player.getX() - 1);
			moveMenuActive = false;
			setSelectedButton(0); // actionsButton
			update();
			break;
		case 2:
			actionMenuActive = false;
			attackMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(20);
			break;
		case 20:
			if (Surface.getCurrentRoom().enemys.size() != 0) {
				enemyMenuActive = true;
				selectedButtonsStack.add(selectedButton);
				setSelectedButton(40);
			}
			break;
		case 21:
			if (Surface.getCurrentRoom().enemys.size() != 0) {
				enemyMenuActive = true;
				selectedButtonsStack.add(selectedButton);
				setSelectedButton(40);
			}
			break;
		case 22:
			if (Surface.getCurrentRoom().enemys.size() != 0) {
				enemyMenuActive = true;
				selectedButtonsStack.add(selectedButton);
				setSelectedButton(40);
			}
			break;
		case 23:
			if (Surface.getCurrentRoom().enemys.size() != 0) {
				enemyMenuActive = true;
				selectedButtonsStack.add(selectedButton);
				setSelectedButton(40);
			}
			break;
		case 40:
			Surface.player.attack(Surface.getCurrentRoom(), 0);
			break;
		case 41:
			Surface.player.attack(Surface.getCurrentRoom(), 1);
			break;
		case 42:
			Surface.player.attack(Surface.getCurrentRoom(), 2);
			break;
		case 43:
			Surface.player.attack(Surface.getCurrentRoom(), 3);
			break;
		case 3:
			actionMenuActive = false;
			pickUpMenuActive = true;
			selectedButtonsStack.add(selectedButton);
			setSelectedButton(30);
			break;
		case 30:
			if (Surface.getCurrentRoom().getItem(0) != null) {
				Surface.player.pickUp(0);
				buttons.get(30).setText("");
				System.out.println();
			}
			break;
		case 31:
			if (Surface.getCurrentRoom().getItem(1) != null) {
				Surface.player.pickUp(1);
				buttons.get(31).setText("");
			}
			break;
		case 32:
			if (Surface.getCurrentRoom().getItem(2) != null) {
				Surface.player.pickUp(2);
				buttons.get(32).setText("");
			}
			break;
		case 33:
			if (Surface.getCurrentRoom().getItem(3) != null) {
				Surface.player.pickUp(3);
				buttons.get(33).setText("");
			}
			break;
		case 34:
			if (Surface.getCurrentRoom().getItem(4) != null) {
				Surface.player.pickUp(4);
				buttons.get(34).setText("");
			}
			break;
		case 35:
			if (Surface.getCurrentRoom().getItem(5) != null) {
				Surface.player.pickUp(5);
				buttons.get(35).setText("");
			}
			break;
		case 36:
			if (Surface.getCurrentRoom().getItem(6) != null) {
				Surface.player.pickUp(6);
				buttons.get(36).setText("");
			}
			break;
		case 37:
			if (Surface.getCurrentRoom().getItem(7) != null) {
				Surface.player.pickUp(7);
				buttons.get(37).setText("");
			}
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
			} catch (Exception e) {
			}
		}
		switch (Surface.getCurrentRoom().enemys.size()) {
		case 4:
			buttons.get(23).setText("enemy4");
		case 3:
			buttons.get(22).setText("enemy3");
		case 2:
			buttons.get(21).setText("enemy2");
		case 1:
			buttons.get(20).setText("enemy1");
		case 0:
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + DrawGame.surface);
		}

		// waffenbuttons
		for (int i = 40; i < 49; i++) {
			try {
				buttons.get(i).setText("");
			} catch (Exception e) {
			}
		}
		switch (Surface.player.getAllWeapons().size()) {
		case 4:
			buttons.get(43).setText("atk: " + Surface.player.getAllWeapons().get(3).getAttackdamage());
		case 3:
			buttons.get(42).setText("atk: " + Surface.player.getAllWeapons().get(2).getAttackdamage());
		case 2:
			buttons.get(41).setText("atk:" + Surface.player.getAllWeapons().get(1).getAttackdamage());
		case 1:
			buttons.get(40).setText("atk:" + Surface.player.getAllWeapons().get(0).getAttackdamage());
		case 0:
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + DrawGame.surface);
		}

		// items in room
		for (int i = 30; i < 49; i++) {
			try {
				buttons.get(i).setText("");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 0; i < Surface.getCurrentRoom().roomInventory.size(); i++) {
			System.out.println(Surface.getCurrentRoom().roomInventory.size());
			buttons.get(30 + i).setText(Surface.getCurrentRoom().roomInventory.get(i).getDescription());
		}

	}

	// *Paint Bereich*//
	public void paint(Graphics2D g) {
		if (actionMenuActive) {
			buttons.get(1).paint(g);
			buttons.get(2).paint(g);
			buttons.get(3).paint(g);
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
				for (int i = 40; i < 50; i++) {
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
		} else {
			buttons.get(0).paint(g);
		}

	}

}
