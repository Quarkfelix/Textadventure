package objects;

public class Potion extends Item{
	public final double spawnchance = 0.0;
	public String description = "Potion"; //this variable will be changed for the different kinds of potions
	
//methods------------------------------------------------------------------------------------------------------------
	@Override
	public void doSomeShit() {
		
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
