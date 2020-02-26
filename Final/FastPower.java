/**
 * FastPower.java
 * 
 * @author Preston
 * @version 05-04-18
 */

import java.util.Scanner;


/**
 * Program that accepts a and b as inputs and prints a^b.
 * 
 * @author Preston
 */
public class FastPower {

    private final static int M = 100000007;
    private static Scanner kb;

    /**
     * Main method to run program.
     * @param args
     * 			A array of string arguments.
     */
    public static void main(String[] args)
    {
        kb = new Scanner(System.in);
        int a;
        int b;

        //request input.
        System.out.print("Enter a: ");
        a = kb.nextInt();
        System.out.print("Enter b: ");
        b = kb.nextInt();

        kb.close();

        System.out.println(a + "^" + b + " mod " + M + " is " + cFP(a,b));

    }

    /**
     * A method to calculate a^b recursively very quickly.
     * 
     * @param a
     * 			A int to be raised to a power of b.
     * @param b
     * 			A int that represents the power.
     * @return
     * 			a to the power of b.
     */
    private static long cFP(int a, int b)
    {

        long temp;

        a = a % M;

        if( b == 0)
        {
            return 1;
        }
        else if( b == 1)
        {
            return a;
        }
        else if( (b & 1) == 0) // if even
        {
            temp = cFP(a, b>>1) % M;
            return ((temp) * (temp)) % M;
        }
        else // if odd
        {
            temp = cFP(a, b>>1) % M;
            return (((temp) * (temp))% M * a)  % M;
        }
    }

}































