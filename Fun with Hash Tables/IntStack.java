/**
 * IntStack.java
 *
 * @author Preston MacDonald
 * @version 02-05-18
 */

/**
 * A stack of ints implemented using an array limited to a given CAP.
 *
 * @author Preston MacDonald
 * @version 02-05-18
 */
public class IntStack {
	// May create private data here.
    
    //Constant value that initializes the capacity of the stack.
    private final int CAP = 100;

    //Field that holds the index representing the top of the stack.
    private int top;
    
    //Field that holds the array of ints.
    private int[] stack;

    /**
     * No-arg constructor for IntStack.
     */
	public IntStack() {
        top = -1;
        stack = new int[CAP];

	}
    
    /**
     * Method to push an item x onto the stack. The stack will never contain
     * more than 100 elements.
     *
     * @param x
     *      int value to push onto stack.
     * @throws RuntimeException
     *          if Stack is full.
     */
	public void push(int x) {
        //Check if stack is full.
        if(top == 99)
        {
            throw new RuntimeException("Stack is full!");
        }

        top++;
        stack[top] = x;   

	}
    
    /**
     * Method to pop and return an item from the top of the stack. If the
     * stack is empty, then method will return -1.
     *
     * @return value in top.
     */
	public int pop() {
        //Check if stack is empty.
        if(top == -1)
        {
            return -1;
        }

        top--;
        return stack[top + 1];
	}
}
