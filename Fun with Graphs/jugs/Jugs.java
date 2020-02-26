/**
 * Jugs.java
 * 
 * @author Preston MacDonald
 * @version 04/20/19
 */

import java.util.Scanner;

/**
 * A program that given A, B, C, computes how to measure out exactly C units of
 * water, where A less than or equal to 1000 and B less than or equal to 1000.
 * 
 * @author Preston MacDonald
 * @version 04/20/19
 */
public class Jugs 
{

    private static Node[][] visited;
    private static int A;
    private static int B;
    private static int C;
    private static Node endState;


    /**
     * main method to run the program.
     * 
     * @param args
     * 			A list of arguments given on startup of program.
     */
    public static void main(String[] args)
    {

        Scanner keyboard = new Scanner(System.in);


        System.out.print("Enter capacity for jug A: ");
        A = keyboard.nextInt();
        System.out.print("Enter capacity for jug B: ");
        B = keyboard.nextInt();
        System.out.print("Enter target amount or C: ");
        C = keyboard.nextInt();

        keyboard.close();

        visited = new Node[(A << 1) + 2][(B << 1) + 2];

        //Initial State
        visited[0][0] = new Node(0,0);

        DFS(visited[0][0], 0, 0);

        if(endState != null)
        {
            System.out.print("Successfully found a process to measure out ");
            System.out.print(C + " Units of water, given: ");
            System.out.print("\njug A of size: " + A);
            System.out.print("\njug B of size: " + B + "\n\n");
            System.out.println("Process: ");
            printProcess();
        }
        else
        {
            System.out.print("Failed to find a process to measure out " + C);
            System.out.print(" Units of water, given: ");
            System.out.print("\njug A of size: " + A);
            System.out.print("\njug B of size: " + B + "\n\n");
        }

        System.out.println("~~~~~~~END OF PROGRAM~~~~~~~");

    }

    /**
     * A method to print out the process to get from the base state to the
     * target state.
     */
    public static void printProcess()
    {
        Node c = endState.getPrevState();
        String process = "";

        while(c.getPrevState() != null)
        {
            process = c.getAction() + " [a = " + c.getA() + " b = " + 
                c.getB() + "]\n" + process;

            c = c.getPrevState();
        }


        System.out.println(process + "\n");

    }


    /**
     * A recursive method to move through all the different states that 1 could
     * take from each individual state until arriving at the target C units of
     * water by summing the jugs a and b.
     * 
     * @param s
     * 			The starting or source node.
     * @param a
     * 			The value in the A jug.
     * @param b
     * 			The value in the B jug.
     */
    public static void DFS(Node s, int a, int b)
    {
        visited[s.getA()][s.getB()] = s;

        if(s.getA() + s.getB() == C)
        {
            endState = new Node(a,b,s);
        }

        //~~~~~~~~~~~~~ CHECK FOR FILL STATES ~~~~~~~~~~~~~~~~~
        if(s.getA() == 0 && visited[A][b] == null)
        {
            visited[A][b] = new Node(A,b,s, "Fill Jug 1");
            DFS(visited[A][b], visited[A][b].getA(), visited[A][b].getB());
        }
        if (s.getB() == 0  && visited[a][B] == null)
        {

            visited[a][B] = new Node(a,B,s, "Fill Jug 2");
            DFS(visited[a][B], visited[a][B].getA(), visited[a][B].getB());
        }

        // ~~~~~~~~~~~~~ CHECK FOR TRANSISTION STATES ~~~~~~~~~~~~~~~~~
        //Check if you can dump a into b and ensure it doesn't 
        //overflow the capacity B.
        int tempA = ((a + b) - B);

        if(tempA <= 0) //if you can dump  all of a into b.
        {
            tempA = 0;
            if(visited[tempA][a+b] == null) 
            {

                visited[tempA][a+b] = new Node(tempA,a+b,s, "Pour Jug 1 -> Jug 2");
                DFS(visited[tempA][a+b], visited[tempA][a+b].getA(), visited[tempA][a+b].getB());
            }
        }
        else  //if you can dump some of a into b.
        {
            if(visited[tempA][B] == null) 
            {

                visited[tempA][B] = new Node(tempA,B,s, "Pour Jug 1 -> Jug 2");
                DFS(visited[tempA][B], visited[tempA][B].getA(), visited[tempA][B].getB());
            }

        }

        //Check if you can dump b into a and ensure it doesn't 
        //overflow the capacity A.
        int tempB = ((a + b) - A);

        if(tempB <= 0) //if you can dump all of b into a.
        {
            tempB = 0;
            if(visited[a+b][tempB] == null) 
            {

                visited[a+b][tempB] = new Node(a+b,tempB,s, "Pour Jug 2 -> Jug 1");
                DFS(visited[a+b][tempB], visited[a+b][tempB].getA(), visited[a+b][tempB].getB());
            }
        }
        else  //if you can dump some of b into a3.
        {
            if(visited[A][tempB] == null) 
            {

                visited[A][tempB] = new Node(A,tempB,s, "Pour Jug 2 -> Jug 1");
                DFS(visited[A][tempB], visited[A][tempB].getA(), visited[A][tempB].getB());
            }

        }


        // ~~~~~~~~~~~~~ CHECK FOR DUMP OUT STATES ~~~~~~~~~~~~~~~~~
        //Dump out water in a.
        if(visited[0][b] == null)
        {
            visited[0][b] = new Node(0,b,s, "Empty Jug 1");
            DFS(visited[0][b], visited[0][b].getA(), visited[0][b].getB());
        }
        //Dump out water in b.
        if(visited[a][0] == null)
        {
            visited[a][0] = new Node(a,0,s, "Empty Jug 2");
            DFS(visited[a][0], visited[a][0].getA(), visited[a][0].getB());
        }

    }
}
