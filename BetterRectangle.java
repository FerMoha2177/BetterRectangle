/**
 * Created by Ferris on 2/23/2017.
 * Imports Rectangle class to extend its functionality.
 * Imports Point Class to use point objects to make Rectangle on a coordinate plane
 * and to calcualte data such as mid point, lower left point, and slope.
 *
 * This class "improves" upon the Rectangle class by adding
 * accessor methods that return a Rectangle's area,
 */
/*=============================================================================
|   Source code:  BRectTester.java
|           Author:  Ferris Mohammed
|     Student ID:  5906747
|    Assignment: #4 BETTER_RECTANGLE
|
|            Course:  COP 3337
|           Section:  U02
|        Instructor:  William Feild
|        Due Date:  [3/7/2017], at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|
|        Language:  Java
|  Compile/Run:
| 	javac BetterRectangle.java  BRectTester.java
|	java  BRectTester
|
|  +-----------------------------------------------------------------------------
|
|  Description:  The program extends/improves upon the "Rectangle" class. It has added accessor methods
|               which are getArea() ,getPerimeter() ,getSlope() ,getMidPoint(), and getLLP(). This class
|               has added utility methods which are isCongruent(). isConcentric, isSimilar, and isEquivalent.
|               This class is also equipped with a mutator method scaleBy().

|
|        Input:  No user input
|
|       Output:  Should output each objects data accessor methods, utility methods, and mutator methods, as well as the
|                overridden methods
|
|     Process:  Used Midpoint formula, slope formula, Area Formula,
|
|   Required Features Not Included:
|                None.
|
|   Known Bugs:  [If you know of any problems with the code, provide
|                details here; otherwise, clearly state that you know
|                of no logic errors. Being honest here may save you some points.]
|  *===========================================================================*/

import java.awt.Rectangle;
import java.awt.geom.Point2D;
public class BetterRectangle extends Rectangle
{

    /**
     * Constructors for constructing four rectangles differently-
     */
    public BetterRectangle() //Constructs a unit Rectangle
    {
        setLocation(0,0);
        setSize(1,1);
    }
    public BetterRectangle(int width, int height) //Creates rectangle at Origin
    {
        setLocation(0,0);
        setSize(width,height);
    }
    public BetterRectangle(int x, int y ,int width, int height) //Creates rectangle using (x,y)
    {
        setLocation(x,y);
        setSize(width,height);
    }
    public BetterRectangle(BetterRectangle r) //Creates copy of Rectangle
    {
        int width = (int)r.getWidth();
        int height = (int)r.getHeight();
        int x = (int)r.getX();
        int y = (int)r.getY();
        setLocation(x,y);
        setSize(width,height);
    }

    //Accessor methods

    /**
     * Multiplies the length and width of a rectangle.
     * FORMUALA: width*height
     * @return product of length*widtch
     */
    public int getArea(){
        double area = getWidth()*getHeight();
        return (int) area;
    }

    /**
     * Adds each side of a rectangle.
     * FORMUALA: 2*(width+height)
     * @return the sum of all sides of rectangle
     */
    public int getPerimeter()
    {
        int two = 2;
        int height = (int)getHeight();
        int width = (int)getWidth();
        int perimeter = two*(width+height);
        return perimeter;
    }

    /**
     * Calculates the slope of the rectangle.
     * FORMULA: height/width
     * @return double slope
     */
    public double getSlope()
    {
        double height = getHeight();
        double width  =  getWidth();
        double slope  = height / width;

        Point2D.Double p1 = new Point2D.Double((getX() + getWidth()) , getY());
        Point2D.Double llp = getLLP(); //lower left point
        double slopeM = (p1.getY() - llp.getY())/(p1.getX() - llp.getX());
        return slope;

    }

    /**
     * Calculates midpoint of triangle.
     * FORMUALA:
     * @return Point object which is the mid point
     */
    public Point2D.Double getMidPoint()
    {
        Point2D p1 = getLocation();
        double p2x = p1.getX()+ getWidth();
        double p2y = (int) p1.getY() - (int)getHeight();
        Point2D.Double p2 = new Point2D.Double(p2x,p2y);
        double midX = (p2x+(int)p1.getX())/2;
        double midY = (p2y+(int)p1.getY())/2;
        Point2D.Double mid = new Point2D.Double(midX,midY);
        return mid;
    }

    public Point2D.Double getLLP() //gets lower left point
    {
        Point2D.Double lowerLeft = new Point2D.Double(getX(),(getY()- getHeight()));
        return lowerLeft;
    }

    //utility methods

    /**
     * Checks to see congruecy between two BetterRectangles.
     * If width+ height are the same.
     * @param r BetterRectangle obj
     * @return boolean if two triangles are congruent
     */
    public boolean isCongruent(BetterRectangle r)
    {
        int width1 = (int) getWidth();  int width2 = (int) r.getWidth();
        int height1 = (int) getHeight();int height2 = (int) r.getHeight();

        boolean widthTrue  = false;
        boolean heightTrue = false;
        boolean congruent  = false;
        if(width1 == width2)
        {
            widthTrue = true;
        }
        if(height1 == height2)
        {
            heightTrue = true;
        }
        if(heightTrue == true && widthTrue == true)
        {
            congruent = true;
        }
        return congruent;

    }

    /**
     * Checks to see equivalency between two BetterRectangles.
     * If Perimeter between two BetterRectangles are the same.
     * @param r BetterRectangle obj
     * @return
     */
    public boolean isEquivalent(BetterRectangle r)
    {
        return r.getPerimeter() == getPerimeter();

    }

    /**
     * Checks to see if the area between two objectrs are the same.
     * @param r BetterRectangle obj
     * @return
     */
    public boolean isSimilar(BetterRectangle r)
    {
        return r.getArea() == getArea();

    }

    /**
     * Checks for the same midpoint between two BetterRectangles
     * @param r
     * @return
     */
    public boolean isConcentric(BetterRectangle r)
    {
        if(r.getMidPoint().equals(getMidPoint()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Added Mutator

    /**
     * Multiplies height and width by scale
     * @param scale
     */
    public boolean scaleBy(int scale)
    {
        boolean success =false;

        int newWid =scale*width; int newHei = scale*height;

        if((newWid > 0)&&(newHei > 0))
        {
            success = true;
            width = newWid;
            height = newHei;
        }
        return success;
}

    @Override
    public String toString()
    {
        return getClass().getName() + "\n[X = " + getX() + ", Y = " + getY() + ", WIDTH = " + getWidth()+
                                      "\n------------------------------------------------------------------" +
                                      "\nHEIGHT = " + getHeight() + ", AREA = " + getArea() +
                                      "\n------------------------------------------------------------------" +
                                      "\nPERIMETER = " + getPerimeter() + ", SLOPE = " + getSlope()+
                                      "\n------------------------------------------------------------------" +
                                      "\nMIDPOINT = " + getMidPoint() + "\nLOWER_LEFT= " + getLLP()  +
                                      "\n------------------------------------------------------------------" +"]";
    }

    public String toString(BetterRectangle r)
    {
        return  getClass().getName()
               + b"\n====================================================" +
                "\n Are These Congruent ? (Expected to be false) : " + isCongruent(r) +
                "\n Are These Equivalent? (Expected to be true ) : " + isEquivalent(r) +
                "\n Are These Similar?    (Expected to be true ) : " + isSimilar(r)    +
                "\n Are These Concentric? (Expected to be false) : " + isConcentric(r) +
                "\n Are These EQUAL?      (Expected to be false) : " + equals(r) +
                "\n====================================================";
    }

    public boolean equals(BetterRectangle r)
    {
        return ((getX() == r.getX() &&
                (getY() == r.getY() &&
                (getWidth() == r.getWidth()) &&
                (getHeight() == r.getHeight()))));
    }

}
