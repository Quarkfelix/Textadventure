package Objects;

public class Key extends Item{
	public static final double spawnchance = 0.1;
	public String description = "Key"; //this variable will be changed for the different kinds of keys
	
	@Override
	public double getSpawnchance() {
		return spawnchance;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
}
