/**
 * CharSet.java
 *
 * @author Preston MacDonald
 * @version 02-27-18
 */

/**
 * set of character nodes implemented with a linked with a reference to head
 * and tail nodes.
 *
 * @author Preston MacDonald
 * @version 02-27-18
 */
public class CharSet
{
    private CharNode head;
    private CharNode tail;
    private CharNode ins;
    private int size;

    /**
     * No-arg constructor.
     */
    public CharSet()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Inserts a character to the front of the set.
     */
    public void insertFront(char newChar)
    {
        if(size == 0)
        {
            head = new CharNode(newChar);
            ins = head;
            tail = head;
        }
        else
        {
            head = new CharNode(newChar, head);
            ins = head;
        }

        size++;
    }
    
    /**
     * Inserts a character after the head node.
     */
    public void insertAfterHead(char newChar)
    {
        if(size == 0)
        {
            head = new CharNode(newChar);
            tail = head;
            ins = head;
        }
        if(size == 1)
        {
            tail = new CharNode(newChar);
            ins = tail;
            head.setLink(tail);   
        }
        else
        {
            ins.setLink(new CharNode(newChar, ins.getLink()));
            ins = ins.getLink();
        }

        size++;
    }

    /**
     * Inserts a character to the tail of the set.
     */
    public void insertRear(char newChar)
    {
        if(size == 0)
        {
            head = new CharNode(newChar);
            tail = head;
        }
        else
        {
            tail.setLink(new CharNode(newChar));
            tail = tail.getLink();
        }

        size++;
    }

    


    /**
     * Find if a char is present in the set. Returns false if the key is not
     * present, otherwise returns true.
     *
     * @param targetChar
     *          character to find.
     * @return true if present
     *          otherwise false.
     */
    public boolean find(char targetChar)
    {
        CharNode cursor = head;
        while(cursor != null)
        {
            if(cursor.getValue() == targetChar)
            {
                return true;
            }
            
            cursor = cursor.getLink();
        }

        return false;
    }


    /**
     * Print the contents of char set from head node to tail.
     */
    public void print()
    {
        CharNode cursor = head;

        while(cursor != null)
        {
            System.out.print(cursor.getValue());
            cursor = cursor.getLink();
        }

    }
}

