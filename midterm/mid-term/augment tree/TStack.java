/**
 * TStack.java
 *
 * @author Preston MacDonald
 * @version 03-3-18
 */

/**
 * A stack of tree nodes implemented using an array limited to a given CAP.
 *
 * @author Preston MacDonald
 * @version 03-03-18
 */
public class TStack {
	// May create private data here.
    
    //Constant value that initializes the capacity of the stack.
    private final int CAP = 100000;

    //Field that holds the index representing the top of the stack.
    private int top;
    
    //Field that holds the array of tree nodes.
    private TreeNode[] stack;

    /**
     * No-arg constructor for IntStack.
     */
	public TStack() {
        top = -1;
        stack = new TreeNode[CAP];

	}
    
    /**
     * Method to push an item x onto the stack.
     *
     * @param x
     *      value to push onto stack.
     * @throws RuntimeException
     *          if Stack is full.
     */
	public void push(TreeNode x) {
        //Check if stack is full.
        if(top == CAP - 1)
        {
            throw new RuntimeException("Stack is full!");
        }

        top++;
        stack[top] = x;   

	}
    
    /**
     * Method to pop and return an item from the top of the stack. If the
     * stack is empty, then method will return null.
     *
     * @return value in top.
     */
	public TreeNode pop() {
        //Check if stack is empty.
        if(top == -1)
        {
            return null;
        }

        top--;
        return stack[top + 1];
	}

    /**
     * Getter method for numElements added 1 to top since top is an index.
     *
     * @return number of elements in stack.
     */
    public int getNumElements()
    {
        return top + 1;
    }
    
    /**
     * Method to look at top element and nothing more.
     *
     * @return A tree node that top points to.
     */
    public TreeNode peek()
    {
        if(top == -1)
        {
            return null;
        }
        else
        {
            return stack[top];
        }
    }
}
