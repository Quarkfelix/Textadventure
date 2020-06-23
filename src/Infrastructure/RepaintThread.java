package Infrastructure;

import UI.GUI;

public class RepaintThread extends Thread{

	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GUI.dg.repaint();
		}
	}
}
