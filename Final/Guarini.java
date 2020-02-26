import java.util.HashMap;
import java.util.LinkedList;

public class Guarini {
    private static final int n = 3;	// Number of knights.
    private static HashMap<Node, Node> visited; // HashMap that stores both the visited nodes, and their backpointers.
    private static Node startState;	// The start state.
    private static Node goalState;	// The goal state.
    private static int MAPSIZE = 1000;
    private static MyQueue Q;

    private static boolean found = false;

    private static boolean checkBoundary(int r, int c) {
        if (r >= 0 && r < n && c >= 0 && c < n) return true;
        return false;
    }

    /*
       Returns a deep copy of the state array.
       */
    private static int [] copyState(int [] state) {
        int [] newstate = new int[state.length];
        for (int i = 0; i < state.length; ++i)
            newstate[i] = state[i];
        return newstate;
    }

    /*
       A handy funciton to swap two items in state.
       */
    private static void swap(int [] state, int i, int j) {
        int temp = state[i];
        state[i] = state[j];
        state[j] = temp;
    }

    /*
       Creates a new state in position i, with a new knight move to positiion (row, col) in the board.
       Returns null if another piece already occupies this position. Otherwise returns a valid state (Node object).
       */
    private static Node createStateAtI(int [] state, int i, int row, int col) {
        int [] newstate = copyState(state);
        int index = row * n + col;

        for (int j = 0; j < state.length; ++j) {
            if (state[j] == index)
                return null;
        }

        newstate[i] = index;
        if (i < n) {
            for (int j = i - 1; j >= 0 && newstate[i] < newstate[j]; j--, i--) 
                swap(newstate, i, j);
            for (int j = i + 1; j < n && newstate[i] > newstate[j]; j++, i++)
                swap(newstate, i, j);
        }
        else {
            for (int j = i - 1; j >= n && newstate[i] < newstate[j]; j--, i--) 
                swap(newstate, i, j);
            for (int j = i + 1; j < 2 * n && newstate[i] > newstate[j]; j++, i++)
                swap(newstate, i, j);
        }
        return new Node(newstate);
    }

    /*
       This function returns a list of valid neighbors of node or state x.
       Neighbors are states that can be reached my moving any of the knights.
       */
    private static LinkedList<Node> getNeighbors(Node x) {
        LinkedList<Node> neighborList = new LinkedList<Node>();
        int [] state = x.getState();
        for (int i = 0; i < state.length; ++i) {
            int row = state[i] / n;
            int col = state[i] % n;

            if (checkBoundary(row - 2, col - 1)) {
                Node neighbor = createStateAtI(state, i, row - 2, col - 1);
                if (neighbor != null) neighborList.add(neighbor);
            }
            if (checkBoundary(row - 1, col - 2)) {
                Node neighbor = createStateAtI(state, i, row - 1, col - 2);
                if (neighbor != null) neighborList.add(neighbor);
            }
            if (checkBoundary(row + 1, col - 2)) {
                Node neighbor = createStateAtI(state, i, row + 1, col - 2);
                if (neighbor != null) neighborList.add(neighbor);
            }
            if (checkBoundary(row + 2, col - 1)) {
                Node neighbor = createStateAtI(state, i, row + 2, col - 1);
                if (neighbor != null) neighborList.add(neighbor);
            }

            if (checkBoundary(row - 2, col + 1)) {
                Node neighbor = createStateAtI(state, i, row - 2, col + 1);
                if (neighbor != null) neighborList.add(neighbor);
            }
            if (checkBoundary(row - 1, col + 2)) {
                Node neighbor = createStateAtI(state, i, row - 1, col + 2);
                if (neighbor != null) neighborList.add(neighbor);
            }
            if (checkBoundary(row + 1, col + 2)) {
                Node neighbor = createStateAtI(state, i, row + 1, col + 2);
                if (neighbor != null) neighborList.add(neighbor);
            }
            if (checkBoundary(row + 2, col + 1)) {
                Node neighbor = createStateAtI(state, i, row + 2, col + 1);
                if (neighbor != null) neighborList.add(neighbor);
            }
        }
        return neighborList;
    }

    public static void main(String [] args) {
        // initializing start and goal states.
        int start [] = new int[2 * n];
        int goal [] = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            start[i] = i;
            start[n + i] = (n-1) * n + i;
            goal[i] = (n-1) * n + i;
            goal[n + i] = i;
        }
        startState = new Node(0, start);
        goalState = new Node(goal);
        visited = new HashMap<Node, Node>(MAPSIZE);
        // TODO: Please write code that prints the solution to the Guarini's puzzle variant with the smallest number of moves.
        // Please follow the output as shown in the handout.

        //Initializations
        Q = new MyQueue();
        int disFromS = 0;

        // Setup for BFS
        Q.enqueue(startState);
        visited.put(startState, null);


        while(!Q.isEmpty())
        {
            Node cursor = Q.dequeue();
            disFromS++;

            findNewStates(cursor, disFromS);

            //If goal state is reached.
            if (found)
            {
                System.out.print("Here is the valid set of moves:\n");


                Node c = goalState;
                LinkedList<Node> printOrder = new LinkedList<Node>();

                while(c != null /*.equals(startState)*/)
                {
                    printOrder.addFirst(c);
                    c = visited.get(c);
                }

                for(int i = 0; i < printOrder.size(); i++)
                {
                    printOrder.get(i).print();
                }



                break;
            }

        }

        System.out.println("\n\n~~~~~~~~ END OF PROGRAM ~~~~~~~~\n");


    }

    private static void findNewStates(Node state, int dis)
    {
        LinkedList<Node> neighbors = getNeighbors(state);
        Node altState;

        for(int i = 0; i < neighbors.size(); i++)
        {
            altState = neighbors.get(i);

            if(altState.equals(goalState)) // check if you reached goal.
            {
                found = true;
            }

            //Check if altState has been recorded already. if not then..
            if(!visited.containsKey(altState))
            {
                //record
                visited.put(altState, state);
                Q.enqueue(new Node(dis, altState.getState()));
            }
        }



    }
}







