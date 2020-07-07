package objects;

import infrastructure.Main;
import infrastructure.Settings;

public class Enemy {
	private boolean tagged = false;
	private boolean alive = true;
	private int health;
	private int attackdamage;

	
//constructor------------------------------------------------------------------------------------------------------------
	public Enemy() {
		health = Settings.enemyHealth;
		attackdamage = Settings.enemyAttackdamage;
	}
	
	
//methods-----------------------------------------------------------------------------------------------------------------
	//wird aus anderen klassen aufgerufen wenn ein enemy damage nehmen soll 
	public void takedamage(int damage) {
		Main.mc.playSound("soundeffects2", "File 2");
		health -= damage;
		if(health <= 0) {
			setAlive(false);
		}
		System.out.println("health: " + health);
	}

	
//getter-setter------------------------------------------------------------------------------------------------------------
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
