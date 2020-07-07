package infrastructure;

import libary_version_2.MusicController;
import libary_version_2.MusicPlayer;
import ui.GUI;

public class Main {
	public static GUI gui;
	public static MusicController mc;
	
	public static void main(String[] args) {
		musicSetup();
		
		gui = new GUI();
		gui.create();
		
		RepaintThread t = new RepaintThread();
		t.start();	
		
		
	}
	
	public static void musicSetup() {
		mc = new MusicController();
		mc.start();
		
		mc.newPlaylist("backgroundMusic", new String[] {"res/bm.wav", "res/bm2.wav", "res/bm3.wav"});
		mc.setVolume("backgroundMusic", 0.2);
		mc.startLooping("backgroundMusic");
		
		mc.newPlaylist("soundeffects", new String[] {"res/ooof.wav"});
		mc.playSound("soundeffects", "File 1");
	}
}