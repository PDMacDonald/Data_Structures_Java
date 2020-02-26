/**
 * IntSet.java
 */

/**
 * This class maintains a set of integers. 
 *
 * @author Preston MacDonald
 * @version 02-02-18
 */
public class IntSet {

    private IntNode head;
    private int size;

    
    /**
     * No-arg constructor for IntSet.
     */	
	public IntSet() {
        this.head = null;
        this.size = 0;
	}
	
	/* Find if a key is present in the set. Returns false if the key is not
     * present, otherwise returns the position in the set.
     *
     * @param key
     *      Target int value to search for.
     * @return position
     *      An int value that represents the number of links before
     *      encountering target key.
     */
	public boolean find(int key) {
        
        IntNode nextNode = head;
        int linkCount = 0;

		while (nextNode.getLink() != null) 
        {
			if(nextNode.getValue() == key)
            {
                return true;
            }
            
            linkCount++;
            nextNode = nextNode.getLink();
		}
		return false;
	}
	
	/* Insert a key into the set. */
	public void insert(int key) {
		// Make sure that the key is not present.
		assert (!find(key));
		
		// Perform insert.
        if(size == 0) //if set is empty
        {
            head = new IntNode(key);
        }
        else if(key < head.getValue()) //When new value is the smallest in set.
        {
            head = new IntNode(key, head);
        }
        else
        {
           IntNode cursor = head;
           
           while(cursor != null)
           {
                IntNode preCursor = cursor;
                cursor = cursor.getLink();

                if(key < cursor.getValue())
                {
                    preCursor.setLink(new IntNode(key, cursor));
                    break;
                }
                else if(cursor.getLink() == null) //if end of set
                {
                    cursor.setLink(new IntNode(key));
                    break;
                }

           }
        }
        
        size++;   
	}
	
	/* Remove a key from the set. */
	public void remove(int key) {
		// Make sure that the key is present.
		assert (find(key));
		
        IntNode cursor = head;

        if(size == 1) //if only 1 element in set.
        {
            head = null;
        }
        else
        {
            if(key == head.getValue()) //if removal is at head
            {
                head = head.getLink();
            }
            else
            {
                while(cursor.getLink() != null)
                {
                    if(key == cursor.getLink().getValue())
                    {
                        cursor.setLink(cursor.getLink().getLink());
                    }
                    cursor = cursor.getLink();
                }
            }
        }

        size--;
	}
	
	/* Print the contents of the set in sorted order. */
	public void print() {
		
        IntNode cursor = head;

        while(cursor != null)
        {
			System.out.print(cursor.getValue() + " ");
            cursor = cursor.getLink();
        }

        System.out.println("\n *****End of Printout***** \n");
	}
}
