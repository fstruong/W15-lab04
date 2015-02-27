package edu.ucsb.cs56.w15.drawings.fstruong.advanced;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    private IceCream IceCream = new IceCream(100, 100, 100, 100);
    Thread anim;   
    private int x = 100;
    private int y = 50;
    private int dx = 5;
    private int dy = 3; 
    private int deg = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
      	public void mouseEntered(MouseEvent e){ // when mouse enters the screen start animation
          anim = new Animation();
          anim.start();
        }
        public void mouseExited(MouseEvent e){      
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();   
        }
      });
	}
    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) { // when mouse exits the screen stop animation

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the IceCream
          g2.setColor(Color.RED);
          IceCreamWithToppings cone = new IceCreamWithToppings(x, y, 100, 100);
          Shape rotated_cone = ShapeTransforms.rotatedCopyOf(cone, deg); // rotate ice cream cone
          g2.draw(rotated_cone);
         
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
           	if (x >= 400) { dx = -5; dy = -3; } // move diagonally
        	if (x <= 100) { dx = 5; dy = 3; }
        	deg += 3;
            x += dx;
            y += dy;
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
