package objects;

import infrastructure.Settings;

public class Enemy {
	private boolean tagged = false;
	private boolean alive = true;
	private int health;
	private int attackdamage;
	
	public Enemy() {
		health = Settings.enemyHealth;
		attackdamage = Settings.enemyAttackdamage;
	}
	
	/*
	 *	wird aus anderen klassen aufgerufen wenn ein enemy damage nehmen soll 
	 */
	public void takedamage(int damage) {
		health -= damage;
		if(health <= 0) {
			setAlive(false);
		}
		System.out.println("health: " + health);
	}

	public boolean isTagged() {
		return tagged;
	}

	public void setTagged(boolean tagged) {
		this.tagged = tagged;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public int getHealth() {
		return health;
	}
}
