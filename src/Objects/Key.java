package Objects;

import Logic.Surface;

public class Key extends Item{
	public static final double spawnchance = 0.0;
	public String description = "Key"; //this variable will be changed for the different kinds of keys
	
	@Override
	public double getSpawnchance() {
		return spawnchance;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void doSomeShit() {
		if(Surface.getCurrentRoom().hasSecretDoor) {
			System.out.println("Secret room");
		}
	}
}
