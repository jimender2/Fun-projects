package Balls;
import java.awt.*;
import java.util.Formatter;
import javax.swing.*;
import java.util.Random;

public class Ball {
	private int ballRadius;
	private int ballX;
	private int ballY;
	private int ballSpeedX;
	private int ballSpeedY;
	private Color color;
		
	public Ball() {
		Random rand = new Random();
		ballRadius = rand.nextInt(25);
		ballX = ballRadius + rand.nextInt(100);
		ballY = ballRadius + rand.nextInt(100);
		ballSpeedX = rand.nextInt(10);
		ballSpeedY = rand.nextInt(10);
		color = Color.BLUE;
	}
	
	public Ball(int radius) {
		Random rand = new Random();
		ballRadius = radius;
		ballX = ballRadius + rand.nextInt(100);
		ballY = ballRadius + rand.nextInt(100);
		ballSpeedX = rand.nextInt(10);
		ballSpeedY = rand.nextInt(10);
		color = Color.BLUE;
	}
	
	public Ball(int radius, int x, int y) {
		Random rand = new Random();
		ballRadius = radius;
		ballX = ballRadius + 250; // x;
		ballY = ballRadius + 250; // y;
		ballSpeedX = 5; // rand.nextInt(10);
		ballSpeedY = 5;  //rand.nextInt(10);
		color = Color.BLUE;
	}
	
	public void setRadius(int x) {
		ballRadius = x;
	}
	
	public void setBallX(int x) {
		ballX = ballRadius + x;
	}
	
	public void setBallY(int y) {
		ballY = ballRadius + y;
	}
	
	public void setBallSpeedX(int x) {
		ballSpeedX = x;
	}
	
	public void setBallSpeedY(int y) {
		ballSpeedY = y;
	}
	
	public int getRadius() {
		return ballRadius;
	}
	
	public int getBallX() {
		return ballX;
	}
	
	public int getBallY() {
		return ballY;
	}
	
	public int getBallSpeedX() {
		return ballSpeedX;
	}
	
	public int getBallSpeedY() {
		return ballSpeedY;
	}
	
	public void setBallColor(Color col) {
		color = col;
	}
	
	public Color getBallColor() {
		return color;
	}
	
}
