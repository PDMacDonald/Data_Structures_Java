import java.util.Scanner;
import java.io.*;
/**
 * SpellChecker.java
 *
 * @author Preston MacDonald
 * @version 2-23-2018
 */


/*
 * This class implements a spell checker application. 
 * This class requires a proper implementation to the StringSet class.
 */
public class SpellChecker {

    //Lower bound decimal number for lowercase ASCII letters.
    private static final int LOWBOUND = 97;
    //Upper bound decimal number for lowercase ASCII letters.
    private static final int UPBOUND = 122;
    
    /**
     * main method that creates a StringSet to hold a dictionary and then
     * spell checks provided input against the dictionary.
     *
     * @param args
     *          String arguments
     */
    public static void main(String [] args) {

        File f = new File("dictionary");

        try {
            Scanner sk = new Scanner(f);

            StringSet x = new StringSet();

            // Read in the entire dictionary...
            while (sk.hasNext()) {
                String word = sk.next();
                x.insert(word);      
            }
            System.out.println("Dictionary loaded...");

            sk = new Scanner(System.in);
            System.out.print("Please input a word (Ctrl-d to exit): ");

            // Keep suggesting alternatives as long as the user makes an input.
            while (sk.hasNext()) {

                String word = sk.next();
                
                if (x.find(word))
                    System.out.println(word + " is correct.");
                else {
                    System.out.println("Suggesting alternatives ...");
                    // TODO: Code to do the spell checker. Look into the 
                    //       StringSet for all possible alternatives of the 
                    //       input word mis-spelled by one character.
                    findAlternatives(word, x); 
                }

                System.out.print("Please input a word (Ctrl-d to exit): ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        } 

        System.out.println("\n~~~~~ END OF PROGRAM ~~~~\n");
    }


    
    /**
     * This sub-method finds alternatives to a given word if any are listed
     * in the dictionary.
     *
     * @param word
     *          Word to find alternatives of.
     * @param x
     *          A instance of a stringset that contains a dictionary of english
     *          words.
     */ 
    private static void findAlternatives(String word, StringSet x)
    {
        word = word.toLowerCase();
        StringBuffer altWord = new StringBuffer(word);
        
        for(int i = 0; i < altWord.length(); i++)
        {
            char temp = altWord.charAt(i);

            for(int j = LOWBOUND; j <= UPBOUND; j++) //starting at 'a' to 'z'
            {
                altWord.setCharAt(i, (char)j);
                
                //Check if new arrangment is in the dictionary
                if(x.find(altWord.toString()))
                {
                    System.out.println(altWord.toString());
                }
            }
            altWord.setCharAt(i, temp); //Goes back to original representation
        }
        

        
    }
}
