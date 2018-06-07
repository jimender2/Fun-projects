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
	
	public ball() {
		Random rand = new Random();
		ballRadius = rand.nextInt(25);
		ballX = ballRadius + rand.nextInt(100);
		ballY = ballRadius + rand.nextInt(100);
	}
	
	public ball(int radius) {
		Random rand = new Random();
		ballRadius = radius;
		ballX = ballRadius + rand.nextInt(100);
		ballY = ballRadius + rand.nextInt(100);
	}
	
	public ball(int radius, int x, int y) {
		Random rand = new Random();
		ballRadius = radius;
		ballX = ballRadius + x;
		ballY = ballRadius + y;
	}
}
