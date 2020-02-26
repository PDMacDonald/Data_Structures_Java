/**
 * CoupleMatching.java
 *
 * @author Preston MacDonald
 * @version 01-19-2018
 */

import java.util.Scanner;

/**
 * Class created to find the correct match pairing without any block pairs.
 */
public class CoupleMatching
{
 

    public static void main(String[] args)
    {
        int n = 4;

        int[][] boys = {{1,3,2,4},
                        {1,2,3,4},
                        {2,4,3,1},
                        {4,3,2,1}};

        int[][] girls = {{3,2,4,1},
                         {2,1,3,4},
                         {3,1,2,4},
                         {2,3,1,4}};
        
        findMatches(boys, girls); 
    }

    private static void findMatches(int[][] b, int[][] g)
    {
        int matches = 0;
        int choice = 1;
        int[] requests = new int[b.length];

        //while(matches != b.length || choice >= 5)
        {
            for(int i = 0; i < b.length; i++)
            {
                for(int j = 0; j < b.length; j++)
                {
                    if(b[i][j] == choice)
                    {
                        if(requests[j] == 0)
                        {
                            matches++;    
                        }
                        else if(|| requests[j] > g[j][i])
                        {
                            requests[j] = i;
                        }
                    }
                }
           }

           System.out.println("Matches = " + matches);

           choice++;
        }

        printMatches(requests);
    }

    private static void printMatches(int[] pairs)
    {
        for(int i = 0; i < pairs.length; i++)
        {
            System.out.println("Boy " + (pairs[i]+1) + " pairs with girl " + (i+1));
        }
        System.out.println("\n");
    }

}

