package Objects;

import java.util.ArrayList;

import Logic.Room;
import Logic.Surface;

public class Player {
	
	private int x = 25;
	private int y = 25;
	private int selectedItem = 0;
	public static ArrayList<Item> weapons = new ArrayList<Item>(); //alle items sind kinder von item
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public Player() {

	}
	
	public void pickUp(int index) {
		if (Surface.getCurrentRoom().weapons.size() >= index+1) {
			weapons.add(Surface.getCurrentRoom().getWeapon(index));
			Surface.getCurrentRoom().weapons.remove(index);	
		} else {
			items.add(Surface.getCurrentRoom().getItem(index-Surface.getCurrentRoom().weapons.size()));
			Surface.getCurrentRoom().items.remove(index-Surface.getCurrentRoom().weapons.size());
		}
	}

	/*
	 * Greift ausgewaehlten gegner mit ausgewaehlen muellpicker an.
	 */
	public void attack(Item weapon) {
		for (Enemy enemy : Surface.getCurrentRoom().enemys) {
			if (enemy.isTagged() && enemy.isAlive()) {
				enemy.takedamage(weapon.getAttackdamage());
			}
		}
	}
	
	public void useItem() {
		items.get(selectedItem).doSomeShit();
		items.remove(selectedItem);
	}
	
	public void dropItem() {
		Surface.getCurrentRoom().items.add(items.get(selectedItem));
		items.remove(selectedItem);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(int selectedItem) {
		this.selectedItem = selectedItem;
	}
}
