/**
 * NQueens.java
 *
 * @author Preston MacDonald
 * @version 04-11-18
 */

import java.util.Scanner;

public class NQueens
{
    private static int queens;
    private static int arrangements;
    private static int x;

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        arrangements = 0;

        System.out.print("Enter the number of queens: ");
        queens = keyboard.nextInt();
        x = (1 << queens) - 1;

        findArrangements(0, 0, 0, 0);

        System.out.print("Number of valid arrangments: " );
        System.out.print(arrangements);
        System.out.println(); 
    }
    
    public static void findArrangements(int y, int l,  int d, int r)
    {
        int t;
        int c;
        if(y == queens)
        {
            arrangements++;
        }
        else
        {

            t = x & ~(l | d | r);
            while(t != 0)
            {
                c = -t & t;
                t ^= c;
                findArrangements(y + 1, (l | c) << 1, d | c, (r | c) >> 1);
            }
        }

    }




}
