package IO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener{

	public static double mouseX;
	public static double mouseY;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

}
