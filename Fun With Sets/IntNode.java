/**
 * IntNode.java
 *
 * @author Preston MacDonald
 * @version 01-31-18
 */

/**
 * Class for integer nodes.
 *
 * @author Preston MacDonald
 * @verson 01-31-18
 */
public class IntNode
{
    private int intValue;
    private IntNode link;
    
    /**
     * No-arg constructor for IntNode.
     *
     * @param userInt
     *      Integer value to store in this node.
     */
    public IntNode(int userInt)
    {
        this.intValue = userInt;   
    }
    
    /**
     * 2-arg constructor for IntNode.
     *
     * @param userInt
     *      Integer value to store in this node.
     * @param node
     *      The node that this node is linked to.
     */      
    public IntNode(int userInt, IntNode node)
    {
        this.intValue = userInt;
        this.link = node;
    }
    
    /**
     * Accessor for intValue.
     *
     * @return intValue
     */
    public int getValue()
    {
        return intValue;
    }
    /**
     * Accessor for link.
     *
     * @return link
     */
    public IntNode getLink()
    {
        return link;
    }

    /**
     * Mutator for intValue.
     *
     * @param userInt
     *      Integer value to store in this node.
     */
    public void setInt(int userInt)
    {
        this.intValue = userInt;
    }
    
    /**
     * Mutator for link.
     *
     * @param node
     *      The node that this node is linked to.
     */
    public void setLink(IntNode node)
    {
        this.link = node;
    }


}
