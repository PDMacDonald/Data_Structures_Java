/**
 * PointSet.java
 *
 * @author Preston MacDonald
 * @version 2-23-2018
 */

/**
 * This is a 2-Dimensional point set data structure, that is implemented using
 * a Hash Table. This data structure supports operations insert, find, and
 * print. Insert takes a new 2-D point and inserts it into a hash table. find
 * locates a point within a hash table. Print prints out all contents within
 * hash table.
 *
 * @author Preston MacDonald
 * @version 2-23-2018
 */
public class PointSet
{
    private final int DIMENSIONS = 2;
    private final int DEFAULT_SIZE = 100;
    
    // Hash table as a square grid - collision resolved through chaining.
    private PNode[][] grid;
    // Number of elements actually stored in structure.
    private int numElements;
    // size of hash table.
    int size;
    // Size of subgrid.
    double subGridSize;
    
    /**
     * argument constructor that builds a point set with the given subgrid
     * size.
     *
     * @param newSubGridSize
     *          Size of sub grids in pointset.
     */
    public PointSet(double newSubGridSize)
    {
        subGridSize = newSubGridSize;
        size = DEFAULT_SIZE;
        numElements = 0;
        grid = new PNode[size][size];
    }
    
    /**
     * Getter method for size.
     *
     * @return size of hash table of subgrids.
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * Getter method for retrieving the head point given indexes to a subgrid.
     *
     * @param x
     *          X value of sub grid location.
     * @param y 
     *          Y value of sub grid location.
     * @return reference to PNode
     */
    public PNode getHead(int x, int y)
    {
        if(x > size || y > size)
        {
            return null;
        }
        return grid[x][y];
    }
    /**
     * Insert method for inputing a point to the PointSet.
     *
     * @param xKey
     *          x value of point.
     * @param yKey
     *          y value of point.
     */
    public void insert(double xKey, double yKey)
    {
       int[] i = new int[2];
       if ((int)(xKey / subGridSize) >= size ||
            (int)(yKey / subGridSize) >= size)
       {
            resize(xKey, yKey);
       }
        
        i = hash(xKey, yKey);
        grid[i[0]][i[1]] = new PNode(xKey, yKey, grid[i[0]][i[1]]);

    }
    
    /**
     * Method to find a particular point in the set.
     *
     * @param xKey
     *          x value of point.
     * @param yKey
     *          y value of point.
     * @return true if found otherwise false
     */
    public boolean find(double xKey, double yKey)
    {
        int[] i = new int[2];
        i = hash(xKey, yKey);
        for (PNode c = grid[i[0]][i[1]]; c != null; c = c.getLink())
        {
            if (c.getX() == xKey && c.getY() == yKey)
            {
                return true;
            }
        }
        
        return false;   
    }
    
    /**
     * Method to print every point stored in this point set.
     */
    public void print()
    {
        for (int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                for(PNode c = grid[i][j]; c != null; c = c.getLink())
                {
                    System.out.println("sub grid = " + i + ", " + j);
                    System.out.println(c.getX() + " " + c.getY());
                }
            }
        }
    }
    
    /**
     * Hash function that simply divides both x and y by the size of sub grids
     * and returns a index for both x and y to store the value.
     *
     * @param xKey
     *          X value of point.
     * @param ykey
     *          Y value of point.
     * @return 2 indexes representing position in hash table.
     */
    private int[] hash(double xKey,  double yKey)
    {
        int[] h = new int[DIMENSIONS];

        h[0] = (int)(xKey / subGridSize);
        h[1] = (int)(yKey / subGridSize);

        return h;
    }
    
    /**
     * Sub method to insert that resizes the table when the need arises.
     *
     * @param xKey
     *      X value of point.
     * @param yKey
     *      Y value of point.
     */
    private void resize(double xKey, double yKey)
    {
        int nSize = 0;
        int[] i = new int[DIMENSIONS];

        //Find biggest key and use its value to calculate nSize (new size).
        if( xKey > yKey)
        {
            nSize = (int)(xKey / subGridSize);
        }
        else
        {
            nSize = (int)(yKey / subGridSize);
        }

        nSize = nSize + size;
        PNode[][] nGrid = new PNode[nSize][nSize];
        
        //Move contents of original hash to newly sized hash.
        for (int k = 0; k < grid.length; k++)
        {
            for(int j = 0; j < grid.length; j++)
            {
                for(PNode c = grid[k][j]; c != null; c = c.getLink())
                {
                    i = hash(c.getX(), c.getY());
                    nGrid[i[0]][i[1]] = new PNode(c.getX(), c.getY(), nGrid[i[0]][i[1]]);
                }
            }
        }
        size = nSize; 
        grid = nGrid;
    }
    
}
























