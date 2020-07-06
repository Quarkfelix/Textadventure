package snake_io;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import libary_version_2.Button;
import snake_infrastructure.SnakeGame;

public class MouseHandler implements MouseListener{
	private HashMap<String, Button> buttons = SnakeGame.window.buttons;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (String key : buttons.keySet()) {
			if (buttons.get(key).contains(e.getX(), e.getY())) {
				switch (key) {
				case "play": {
					SnakeGame.window.createGameField();
					break;
				}
				
				case "quit": {
					System.exit(0);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + key);
				}
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
