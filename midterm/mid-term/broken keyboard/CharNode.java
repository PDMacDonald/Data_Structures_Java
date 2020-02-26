/**
 * CharNode.java
 *
 * @author Preston MacDonald
 * @version 02-27-18
 */

/**
 * Class for character nodes.
 *
 * @author Preston MacDonald
 * @verson 02-27-18
 */
public class CharNode
{
    private char charValue;
    private CharNode link;
    
    /**
     * No-arg constructor for CharNode.
     *
     * @param userChar
     *      Character value to store in this node.
     */
    public CharNode(char userChar)
    {
        this.charValue = userChar;   
    }
    
    /**
     * 2-arg constructor for cntNode.
     *
     * @param userChar
     *      character value to store in this node.
     * @param node
     *      The node that this node is linked to.
     */      
    public CharNode(char userChar, CharNode node)
    {
        this.charValue = userChar;
        this.link = node;
    }
    
    /**
     * Accessor for charValue.
     *
     * @return charValue
     */
    public char getValue()
    {
        return charValue;
    }
    /**
     * Accessor for link.
     *
     * @return link
     */
    public CharNode getLink()
    {
        return link;
    }

    /**
     * Mutator for charValue.
     *
     * @param userChar
     *      Character value to store in this node.
     */
    public void setInt(char userChar)
    {
        this.charValue = userChar;
    }
    
    /**
     * Mutator for link.
     *
     * @param node
     *      The node that this node is linked to.
     */
    public void setLink(CharNode node)
    {
        this.link = node;
    }


}
