package infrastructure;

import libary_version_2.MusicController;
import libary_version_2.MusicPlayer;
import ui.GUI;

public class Main {
	public static GUI gui;
	public static MusicController mc;
	
	public static void main(String[] args) {
		mc = new MusicController();
		mc.newPlaylist("backgroundMusic", new String[] {"res/bm.wav", "res/bm2.wav", "res/bm3.wav"});
		mc.setLoop("backgroundMusic", true);
		mc.setVolume("backgroundMusic", 0.3);
		mc.start("backgroundMusic");
		
		gui = new GUI();
		gui.create();
		
		RepaintThread t = new RepaintThread();
		t.start();
	}
}