package Balls;
import java.awt.*;
import java.util.Formatter;
import javax.swing.*;
import java.util.Random;

/**
 * @author Jonathan Meredith
 * This program uses classes for the different balls
 */

// Extends JPanel, so as to override the paintComponent() for custom rendering codes. 
public class BouncingBallClasses extends JPanel {
	Random rand = new Random();
	Ball ball = new Ball();
	// Container box's width and height
	private static final int BOX_WIDTH = 500;//1280;//1500;//640;
	private static final int BOX_HEIGHT = 500;//975;//800;//480;
	
	// Ball's properties
//not needed anymore?
//	private float ballRadius = rand.nextInt(25); // Ball's radius
//	private float ballX = ballRadius + rand.nextInt(25); // Ball's center (x, y)
//	private float ballY = ballRadius + rand.nextInt(25); 
//	private float ballSpeedX = rand.nextInt(10);	// Ball's speed for x and y
//	private float ballSpeedY = rand.nextInt(10);
//not needed anymore?
	
	private static final int UPDATE_RATE = 30; // Number of refresh per second
	
	/** Constructor to create the UI components and init game objects. */
	public BouncingBallClasses() {
		this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
		
		// Start the ball bouncing (in its own thread)
		Thread gameThread = new Thread() {
		public void run() {
			while (true) { // Execute one update step
				// Calculate the ball's new position
				ball.setBallX((ball.getBallX() + ball.getBallSpeedX()));
				ball.setBallY((ball.getBallY() + ball.getBallSpeedY()));
				// If so, adjust the position and speed.
				if ((ball.getBallX() - ball.getRadius()) < 0) {
					ball.setBallSpeedX(-ball.getBallSpeedX()); // Reflect along normal
					ball.setBallX(ball.getRadius()); // Re-position the ball at the edge
				} else if ((ball.getBallX() + ball.getRadius()) > BOX_WIDTH) {
					ball.setBallSpeedX(ball.getBallSpeedX());
					ball.setBallX(BOX_WIDTH - ball.getRadius());
				}
				// May cross both x and y bounds
				if ((ball.getBallY() - ball.getRadius()) < 0) {
					ball.setBallSpeedY(-ball.getBallSpeedY());
					ball.setBallY(ball.getRadius());
				} else if ((ball.getBallSpeedY() + ball.getRadius()) > BOX_HEIGHT) {
					ball.setBallSpeedY(-ball.getBallSpeedY());
					ball.setBallY(BOX_HEIGHT - ball.getRadius());
				}
					
				// Refresh the display
				repaint(); // Callback paintComponent()
				// Delay for timing control and give other threads a chance
				try {
					Thread.sleep(1000 / UPDATE_RATE);	// milliseconds
				} catch (InterruptedException ex) { }
			}
		}
		};
		gameThread.start();	// Callback run()
		}
		
		/** Custom rendering codes for drawing the JPanel */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);	// Paint background
		
			// Draw the box
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
		
			// Draw the ball
			g.setColor(Color.RED);
			g.fillOval((int) (ball.getBallX() - ball.getRadius()), 
				(int) (ball.getBallY() - ball.getRadius()),
				(int)(2 * ball.getRadius()), (int)(2 * ball.getRadius()));
			
			// Display the ball's information
//			g.setColor(Color.WHITE);
//			g.setFont(new Font("Courier New", Font.PLAIN, 12));
//			StringBuilder sb = new StringBuilder();
//			Formatter formatter = new Formatter(sb);
//			formatter.format("Ball @(%3.0f,%3.0f) Speed=(%2.0f,%2.0f)", 
//				ball.getBallX(), ball.getBallY(),
//				ball.getBallSpeedX(), ball.getBallSpeedY());
//			g.drawString(sb.toString(), 20, 30);
//			formatter.close();
		}
		
		/** main program (entry point) */
		public static void main(String[] args) {
			// Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				// Set up main window (using Swing's Jframe)
				JFrame frame = new JFrame("A non Bouncing Ball");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new BouncingBallClasses());
				frame.pack();
				frame.setVisible(true);
			 }
			});
		}
	}