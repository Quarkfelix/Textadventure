package snake_objects;

import java.awt.Color;
import java.awt.Graphics2D;

import snake_infrastructure.SnakeGame;
import snake_infrastructure.MyWindow;

public class Food {
	private int x,y;

//constructor------------------------------------------------------------------------------------------------------------
	public Food() {
		spawnNewFood();
	}
	
//methods------------------------------------------------------------------------------------------------------------
	public void spawnNewFood() {
		this.x = (int)((Math.random()) * 18 + 1);
		this.y = (int)((Math.random()) * 14 + 1);
	}

//getter-setter------------------------------------------------------------------------------------------------------------
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
//paint------------------------------------------------------------------------------------------------------------
	public void draw(Graphics2D g) {
		GameField gf = MyWindow.gf;
		
		g.setColor(Color.RED);
		g.fillRect(x*40 - 25 + gf.x, y*40 - 25 + gf.y, 10, 10);
	}
}
