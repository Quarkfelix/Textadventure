package infrastructure;

import ui.GUI;

public class Main {
	public static GUI gui;
	
	public static void main(String[] args) {
		gui = new GUI();
		gui.create();
		
		RepaintThread t = new RepaintThread();
		t.start();
	}
}