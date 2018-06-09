package Balls;
import java.awt.*;
import java.util.Formatter;
import javax.swing.*;
import java.util.Random;

public class Ball {
	private int ballRadius;
	private float ballX;
	private float ballY;
	private int ballSpeedX;
	private int ballSpeedY;
	private Color color;
	
	
	//   private float ballSpeedX = rand.nextInt(10);   // Ball's speed for x and y
	//   private float ballSpeedY = rand.nextInt(10);
	
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
		ballX = ballRadius + x;
		ballY = ballRadius + y;
		ballSpeedX = rand.nextInt(10);
		ballSpeedY = rand.nextInt(10);
		color = Color.BLUE;
	}
	
	public void setRadius(int x) {
		ballRadius = x;
	}
	
	public void setBallX(float x) {
		ballX = ballRadius + x;
	}
	
	public void setBallY(float y) {
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
	
	public float getBallX() {
		return ballX;
	}
	
	public float getBallY() {
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
