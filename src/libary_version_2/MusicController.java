package libary_version_2;

import java.util.ArrayList;
import java.util.HashMap;

//über music controller werden lieder abgespielt. wenn ein lied/sound abgespielt werden soll wird ein neuer MusicPlayer 
//erstellt welcher dann seinen sound apspielt.
//im controller wird auch festgelegt ob loop alle sounds oder nur einen.

public class MusicController extends Thread{
	private HashMap<String, MusicPlayer> musicPlayer = new HashMap<String, MusicPlayer>();
	private boolean loopall = false;
	private boolean loopsingle = false;

//constructor------------------------------------------------------------------------------------------------------------
	public MusicController() {
		super.start();
	}
	
//run Method------------------------------------------------------------------------------------------------------------
	public void run() {
	}
	
//methods---------------------------------------------------------------------------------------------------------------
	public void play(String url) {
		musicPlayer.put(null, new MusicPlayer(url)); //könnte fehler wegen ersetzen geben
	}

	public void newPlayer(String name, String url) {
		musicPlayer.put(name, new MusicPlayer(url));
	}
	
	public void newPlaylist(String name, String[] urls) {
		musicPlayer.put(name, new MusicPlayer(urls));
	}
	
	public void start(String name) {
		musicPlayer.get(name).start();
	}

	
	
	
	
	
//getter-and-setter------------------------------------------------------------------------------------------------------
	
	//lässt einen music Thread alle songs loopen
	public void setLoop(String player, boolean state) {
		musicPlayer.get(player).setLoop(state);
	}
	
	public void setVolume(String player, double volume) {
		musicPlayer.get(player).setVolume((float)volume);
	}
	
}




