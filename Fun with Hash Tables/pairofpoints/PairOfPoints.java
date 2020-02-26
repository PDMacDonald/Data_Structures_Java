import java.util.Scanner;
import java.io.*;
/**
 * PairOfPoints.java
 *
 * @author Preston MacDonald
 * @version 2-23-18
 */
 

 /**
  * This class implements a PointSet to find the closest pair of points within
  * that set.
  *
  * @author Preston MacDonald
  * @version 2-23-18
  */
public class PairOfPoints
{
    /**
     * main method that creates a PointSet to hold a list of points and then
     * finds a pair of points that are closest to one another.
     * 
     * @param args
     *          String arguments.
     */
    public static void main(String [] args)
    {
        File f = new File("points.txt");

        try
        {
            // Take in input and store it in a PointSet datastructure.
            Scanner sk = new Scanner(f);
            PointSet pS = new PointSet(.001);

            while(sk.hasNext())
            {
                double x = sk.nextDouble();
                double y = sk.nextDouble();
                pS.insert(x, y);
            }
            sk.close();
            System.out.println("Points loaded from file...\n");
            // pS.print(); //For troubleshooting
            

            // Calculate minimum distance between 2 points.
            System.out.println("Finding minimum distance between 2 points...");
            System.out.println("Minimum distance = " +findClosestPair(pS));

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);    
        }


        System.out.println("\n~~~~~ END OF PROGRAM ~~~~~\n");
    }

    /**
     * Method that takes a PointSet and finds the mimimum distance between any
     * 2 points stored in the PointSet data structure.
     *
     * @param set
     *          A PointSet that contains PNodes (points).
     *
     * @return minimum distance between any 2 points.
     */
    private static double findClosestPair(PointSet set)
    {
        double minDistance = -1;
        double newDistance = 0; 
        PNode subGrid = null;

        //Nests loops moves through head nodes in subgrids.
        for(int i = 0; i < set.getSize(); i++)
        {
            for(int j = 0; j < set.getSize(); j++)
            {
                subGrid = set.getHead(i,j);
                if(subGrid != null)
                {
                    //Compare all points within one subgrid and set new
                    //distance = to smallest distance found. Compare to
                    //current min distance.
                    newDistance = compareWithinGrid(subGrid);
                    minDistance = compareDistance(minDistance, newDistance);
                    //Compare all points within one subgrid to all points in 
                    //surrounding subgrids and set new distance = to smallest
                    //distance. Compare to current min.
                    newDistance = compareAdjacentGrids(subGrid, set, i, j);
                    minDistance = compareDistance(minDistance, newDistance);
                }
            }

        }


        return minDistance;
    }
    
    /**
     * Method that takes 2 points and calculates the distance between the 2.
     *
     * @param pointOne
     *          A point.
     * @param pointTwo
     *          Another point.
     *
     * @return distance between point 1 and point 2.
     */
    private static double distance(PNode pointOne, PNode pointTwo)
    {
        double x1 = pointOne.getX();
        double y1 = pointOne.getY();
        double x2 = pointTwo.getX();
        double y2 = pointTwo.getY();
        double r = 0;
        r = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1))); 
        
        return Math.abs(r);
        
    }
    
    /**
     * Method that finds the minimum distance between any 2 points within a 
     * single grid.
     *
     * @param head
     *          A reference to a single grid.
     *
     * @return Minimum distance between any 2 points within a single grid.
     */
    private static double compareWithinGrid(PNode head)
    {
        double minDistance = -1;
        double newDistance = 0;
        for(PNode current = head; current != null; current = current.getLink())
        {
            for(PNode c = current.getLink(); c != null; c = c.getLink())
            {
                newDistance = distance(current, c);
                minDistance = compareDistance(minDistance, newDistance);
            }
        }
        return minDistance;
    }
   
   
    /**
     * Method that finds the minimum distance between all pairs of points
     * between 2 given grids.
     *
     * @param p
     *          A reference to a grid.
     * @param otherP
     *          A reference to another grid.
     *
     * @return Minimum distance between any 2 points within 2 given grids.
     */
    private static double compareTwoGrids(PNode p, PNode otherP)
    {
        double minDistance = -1;
        double newDistance = 0;
        PNode temp;

        while(p != null)
        {
            temp = otherP;
            while(temp != null)
            {
                newDistance = distance(p, otherP);
                minDistance = compareDistance(minDistance, newDistance);
                temp = temp.getLink();
            }
            p = p.getLink();
        }

        return minDistance;
    }
   
   
    /**
     * Method that compares 2 distances that must be 0 or positive. Negative
     * arguments will default to printing the non-negative argument if it
     * exists.
     *
     * @param minD
     *          A value representing the current minimum
     * @param newD
     *          A value representing the new value.
     *
     * @return the smallest value or negatives when arguments are neg.
     */
    private static double compareDistance(double minD, double newD)
    {
        if(newD >= 0) 
        {       
            if(minD < 0 || newD < minD)
            {
                return newD;       
            }
        }
        return minD;
    }

    /**
     * Checks all 8 cases of adjacent grids around a given grid reference to
     * find the minimum between all adjacent grids.
     *
     * @param point
     *          A reference to a grid to check around.
     * @param set
     *          A PointSet to reference for surrounding grids.
     * @param i
     *          Index for what grid point is located in.
     * @param j 
     *          Index for what grid point is located in.
     * @return minimum distance between any point located in grid[i][j] to 
     *          all adjacent grids.
     */
    private static double compareAdjacentGrids(PNode point, PointSet set, int i, int j)
    {
        double minDistance = -1;
        double newDistance = 0;
        int nI = 0;
        int nJ = 0;
        PNode p2;
        //Bottom left Check
        if(i - 1 >= 0 && j - 1 >= 0)
        {
            nI = i - 1;
            nJ = j - 1;
            p2 = set.getHead(nI,nJ);
            newDistance = compareTwoGrids(point, p2);
            minDistance = compareDistance(minDistance, newDistance);
        }
        //Bottom middle check
        if(j - 1 >= 0)
        {
            nI = i;
            nJ = j - 1;
            p2 = set.getHead(nI,nJ);
            newDistance = compareTwoGrids(point, p2);
            minDistance = compareDistance(minDistance, newDistance);
        }
        //Bottom right check
        if(i + 1 < set.getSize() && j - 1 >= 0)
        {
            nI = i + 1;
            nJ = j - 1;
            p2 = set.getHead(nI,nJ);
            newDistance = compareTwoGrids(point, p2);
            minDistance = compareDistance(minDistance, newDistance);
        }
        //left check
        if(i - 1 >= 0)
        {
            nI = i - 1;
            nJ = j;
            p2 = set.getHead(nI,nJ);
            newDistance = compareTwoGrids(point, p2);
            minDistance = compareDistance(minDistance, newDistance);

        }
        //right check
        if(i + 1 < set.getSize())
        {
            nI = i + 1;
            nJ = j;
            p2 = set.getHead(nI,nJ);
            newDistance = compareTwoGrids(point, p2);
            minDistance = compareDistance(minDistance, newDistance);

        }
        //top left check
        if(i - 1 >= 0 && j + 1 < set.getSize())
        {
            nI = i - 1;
            nJ = j + 1;
            p2 = set.getHead(nI,nJ);
            newDistance = compareTwoGrids(point, p2);
            minDistance = compareDistance(minDistance, newDistance);

        }
        //top middle check
        if(j + 1 < set.getSize())
        {
            nI = i;
            nJ = j + 1;
            p2 = set.getHead(nI, nJ);
            newDistance = compareTwoGrids(point, p2);
            minDistance = compareDistance(minDistance, newDistance);
        }
        //top right check
        if(i + 1 <  set.getSize() && j + 1 < set.getSize())
        {
            nI = i + 1;
            nJ = j + 1;
            p2 = set.getHead(nI, nJ);
            newDistance = compareTwoGrids(point, p2);
            minDistance = compareDistance(minDistance, newDistance);
        }

        return minDistance;
    }
}





















