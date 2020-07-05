package IO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Infrastructure.Main;
import Infrastructure.Settings;
import Logic.Surface;
import UI.DrawGame;


public class KeyHandler implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	 *	bei VK_ENTER wird im surface der a button gedr�ckt. bei backspace der b button. 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			Surface.actionMenu.move("up");
			break;
		case KeyEvent.VK_DOWN:
			Surface.actionMenu.move("down");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			DrawGame.surface.checkButtonPress(Settings.aButtonX, Settings.aButtonY);
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			DrawGame.surface.checkButtonPress(Settings.bButtonX, Settings.bButtonY);
			break;
		case KeyEvent.VK_ENTER:
			DrawGame.surface.checkButtonPress(Settings.aButtonX, Settings.aButtonY);
			break;
		case KeyEvent.VK_BACK_SPACE:
			DrawGame.surface.checkButtonPress(Settings.bButtonX, Settings.bButtonY);
			break;
		case KeyEvent.VK_ESCAPE: 
			System.exit(0);
			break;
		default:
			System.out.println("KEY NOT SUPPORTED");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {		
		
	}

}
