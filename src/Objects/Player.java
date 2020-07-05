package Objects;

import java.util.ArrayList;

import Logic.Room;
import Logic.Surface;

public class Player {
	
	private int x = 25;
	private int y = 25;
	private int activeSlot = 0;
	public static ArrayList<Item> weapons = new ArrayList<Item>(); //alle items sind kinder von item
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public Player() {
//		inventory.add(new Muellpicker());
//		inventory.add(new Muellpicker());
//		inventory.add(new Muellpicker());
	}
	
	//picks up item from roomInventory
	public void pickUp(int index) {
		if (Surface.getCurrentRoom().getItem(index).getClass() == Muellpicker.class) {
			weapons.add(Surface.getCurrentRoom().getItem(index));
			Surface.getCurrentRoom().roomInventory.set(index, null);
		} else {
			items.add(Surface.getCurrentRoom().getItem(index));
			Surface.getCurrentRoom().roomInventory.set(index, null);
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
	
	public void useItem(int index) {
		items.get(index).doSomeShit();
		items.remove(index);
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
}
