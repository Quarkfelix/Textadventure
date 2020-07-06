package io;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import logic.Surface;
import ui.DrawGame;


public class MouseHandler implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DrawGame.surface.checkButtonPress(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
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
