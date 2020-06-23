package Objects;

import Infrastructure.Settings;

public class Müllpicker extends Item {
	private int rarity = 1;
	private int attackdamage;

	public Müllpicker() {
		assignRarity();
	}

	/*
	 * legt seltenheit des müllpickers bei erzeugung fest
	 * schaden wird je nach rarity festgelegt 
	 * wird nur einmal aus dem konstruktor aufgerufen
	 */
	private void assignRarity() {
		int randomZahl = (int)((Math.random()) * 10 + 1);
		if(randomZahl <= 5) {
			rarity = 1;
			setAttackdamage(Settings.müllpickerAttackdamageLVL1);
		} else if (randomZahl <= 9) {
			rarity = 2;
			setAttackdamage(Settings.müllpickerAttackdamageLVL2);
		} else if (randomZahl <= 10) {
			rarity = 3;
			setAttackdamage(Settings.müllpickerAttackdamageLVL3);
		}
	}

	
	
	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	@Override
	public int getAttackdamage() {
		return attackdamage;
	}

	public void setAttackdamage(int attackdamage) {
		this.attackdamage = attackdamage;
	}
}
