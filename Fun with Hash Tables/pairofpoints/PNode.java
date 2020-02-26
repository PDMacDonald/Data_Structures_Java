/**
 * PNode.java
 *
 * @author Preston MacDonald
 * @version 2-23-18
 */

/**
 * A node that represents a point in 2-D space with a x-axis and y-axis.
 */
public class PNode
{
    
    //Field to hold x coordinate.
    private double x;
    //Field to hold y coordinate.
    private double y;
    //Field to hold reference another PNode.
    private PNode link;
    
    /**
     * Argument Constructor for PNode.
     *
     * @param newX
     *          x value to store.
     * @param newY
     *          y value to store.
     * @param newLink
     *          A link to a PNode.
     *
     */
    public PNode(double newX, double newY, PNode newLink)
    {
        x = newX;
        y = newY;
        link = newLink;
    }
    
    /**
     * Getter for x field.
     *
     * @return value stored in x.
     */
    public double getX()
    {
        return x;
    }

    /**
     * Getter for y field.
     *
     * @return value stored in y.
     */
    public double getY()
    {
        return y;
    }

    /**
     * Getter for link field.
     *
     * @return a PNode.
     */
    public PNode getLink()
    {
        return link;
    }

    /**
     * Setter for x field.
     *
     * @param newX
     *          New value to store in x.
     */
    public void setX(double newX)
    {
        x = newX;
    }
    
    /**
     * Setter for y field.
     *
     * @param newY
     *          New value to store in y.
     */
    public void setY(double newY)
    {
        y = newY;
    }
    
    /**
     * Setter for link field.
     *
     * @param newLink
     *          a reference to a PNode.
     */
    public void setLink(PNode newLink)
    {
        link = newLink;
    }




}
