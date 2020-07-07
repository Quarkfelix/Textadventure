package snake_objects;

import java.awt.Color;
import java.awt.Graphics2D;

import snake_infrastructure.SnakeGame;
import snake_infrastructure.MyWindow;
import snake_infrastructure.Settings;

public class Bodypart{
	private int x,y;
	
//constructor------------------------------------------------------------------------------------------------------------
	public Bodypart() {
		//neues bodypart wird bei 500 500 gespawnt damit es nicht stört. beim nächsten movement tick ist es dann automatisch dran.
		setX(500);
		setY(500);
	}

//methods------------------------------------------------------------------------------------------------------------
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

//getter-setter------------------------------------------------------------------------------------------------------------
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
//paint------------------------------------------------------------------------------------------------------------
	public void draw(Graphics2D g) {
		GameField gf = MyWindow.gf;
		g.setColor(Settings.bodyColor);
		g.fillRect((x-1)*40 + gf.x, (y-1)*40 + gf.y, 40, 40);
	}
}
