package snake_infrastructure;

import snake_draw.GUI;

public class SnakeGame {
	public static GUI gui;
	public static MyWindow window;
	
//constructor------------------------------------------------------------------------------------------------------------
	public SnakeGame() {
		window = new MyWindow();
		gui = new GUI();
	}
	
}
