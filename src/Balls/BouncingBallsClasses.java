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
public class BouncingBallsClasses extends JPanel {
	Random rand = new Random();
	int i = 0;
	int j = 50;
	Ball[] ball = new Ball[10];
	
	// Container box's width and height
	private static final int BOX_WIDTH = 500;//1280;//1500;//640;
	private static final int BOX_HEIGHT = 500;//975;//800;//480;
	
	private static final int UPDATE_RATE = 30; // Number of refresh per second
	
	/** Constructor to create the UI components and init game objects. */
	public BouncingBallsClasses() {
		this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
		
		// Start the ball bouncing (in its own thread)
		Thread gameThread = new Thread() {
		public void run() {
			
			while (true) { // Execute one update step
				i=0;
				while(i<(j-1)) {
                    // Calculate the ball's new position
                    ball[i].setBallX((ball[i].getBallX() + (ball[i].getBallSpeedX())));
                    ball[i].setBallY((ball[i].getBallY() + ball[i].getBallSpeedY()));
                    
                    // If so, adjust the position and speed.
                    if ((ball[i].getBallX() - ball[i].getRadius()) < 0) {
                        ball[i].setBallSpeedX(0 - ball[i].getBallSpeedX()); // Reflect along normal
                        ball[i].setBallX(ball[i].getRadius()); // Re-position the ball at the edge
                    } else if ((ball[i].getBallX() + ball[i].getRadius()) > BOX_WIDTH) {
                        //ball[i].setBallSpeedX(0 - ball[i].getBallSpeedX());
                        ball[i].setBallSpeedX(0 - ball[i].getBallSpeedX());
                        ball[i].setBallX(BOX_WIDTH - ball[i].getRadius());
                    }
                    // May cross both x and y bounds
                    if ((ball[i].getBallY() - ball[i].getRadius()) < 0) {
                        ball[i].setBallSpeedY(0 - ball[i].getBallSpeedY());
                        ball[i].setBallY(ball[i].getRadius());
                    } else if ((ball[i].getBallY() + ball[i].getRadius()) > BOX_HEIGHT) {
                        ball[i].setBallSpeedY(0 - ball[i].getBallSpeedY());
                        ball[i].setBallY(BOX_HEIGHT - ball[i].getRadius());
                    }
					i++;
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
			
			i=0;
//			while(i<(j-1)) {
				// Draw the ball
				g.setColor(Color.RED);
				g.fillOval((int) (ball[i].getBallX() - ball[i].getRadius()), 
					(int) (ball[i].getBallY() - ball[i].getRadius()),
					(int)(2 * ball[i].getRadius()), (int)(2 * ball[i].getRadius()));
				i++;
//			}
			// Display the ball's information
//			g.setColor(Color.WHITE);
//			g.setFont(new Font("Courier New", Font.PLAIN, 12));
//			StringBuilder sb = new StringBuilder();
//			Formatter formatter = new Formatter(sb);
//			formatter.format("Ball @(%3.0f,%3.0f) Speed=(%2.0f,%2.0f)", 
//				ball[i].getBallX(), ball[i].getBallY(),
//				ball[i].getBallSpeedX(), ball[i].getBallSpeedY());
//			g.drawString(sb.toString(), 20, 30);
//			formatter.close();
		}
		
		/** main program (entry point) */
		public static void main(String[] args) {
			// Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				// Set up main window (using Swing's Jframe)
				JFrame frame = new JFrame("Bouncing Ball");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new BouncingBallsClasses());
				frame.pack();
				frame.setVisible(true);
			 }
			});
		}
	}