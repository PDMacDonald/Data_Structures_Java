
public class Node {
    private int [] state;	// Represents a single state
    private int len;			// Length of array state.
    private int MAPSIZE = 1000; // Default size.
    private int dist;
    private int PRIME = 17;
    private int MAX = 10000;
    /**
Constructor: accepts an array s, and creates a deep copy.
     **/
    public Node(int [] s) {
        len = s.length;
        dist = MAX;
        state = new int[len];
        for (int i = 0; i < len; ++i)
            state[i] = s[i];
    }

    public Node(int newD, int [] s) {
        len = s.length;
        dist = newD;
        state = new int[len];
        for (int i = 0; i < len; ++i)
            state[i] = s[i];
    }

    public Node(Node p) {
        len = p.getLength();
        dist = p.getDist();
        state = p.getState().clone();
    }

    public int getDist()
    {
        return dist;
    }

    /**
      Returns the state.
     **/
    public int [] getState() {
        return state;
    }

    /**
      Returns the length.
     **/
    public int getLength() {
        return len;
    }

    /**
      Returns the hash of array state.
TODO: Please compute the hash of the contents of array state using polynomial hashing.
     **/
    public int hashCode() {

        int h = 0;

        for (int i = 0; i < len; i++)
        {
            h = ((h * PRIME) + state[i]) % MAPSIZE;
        }
        return h;
    }

    /**
      Overriding the equals method. Returns true if two node objects are equal. They are equal
      if the corresponding contents of the state array are the same, and the corresponding lengths are equal.
TODO: Write code to complete to compare if two Node objects are equal.
     **/
    public boolean equals(Object rhs) {
        if(rhs instanceof Node)
        {
            Node otherN = (Node)rhs;
            if(len == otherN.len)
            {
                if(hashCode() == otherN.hashCode())
                {
                    return true;
                }
            }
        }

        return false;

    }

    /**
      Prints the state as a board with n black and n white knights.
     **/
    public void print() {
        int n = len / 2;
        char [][] board = new char[n][n];
        for (int i = 0; i < len; ++i) {
            int index = state[i];
            int row = index / n;
            int col = index % n;
            if (i < n)
                board[row][col] = 'o';
            else
                board[row][col] = '*';
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[n-i-1][j] == '\0')
                    System.out.print('.');
                else
                    System.out.print(board[n-i-1][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
      Overriding the toString method to print the array representation of the state. For the board representation, call print.
     **/
    public String toString() {
        String st = "";
        for (int i = 0; i < len; ++i)
            st = st + state[i] + " ";
        return st;
    }

}
