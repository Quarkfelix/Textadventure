package objects;

import logic.Surface;
import snake_infrastructure.SnakeGame;

public class Key extends Item{
	public static final double spawnchance = 0.0;
	public String description = "Key"; //this variable will be changed for the different kinds of keys
	
//methods------------------------------------------------------------------------------------------------------------
	@Override
	public void doSomeShit() {
		if(Surface.getCurrentRoom().hasSecretDoor) {
			SnakeGame secretGame = new SnakeGame();
		}
	}
	
	
//getter-setter------------------------------------------------------------------------------------------------------------
	@Override
	public double getSpawnchance() {
		return spawnchance;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
}
