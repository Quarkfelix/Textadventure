package infrastructure;

import libary_version_2.MusicController;
import libary_version_2.MusicPlayer;
import ui.GUI;

public class Main {
	public static GUI gui;
	public static MusicController mc;
	public static RepaintThread t;
	
	public static void main(String[] args) {
		musicSetup();
		
		gui = new GUI();
		gui.create();
		
		t = new RepaintThread();		
	}
	
	public static void musicSetup() {
		mc = new MusicController();
		mc.start();
		
		mc.newPlaylist("backgroundMusic", new String[] {"res/bm.wav", "res/bm2.wav", "res/bm3.wav"});
		mc.setVolume("backgroundMusic", 0.3);
		mc.startLooping("backgroundMusic");
		
		mc.newPlaylist("soundeffects", new String[] {"res/enterSound.wav", "res/moveSound.wav", "res/backSound.wav"});
		mc.setVolume("soundeffects", 0.6);
		
		mc.newPlaylist("soundeffects2", new String[] {"res/secretRoomSound.wav", "res/attackSound.wav"});
		mc.setVolume("soundeffects2", 0.3);
	}
}