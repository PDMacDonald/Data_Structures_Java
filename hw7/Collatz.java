/**
  * Collatz.java
  *
  * @author Preston MacDonald
  * @version 04-11-18
  */

import java.util.Scanner;

/**
 * Finds maximum Collatz length.
 */
public class Collatz
{
    private static long maxLen = 0;
    private static long maxX;
    private static final int MAX = 2000000;
    private static final int MAXAB = 100000000;
    private static long[] collatzL = new long[MAX]; 

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        long a, b;
        collatzL[1] = 1;
        do
        {
            System.out.println("Enter the range: ");
            a = keyboard.nextInt();
            b = keyboard.nextInt();
        }
        while( a < 1 || a > b || b > MAXAB || b < 1);
        long i = a;
        
        while(i <= b) 
        {
            long newLen = collatzLength(i);
            if(maxLen < newLen)
            {
                maxLen = newLen;
                maxX = i;
            }

            i++;
        }

        System.out.println("Value with max Collatz Length = " + maxX);
        System.out.println("It's Collatz length: " + maxLen); 
    }

    public static long collatzLength(long x)
    {

        if(x < MAX && collatzL[(int)x] != 0)
        {
            return collatzL[(int)x];
        }
        if(x % 2 == 0)
        {
            if(x < MAX)
            {
                collatzL[(int)x] = 1 + collatzLength(x >> 1);
                return collatzL[(int)x];
            }
            else
            {
                return 1 + collatzLength(x >> 1);
            }
        }
        else
        {
            if(x < MAX)
            {
                collatzL[(int)x] = 2 + collatzLength((3*x+ 1) >> 1);
                return collatzL[(int)x];
            }
            else
            {
                return 2 + collatzLength((3*x+1) >> 1);
            }
        }
    }
}


