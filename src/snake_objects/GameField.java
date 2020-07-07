package snake_objects;

import java.awt.Color;
import java.awt.Graphics2D;

import snake_infrastructure.SnakeGame;
import snake_infrastructure.MyWindow;
import snake_infrastructure.Settings;
import snake_ui.InformationPanel;

public class GameField extends Thread {
	public static Snake snake;
	public static Food food;
	public int x,y,width,height;
	private int tickspeed;
	private boolean running = true;
	
//constructor------------------------------------------------------------------------------------------------------------
	public GameField() {
		x = 25;
		y = 20;
		width = 800;
		height = 760;
		tickspeed = Settings.tickspeed;
		
		snake = new Snake();
		food  = new Food();
		super.start();
	}
	
//methods------------------------------------------------------------------------------------------------------------
	public void run() {
		while(running) {
			try {
				Thread.sleep(tickspeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!borderCollision() && !snakeCollision()) {
				snake.move();
			} else {
				SnakeGame.window.createGameField();
			}
			
			if(snake.eaten(food)) {
				food.spawnNewFood();
				InformationPanel.incGameScore();
				if(InformationPanel.gameScore > InformationPanel.highScore) {
					InformationPanel.incHighScore();
				}
			}		
		}
	}

	private boolean snakeCollision() {
		int x = snake.head.getX();
		int y = snake.head.getY();
		
		for (Bodypart bodypart : snake.body) {
			if (bodypart.getX() == x && bodypart.getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	private boolean borderCollision() {
		if(snake.head.getX() >= 21 || snake.head.getX() <= 0) {
			return true;
		} else if(snake.head.getY() >= 19 || snake.head.getY() <= 0) {
			return true;
		}
		return false;
	}
	
	public void stopGameField() {
		InformationPanel.gameScore = 0;
		running = false;
		currentThread().interrupt();
	}
	
//paint------------------------------------------------------------------------------------------------------------
	public void setupDraw(Graphics2D g) {
		g.setColor(Settings.GameFieldBackgroundColor);
		g.fillRect(x, y, width, height);
		
		snake.draw(g);
		food.draw(g);
		
		g.setColor(Settings.GameFieldGridColor);

		for (int i = 40; i < width; i += 40) {
			g.drawLine(x+i, y, x+i, y+height);
		}
		
		for (int i = 40; i < height; i += 40) {
			g.drawLine(x, y+i, x+width, y+i);
		}
		
		g.setColor(Settings.windowBackgroundColor);
		g.fillRect(0, 0, x, height);
		g.fillRect(0, 0, width, y);
		g.fillRect(x, y + height, width, 40);
		g.fillRect(x + width, y, 40, height);
		
		g.setColor(Settings.GameFieldBorderColor);
		g.drawRect(x, y, width, height);	
	}
}
