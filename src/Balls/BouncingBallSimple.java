package Balls;
//package Balls;
import java.awt.*;
import java.util.Formatter;
import javax.swing.*;
import java.util.Random;
/**
 * One ball bouncing inside a rectangular box. 
 * All codes in one file. Poor design!
 */
// Extends JPanel, so as to override the paintComponent() for custom rendering codes. 
public class BouncingBallSimple extends JPanel {
   Random rand = new Random();

   // Container box's width and height
   private static final int BOX_WIDTH = 1280;//1500;//640;
   private static final int BOX_HEIGHT = 975;//800;//480;
  
   // Ball's properties
   private float ballRadius = rand.nextInt(25); // Ball's radius
   private float ballX = ballRadius + rand.nextInt(25); // Ball's center (x, y)
   private float ballY = ballRadius + rand.nextInt(25); 
   private float ballSpeedX = rand.nextInt(10);   // Ball's speed for x and y
   private float ballSpeedY = rand.nextInt(10);
  
   //testball
   private float testballRadius = rand.nextInt(25); // Ball's radius
   private float testballX = testballRadius + rand.nextInt(25); // Ball's center (x, y)
   private float testballY = testballRadius + rand.nextInt(25); 
   private float testballSpeedX = rand.nextInt(10);   // Ball's speed for x and y
   private float testballSpeedY = rand.nextInt(10);
   
 //testball1
   private float testballRadius1 = rand.nextInt(25); // Ball's radius
   private float testballX1 = testballRadius1 + rand.nextInt(25); // Ball's center (x, y)
   private float testballY1 = testballRadius1 + rand.nextInt(25); 
   private float testballSpeedX1 = rand.nextInt(10);   // Ball's speed for x and y
   private float testballSpeedY1 = rand.nextInt(10);
   
 //testball2
   private float testballRadius2 = rand.nextInt(25); // Ball's radius
   private float testballX2 = testballRadius2 + rand.nextInt(25); // Ball's center (x, y)
   private float testballY2 = testballRadius2 + rand.nextInt(25); 
   private float testballSpeedX2 = rand.nextInt(10);   // Ball's speed for x and y
   private float testballSpeedY2 = rand.nextInt(10);
   
   //testball3
   private float testballRadius3 = rand.nextInt(25); // Ball's radius
   private float testballX3 = testballRadius3 + rand.nextInt(25); // Ball's center (x, y)
   private float testballY3 = testballRadius3 + rand.nextInt(25); 
   private float testballSpeedX3 = rand.nextInt(10);   // Ball's speed for x and y
   private float testballSpeedY3 = rand.nextInt(10);
   
   //testball4
   private float testballRadius4 = rand.nextInt(25); // Ball's radius
   private float testballX4 = testballRadius4 + rand.nextInt(25); // Ball's center (x, y)
   private float testballY4 = testballRadius4 + rand.nextInt(25); 
   private float testballSpeedX4 = rand.nextInt(10);   // Ball's speed for x and y
   private float testballSpeedY4 = rand.nextInt(10);
   
   private static final int UPDATE_RATE = 30; // Number of refresh per second
  
   /** Constructor to create the UI components and init game objects. */
   public BouncingBallSimple() {
      this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
  
      // Start the ball bouncing (in its own thread)
      Thread gameThread = new Thread() {
         public void run() {
            while (true) { // Execute one update step
               // Calculate the ball's new position
               ballX += ballSpeedX;
               ballY += ballSpeedY;
               // Check if the ball moves over the bounds
               // If so, adjust the position and speed.
               if (ballX - ballRadius < 0) {
                  ballSpeedX = -ballSpeedX; // Reflect along normal
                  ballX = ballRadius; // Re-position the ball at the edge
               } else if (ballX + ballRadius > BOX_WIDTH) {
                  ballSpeedX = -ballSpeedX;
                  ballX = BOX_WIDTH - ballRadius;
               }
               // May cross both x and y bounds
               if (ballY - ballRadius < 0) {
                  ballSpeedY = -ballSpeedY;
                  ballY = ballRadius;
               } else if (ballY + ballRadius > BOX_HEIGHT) {
                  ballSpeedY = -ballSpeedY;
                  ballY = BOX_HEIGHT - ballRadius;
               }
               
               
               //testball
               testballX += testballSpeedX;
               testballY += testballSpeedY;
               // Check if the ball moves over the bounds
               // If so, adjust the position and speed.
               if (testballX - testballRadius < 0) {
            	  testballSpeedX = -testballSpeedX; // Reflect along normal
            	  testballX = testballRadius; // Re-position the ball at the edge
               } else if (testballX + testballRadius > BOX_WIDTH) {
            	  testballSpeedX = -testballSpeedX;
            	  testballX = BOX_WIDTH - testballRadius;
               }
               // May cross both x and y bounds
               if (testballY - testballRadius < 0) {
            	  testballSpeedY = -testballSpeedY;
            	  testballY = testballRadius;
            	  testballRadius = testballRadius + rand.nextInt(10);
               } else if (testballY + testballRadius > BOX_HEIGHT) {
            	  testballSpeedY = -testballSpeedY;
            	  testballY = BOX_HEIGHT - testballRadius;
               }
               
             //testball1
               testballX1 += testballSpeedX1;
               testballY1 += testballSpeedY1;
               // Check if the ball moves over the bounds
               // If so, adjust the position and speed.
               if (testballX1 - testballRadius1 < 0) {
            	  testballSpeedX1 = -testballSpeedX1; // Reflect along normal
            	  testballX1 = testballRadius1; // Re-position the ball at the edge
               } else if (testballX1 + testballRadius1 > BOX_WIDTH) {
            	  testballSpeedX1 = -testballSpeedX1;
            	  testballX1 = BOX_WIDTH - testballRadius1;
               }
               // May cross both x and y bounds
               if (testballY1 - testballRadius1 < 0) {
            	  testballSpeedY1 = -testballSpeedY1;
            	  testballY1 = testballRadius1;
            	  testballRadius1 = testballRadius1 + rand.nextInt(10);
               } else if (testballY1 + testballRadius1 > BOX_HEIGHT) {
            	  testballSpeedY1 = -testballSpeedY1;
            	  testballY1 = BOX_HEIGHT - testballRadius1;
               }
               
             //testball2
               testballX2 += testballSpeedX2;
               testballY2 += testballSpeedY2;
               // Check if the ball moves over the bounds
               // If so, adjust the position and speed.
               if (testballX2 - testballRadius2 < 0) {
            	  testballSpeedX2 = -testballSpeedX2; // Reflect along normal
            	  testballX2 = testballRadius2; // Re-position the ball at the edge
               } else if (testballX2 + testballRadius2 > BOX_WIDTH) {
            	  testballSpeedX2 = -testballSpeedX2;
            	  testballX2 = BOX_WIDTH - testballRadius2;
               }
               // May cross both x and y bounds
               if (testballY2 - testballRadius2 < 0) {
            	  testballSpeedY2 = -testballSpeedY2;
            	  testballY2 = testballRadius2;
            	  testballRadius2 = testballRadius2 + rand.nextInt(10);
               } else if (testballY2 + testballRadius2 > BOX_HEIGHT) {
            	  testballSpeedY2 = -testballSpeedY2;
            	  testballY2 = BOX_HEIGHT - testballRadius2;
               }
               
             //testball3
               testballX3 += testballSpeedX3;
               testballY3 += testballSpeedY3;
               // Check if the ball moves over the bounds
               // If so, adjust the position and speed.
               if (testballX3 - testballRadius3 < 0) {
            	  testballSpeedX3 = -testballSpeedX3; // Reflect along normal
            	  testballX3 = testballRadius3; // Re-position the ball at the edge
               } else if (testballX3 + testballRadius3 > BOX_WIDTH) {
            	  testballSpeedX3 = -testballSpeedX3;
            	  testballX3 = BOX_WIDTH - testballRadius3;
               }
               // May cross both x and y bounds
               if (testballY3 - testballRadius3 < 0) {
            	  testballSpeedY3 = -testballSpeedY3;
            	  testballY3 = testballRadius3;
            	  testballRadius3 = testballRadius3 + rand.nextInt(10);
               } else if (testballY3 + testballRadius3 > BOX_HEIGHT) {
            	  testballSpeedY3 = -testballSpeedY3;
            	  testballY3 = BOX_HEIGHT - testballRadius3;
               }
               
             //testball4
               testballX4 += testballSpeedX4;
               testballY4 += testballSpeedY4;
               // Check if the ball moves over the bounds
               // If so, adjust the position and speed.
               if (testballX4 - testballRadius4 < 0) {
            	  testballSpeedX4 = -testballSpeedX4; // Reflect along normal
            	  testballX4 = testballRadius4; // Re-position the ball at the edge
               } else if (testballX4 + testballRadius4 > BOX_WIDTH) {
            	  testballSpeedX4 = -testballSpeedX4;
            	  testballX4 = BOX_WIDTH - testballRadius4;
               }
               // May cross both x and y bounds
               if (testballY4 - testballRadius4 < 0) {
            	  testballSpeedY4 = -testballSpeedY4;
            	  testballY4 = testballRadius4;
            	  testballRadius4 = testballRadius4 + rand.nextInt(10);
               } else if (testballY4 + testballRadius4 > BOX_HEIGHT) {
            	  testballSpeedY4 = -testballSpeedY4;
            	  testballY4 = BOX_HEIGHT - testballRadius4;
               }
               
               // Refresh the display
               repaint(); // Callback paintComponent()
               // Delay for timing control and give other threads a chance
               try {
                  Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
               } catch (InterruptedException ex) { }
            }
         }
      };
      gameThread.start();  // Callback run()
   }
  
   /** Custom rendering codes for drawing the JPanel */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background
  
      // Draw the box
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
  
      // Draw the ball
      g.setColor(Color.RED);
      g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
            (int)(2 * ballRadius), (int)(2 * ballRadius));
  
      //draw testball
      g.setColor(Color.BLUE);
      g.fillOval((int) (testballX - testballRadius), (int) (testballY - testballRadius),
            (int)(2 * testballRadius), (int)(2 * testballRadius));
      
      //draw testball1
      g.setColor(Color.GRAY);
      g.fillOval((int) (testballX1 - testballRadius1), (int) (testballY1 - testballRadius1),
            (int)(2 * testballRadius1), (int)(2 * testballRadius1));
      
      //draw testball2
      g.setColor(Color.GREEN);
      g.fillOval((int) (testballX2 - testballRadius2), (int) (testballY2 - testballRadius2),
            (int)(2 * testballRadius2), (int)(2 * testballRadius2));
      
      //draw testball3
      g.setColor(Color.MAGENTA);
      g.fillOval((int) (testballX3 - testballRadius3), (int) (testballY3 - testballRadius3),
            (int)(2 * testballRadius3), (int)(2 * testballRadius3));
      
      //draw testball4
      g.setColor(Color.ORANGE);
      g.fillOval((int) (testballX4 - testballRadius4), (int) (testballY4 - testballRadius4),
            (int)(2 * testballRadius4), (int)(2 * testballRadius4));
      
      // Display the ball's information
      g.setColor(Color.WHITE);
      g.setFont(new Font("Courier New", Font.PLAIN, 12));
      StringBuilder sb = new StringBuilder();
      Formatter formatter = new Formatter(sb);
      formatter.format("Ball @(%3.0f,%3.0f) Speed=(%2.0f,%2.0f)", ballX, ballY,
            ballSpeedX, ballSpeedY);
      g.drawString(sb.toString(), 20, 30);
      formatter.close();
   }
  
   /** main program (entry point) */
   public static void main(String[] args) {
      // Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            // Set up main window (using Swing's Jframe)
            JFrame frame = new JFrame("A Bouncing Ball");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new BouncingBallSimple());
            frame.pack();
            frame.setVisible(true);
         }
      });
   }
}