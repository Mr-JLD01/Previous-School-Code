import java.util.*;
import java.lang.*;
/**
 * Finds the closest point on a coordinate grid to a given point
 */
public class ClosestPointRunner
{
    public static void main(String[] args){
        Point ref = new Point(2,4);
        ArrayList points = new ArrayList<Point>();
        for(int i = 0; i < 10000; i++){
            points.add(new Point((int)(1000 * Math.random()), (int)(1000 * Math.random()), ref));
            Point dot = (Point)points.get(i);
            System.out.println(dot.toString());
        }
        
        Collections.sort(points);
        Point closest = (Point)points.get(0);
        System.out.printf("The closest point to (2,4) was (%d, %d)\n", closest.getX(), closest.getY());
        
        
    }
}
