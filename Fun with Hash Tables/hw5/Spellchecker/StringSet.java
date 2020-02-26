import java.util.Random;
/**
 * StringSet.java
 *
 * @author Preston MacDonald
 * @version  2-23-2018
 */


/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that 
 * insert a new String, finds a String key and prints the contents of the
 * data structure resp.
 */
public class StringSet {

    // Hash table - collisions resolved through chaining.
    private StringNode [] table;
    // Number of elements actually stored in the structure.
    private int numelements;
    // Allocated memory (size of the hash table).
    private int size;   
    // A random prime number generated in constructor.
    private int randomPrime;  
    //Instance of Random to generate nums.
    private Random rand = new Random();    

    /** 
     * Constructor: initilizes numelements, size and initial table size.
     */
    public StringSet() {
        numelements = 0;
        size = 100;
        randomPrime = findRandomPrime();
        table = new StringNode[size];
    }

    /*
     * inserts a new key into the set. Inserts it at the head of the linked 
     * list given by its hash value.
     *
     * @param key
     *          String to insert into StringSet.
     */
    public void insert(String key) {

        int i = 0;

        if (numelements == size) {
            //TODO: need to expand the hash table and rehash its contents. 
            
            size = size * 2;

            StringNode[] nTable = new StringNode[size];

            for (int j = 0; j < table.length; j++)
            {
                for(StringNode c = table[j]; c != null; c = c.getNext())
                {
                    i = hash(c.getKey());
                    nTable[i] = new StringNode(c.getKey(), nTable[i]);
                }
            }
            table = nTable;
        }


        //TODO: Code for actual insert.
        i = hash(key);
        table[i] = new StringNode(key, table[i]);
        numelements++;

    }

    /*
     * finds if a String key is present in the data structure. Returns true if 
     * found, else false.
     *
     * @param key
     *          A string to find in hash table.
     * @return boolean
     *          true when found otherwise false.
     */
    public boolean find(String key) {
        // TODO:
        int i = hash(key);
        for (StringNode c = table[i]; c != null; c = c.getNext())
        {
            if (c.getKey().equals(key))
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
            for(StringNode c = table[i]; c != null; c = c.getNext())
            {
                System.out.println(c.getKey());
            }
        }

    }

    /*
     * The hash function that returns the index into the hash table for a 
     * string k.
     *
     * @param k
     *          A string to hash
     * @return h
     *          int value for the index after hashing.
     */
    private int hash(String k) {
        int h = 0;
        // TODO: Compute a polynomial hash function for the String k. Make sure
        //       that the hash value h returned is a proper index in the hash 
        //       table, ie. in the range [0...capacity-1].

        for (int i = 0; i < k.length(); i++)
        {
            h = ((h * randomPrime) + (int) k.charAt(i)) % size;
        }

        return h;
    }


    /**
     * Finds and selects a random prime number from a list of primes
     * between 0-10000.
     *
     * @return primeNumber
     */
    private int findRandomPrime()
    {
        int randInt;

        while (true)
        {
            randInt = rand.nextInt(10000);

            if (randInt <= 2 || randInt % 2 != 0)
            {
                for (int i = 3; i <= Math.sqrt(randInt); i += 2)
                {
                    if ((randInt % i) != 0 && randInt > 1)
                    {
                        return randInt;
                    }
                }
            }
        }                    
    }





}









