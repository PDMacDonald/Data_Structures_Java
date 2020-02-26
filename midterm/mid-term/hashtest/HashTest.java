import java.util.Scanner;

public class HashTest {

	public static void main(String [] args) {
		if (args.length != 1) {
			System.out.println("Please execute: java Prog <n> ");
			System.out.println("n is the input size.");
			System.exit(0);
		} 

		int n = Integer.parseInt(args[0]);	// n is both the number of keys and the table size.

		// TODO: Write code to to test if there are n keys in the file that all hash to the same index. 
		// If yes, print the keys.
		
        int key = 0;
        Scanner kb = new Scanner(System.in);
        IntSet set = new IntSet(n); 

        while(kb.hasNext())
        {
            key = kb.nextInt();
            set.insert(key);
        }
        
        kb.close();
        
        System.out.println("\n*****input recieved and placed in hash table.*****\n");

        
        for(int i = 0; i < set.getSize(); i++)
        {
           if(set.getNumElementsAtI(i) == n)
           {
                System.out.print("Yay! There are " + n + " elements in index ");
                System.out.println( i + ". The keys are: ");
                set.printAtIndex(i);
           } 
        }
        
        System.out.println("\n***** END OF PROGRAM *****\n");
    }   
}
