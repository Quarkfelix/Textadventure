package UI;

import java.awt.Color;
import java.awt.Graphics2D;

public class StartupScreen{
	public boolean active = true;
	
	public void draw(Graphics2D g)  {
		g.setColor(Color.black);
		g.fillRect(0, 0, 300, 300);
	}
}
