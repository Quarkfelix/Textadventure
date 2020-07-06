package snake_io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import snake_objects.GameField;

public class KeyHandler implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: {
			GameField.snake.setMovementDirection("UP");
			break;
		}
		case KeyEvent.VK_DOWN: {
			GameField.snake.setMovementDirection("DOWN");
			break;
		}
		case KeyEvent.VK_LEFT: {
			GameField.snake.setMovementDirection("LEFT");
			break;
		}
		case KeyEvent.VK_RIGHT: {
			GameField.snake.setMovementDirection("RIGHT");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getKeyCode());
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
