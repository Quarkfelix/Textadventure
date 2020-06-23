package Objects;

import java.util.ArrayList;

import Logic.Room;

public class Player {
	
	private int x = 25;
	private int y = 25;
	private int activeSlot = 0;
	public static ArrayList<Item> inventory = new ArrayList<Item>(); //alle items sind kinder von item
	
	public Player() {
		inventory.add(new Müllpicker());
		inventory.add(new Müllpicker());
	
	}
	
	/*
	 * Greift ausgewählten gegner mit ausgewählen müllpicker an.
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
