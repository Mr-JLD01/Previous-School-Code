import java.lang.Math;

/**
 *A point object with qualities x,y and distance from a point
 */
public class Point implements Comparable<Point>
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private double dist = 0.0;
    /**
     * Constructor for objects of class Point
     */
    public Point()
    {
        // initialise instance variables
        x = 0;
        y = 0;
    }
    
    public Point(int xCoord, int yCoord)
    {
        // initialise instance variables
        x = xCoord;
        y = yCoord;
    }
    
    public Point(int xCoord, int yCoord, Point other)
    {
        // initialise instance variables
        x = xCoord;
        y = yCoord;
        this.distBetween(other);
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public double getDist(){
        return dist;
    }
    
    public void distBetween(Point other)
    {
        dist = Math.sqrt((Math.pow((x - other.getX()), 2) + Math.pow((y - other.getY()), 2)));
        //System.out.printf("Dist = %.2f\n", dist);
    }
    
    @Override
    public int compareTo(Point other){
        if(other.getDist() < this.getDist())
            return 1;
        else if(other.getDist() > this.getDist())
            return -1;
        else
            return 0;
    }
    
    public String toString(){
        return "(" + this.getX() + "," + this.getY() + ")";
    }
}
