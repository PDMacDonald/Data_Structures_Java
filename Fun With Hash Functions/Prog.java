/**
 * Prog.java
 *
 * @author Preston MacDonald
 * @version 02-19-2018
 */

import java.lang.Integer;

public class Prog {

	public static void main(String [] args) {
		
		if (args.length != 2) {
			System.out.println("Please execute: java Prog <n> <p>");
			System.out.println("n is the input size, and p is the program number.");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);

		switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static void prog1(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash1.
        int key = 0;
        int index = 0;
        HashFunctions hFunction = new HashFunctions(n);
        
        System.out.println("\n---For " + n + " keys using hash function #1---\n");
        for(int i = 1; i <= n; i++)
        {
            index = hFunction.hash1(key);
            System.out.print(i + ". key = " + key);
            System.out.println(" table index after hash = " + index);
            key += n;
        }
        
        System.out.println();	
	}

	private static void prog2(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash2.	
        int key = 0;
        int index = 0;
        HashFunctions hFunction = new HashFunctions(n);

        System.out.println("\n---For " + n + " keys using hash function #2---\n");
        for(int i = 1; i <= n; i++)
        {
            index = hFunction.hash2(key);
            System.out.print(i + ". key = " + key);
            System.out.println(" table index after hash = " + index);
            key += 1;
        }

    }
   
   
    
	private static void prog3(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.
        int key = 0;
        int count = 0;
        int index = 0;
        HashFunctions hFunction = new HashFunctions(n);
        
        System.out.println("\n---For " + n + " keys using hash function #3---\n");
        while(count < n)
        {
            index = hFunction.hash4(key);
            if(index == 0)
            {
                count++;
                System.out.print(count + ". key = " + key);
                System.out.println(" table index after hash = " + index);

            }
            key += 1;

        }
	}


	private static void prog4(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.	
	    int key = 0;
        int index = 0;
        int count = 0;
        System.out.println("\n---For " + n + " keys using hash function #4---\n");
        
        HashFunctions hFunction = new HashFunctions(n);

        while(count < n)
        {   
            index = hFunction.hash4(key);
            if(index == 0)
            {
                count++;
                System.out.print(count + ". key = " + key);
                System.out.println(" table index after hash = " + index);
            }
            key += 1;
        }
    }
}
