package Objects;

import java.util.ArrayList;

import Logic.Room;
import Logic.Surface;

public class Player {
	
	private int x = 25;
	private int y = 25;
	private int activeSlot = 0;
	public static ArrayList<Item> inventory = new ArrayList<Item>(); //alle items sind kinder von item
	
	public Player() {
		inventory.add(new Muellpicker());
		inventory.add(new Muellpicker());
	
	}
	
	//picks up item from roomInventory
	public void pickUp(int index) {
		inventory.add(Surface.getCurrentRoom().getItem(index));
		//Surface.getCurrentRoom().roomInventory.set(index, null);
		System.out.println(inventory.size());
	}
	
	/*
	 * Greift ausgewaehlten gegner mit ausgewaehlen muellpicker an.
	 */
	public void attack(Room room, int enemyToAttack) {
		room.enemys.get(enemyToAttack).takedamage(inventory.get(activeSlot).getAttackdamage());
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
