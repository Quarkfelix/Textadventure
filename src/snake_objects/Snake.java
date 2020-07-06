package snake_objects;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Snake{
	public ArrayList<Bodypart> body;
	public Head head;
	
	private String movementDirection = "RIGHT";
	
	
	public Snake() {
		head = new Head();
		body = new ArrayList<>();
		body.add(new Bodypart());
		body.add(new Bodypart());
	}
	
	public boolean eaten(Food food) {
		if(food.getX() == head.getX() && food.getY() == head.getY()) {
			addBodyPiece();
			return true;
		}
		return false;
	}
	
	
	private void addBodyPiece() {
		body.add(new Bodypart());
	}
	
	//wird jeden tick aufgerufen
	public void move() {		
		//body
		for (int i = body.size()-1; i > 0 ; i--) {
			body.get(i).move(body.get(i-1).getX(), body.get(i-1).getY());
		}
		body.get(0).move(head.getX(), head.getY());
		
		//head
		switch (movementDirection) {
		case "LEFT": {
			head.decX();
			break;
		}
		case "RIGHT": {
			head.incX();
			break;
		}
		case "UP": {
			head.decY();
			break;
		}
		case "DOWN": {
			head.incY();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value");
		}
				
	}
	
	public void setMovementDirection(String direction) {
		this.movementDirection = direction;
	}
	
	
	
	
	
	
	public void draw(Graphics2D g) {
		head.draw(g);
		for (Bodypart bodypart : body) {
			bodypart.draw(g);
		}
		
	}
	
}
