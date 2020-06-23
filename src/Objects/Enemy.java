package Objects;

import Infrastructure.Settings;

public class Enemy {
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
		System.out.println("health: " + health);
	}
}
