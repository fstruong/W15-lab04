package edu.ucsb.cs56.w15.drawings.fstruong.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a ice cream cone that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Felicia Truong
   @version for CS56, Winter 15, UCSB
   
*/
public class IceCreamWithToppings extends IceCream implements Shape
{
    /**
       Constructor

       @param x x coord of lower left of ice cream
       @param y y coord of lower left of ice cream
       @param width width of ice cream
       @param height of ice cream
     */
    public IceCreamWithToppings(double x, double y, double width, double height){
    	// construct basic ice cream cone
    	super(x,y,width,height);
    	Ellipse2D.Double second = 
            new Ellipse2D.Double (x+width/10, y-height+height/5, width-width/5, height-height/5);
    	Ellipse2D.Double cherry = 
            new Ellipse2D.Double (x+width/4, y-height-height/2, width/2, height/2);
  
        // put the whole cone together
       
        GeneralPath wholeCone = this.get();
        wholeCone.append(cherry, false);
        wholeCone.append(second, false);
     
    }

}
