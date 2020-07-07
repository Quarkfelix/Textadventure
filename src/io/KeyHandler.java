package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import infrastructure.Main;
import infrastructure.Settings;
import logic.Surface;
import ui.DrawGame;


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
			Main.mc.playSound("soundeffects", "File 2");
			Surface.actionMenu.move("up");
			break;
		case KeyEvent.VK_DOWN:
			Main.mc.playSound("soundeffects", "File 2");
			Surface.actionMenu.move("down");
			break;
		case KeyEvent.VK_RIGHT:
			Main.mc.playSound("soundeffects", "File 2");
			System.out.println("right");
			DrawGame.surface.checkButtonPress(Settings.aButtonX, Settings.aButtonY);
			break;
		case KeyEvent.VK_LEFT:
			Main.mc.playSound("soundeffects", "File 2");
			System.out.println("left");
			DrawGame.surface.checkButtonPress(Settings.bButtonX, Settings.bButtonY);
			break;
		case KeyEvent.VK_ENTER:
			Main.mc.playSound("soundeffects", "File 1");
			DrawGame.surface.checkButtonPress(Settings.aButtonX, Settings.aButtonY);
			break;
		case KeyEvent.VK_BACK_SPACE:
			Main.mc.playSound("soundeffects", "File 3");
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
