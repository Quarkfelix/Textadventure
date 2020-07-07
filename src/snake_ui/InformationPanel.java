package snake_ui;

import java.awt.Color;
import java.awt.Graphics2D;

import libary_version_2.TextArea;

public class InformationPanel {
	private TextArea score;
	private TextArea highScoreText;
	public static int gameScore = 0;
	public static int highScore = 0;
	
//constructor------------------------------------------------------------------------------------------------------------
	public InformationPanel() {
		score = new TextArea(960, 100, 70, 70);
		highScoreText = new TextArea(960, 200, 70, 70);
		textAreaSetup();
	}
	
//methods------------------------------------------------------------------------------------------------------------
	private void textAreaSetup() {
		score.setThicness(2);
		score.setBackgroundColor(Color.BLACK);
		score.setFramingColor(Color.RED);
		score.setTextColor(Color.RED);
		score.setTextFontSize(60);
		
		highScoreText.setThicness(2);
		highScoreText.setBackgroundColor(Color.BLACK);
		highScoreText.setFramingColor(Color.RED);
		highScoreText.setTextColor(Color.RED);
		highScoreText.setTextFontSize(60);
	}
	
	public static void incGameScore() {
		gameScore++;
	}
	
	public static void incHighScore() {
		highScore++;
	}
	
//paint-----------------------------------------------------------------------------------------------------------------
	public void draw(Graphics2D g) {
		score.setText(gameScore);
		score.paint(g);
		
		highScoreText.setText(highScore);
		highScoreText.paint(g);
	}
}
