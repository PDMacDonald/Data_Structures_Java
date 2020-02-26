/**
 * WordLadder.java
 * 
 * @author Preston MacDonald
 * @version 04/20/18
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordLadder {

    //Lower bound decimal number for lowercase ASCII letters.
    private static final int LOWBOUND = 97;
    //Upper bound decimal number for lowercase ASCII letters.
    private static final int UPBOUND = 122;

    //private static int testCount = 0;
    private static boolean found = false;

    private static String start;
    private static String end;
    private static StringMap T;			// This map stores the dictionary of words.
    private static StringMap R;			// This map keeps track of all the words that are visited during breadth-first-search.
    private static Queue Q;					// A queue to perform the breadth-first-search.

    public static void main(String [] args) throws IOException {
        // Loading the dictionary of words into the StringMap T.
        T = new StringMap();
        File file = new File("dictionary4");
        Scanner f = new Scanner(file);
        while (f.hasNext()) {
            String word = f.nextLine();
            T.insert(word, "");
        }
        f.close();

        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the start word: ");
        start = kb.nextLine();
        System.out.print("Enter the end word: ");
        end = kb.nextLine();

        kb.close();

        // TODO: Solution to find the shortest set of words that transforms the start word to the end word.
        start = start.toLowerCase();
        end = end.toLowerCase();
        Q = new Queue();
        R = new StringMap();

        if(T.find(start) != null && T.find(end) != null)
        {

            int disFromS = 0;

            Q.enqueue(new QNode(0, start));
            R.insert(start, null);

            while(!Q.isEmpty())
            {
                QNode cursor = Q.dequeue();
                disFromS++;

                //finds all words that has a 1 letter difference.
                findAlternatives(cursor.getWord(), disFromS);    

                //If word is found
                if (found)
                {
                    System.out.print("A word ladder has been found for: ");
                    System.out.println(start + " --> " + end + ".");
                    System.out.println("Shortest word ladder: ");

                    String ladder = "";
                    StringNode c = R.find(end);

                    while(!c.getKey().equals(start))
                    {
                        if(c.getKey().equals(end))
                        {
                            ladder += c.getKey();
                        }
                        else
                        {
                            ladder = c.getKey() + "\n" + ladder;
                        }
                        c = R.find(c.getValue());
                    }

                    ladder = R.find(start).getKey() + "\n" + ladder;

                    System.out.print(ladder + "\n");

                    break;
                }


            }

            if (!found)
            {
                System.out.print("A word ladder was not found for: ");
                System.out.println(start + " --> " + end + ".");
                //System.out.println(found);
            }


        }
        else
        {
            System.out.println("ERROR: must have valid words for input!");
        }
    }



    /**
     * This sub-method finds alternatives to a given word if any are listed
     * in the dictionary.
     *
     * @param word
     *          Word to find alternatives of.
     */ 
    private static void findAlternatives(String word, int dis)
    {
        word = word.toLowerCase();
        StringBuffer altWord = new StringBuffer(word);


        for(int i = 0; i < altWord.length(); i++)
        {
            char temp = altWord.charAt(i);

            for(int j = LOWBOUND; j <= UPBOUND; j++) //starting at 'a' to 'z'
            {
                altWord.setCharAt(i, (char)j);

                if(altWord.toString().equals(end))
                {
                    found = true;
                }

                //Check if new arrangement is in the dictionary
                if(T.find(altWord.toString()) != null)
                {
                    //Check if new arrangement has been recorded already.
                    if(R.find(altWord.toString()) == null)
                    {
                        //testCount++;
                        //System.out.println(testCount);
                        R.insert(altWord.toString(), word);
                        Q.enqueue(new QNode(dis, altWord.toString()));
                    }
                }
            }
            altWord.setCharAt(i, temp); //Goes back to original representation
        }

    }


}
