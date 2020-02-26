import java.util.Random;
/**
 * IntSet.java
 *
 * @author Preston MacDonald
 * @version  3-2-2018
 */


/**
 * This is a int set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that 
 * insert a new int, finds a int key and prints the contents of the
 * data structure resp.
 */
public class IntSet {

    // Hash table - collisions resolved through chaining.
    private IntNode [] table;
    // Int array that holds the count of ints stored at each hash table index.
    private int [] numelements;
    // Allocated memory (size of the hash table).
    private int size;   

    /** 
     * Constructor: initilizes numelements, size and initial table size.
     */
    public IntSet(int newSize) {
        size = newSize;
        numelements = new int[size];
        table = new IntNode[size];
    }
    
    public int getSize()
    {
        return size;
    }

    public int getNumElementsAtI(int index)
    {
        if(index >= size)
        {
            System.out.println("ERROR: Index out of hash table range. ");
            return -1;
        }
        return numelements[index];
    }

    /*
     * inserts a new key into the set. Inserts it at the head of the linked 
     * list given by its hash value.
     *
     * @param key
     *          int to insert into IntSet.
     */
    public void insert(int key) {

        int i = 0;

        //TODO: Code for actual insert.
        i = hash(key);
        table[i] = new IntNode(key, table[i]);
        numelements[i]++;

    }

    /*
     * finds if a int key is present in the data structure. Returns true if 
     * found, else false.
     *
     * @param key
     *          A int to find in hash table.
     * @return boolean
     *          true when found otherwise false.
     */
    public boolean find(int key) {
        // TODO:
        int i = hash(key);
        for (IntNode c = table[i]; c != null; c = c.getNext())
        {
            if (c.getKey() == key)
            {
                return true;
            }
        }
        return false;
    }

    /*
     * Prints the contents of the hash table.
     */
    public void print() {
        // TODO:
        for (int i = 0; i < size; i++)
        {
            for(IntNode c = table[i]; c != null; c = c.getNext())
            {
                System.out.println(c.getKey());
            }
        }

    }

    /*
     * Prints the contents of a particular index in the hash table.
     *
     * @param index
     *          a index in the hash table.
     */
    public void printAtIndex(int index)
    {
        if(index >= size)
        {
            System.out.println("Given index is out of range!!! ");
        }
        else
        {
            for(IntNode c = table[index]; c != null; c = c.getNext())
            {
                System.out.println(c.getKey());
            }
        }
    }


    /*
     * The hash function that returns the index into the hash table for a 
     * int k.
     *
     * @param k
     *          A int to hash
     * @return h
     *          int value for the index after hashing.
     */
    private int hash(int k) {
        
        long temp = (((long)2913 *(long)k) + (long)101923) %(long)size;
        int h = (int)temp;
        return h;
        
    }

}









