/**
 * Node.java
 * 
 * @author Preston
 * @version 4/20/18
 */
public class Node {
    private int a; 	//Represents the state of jar a. (water in a)
    private int b;  //Represents the state of jar b. (water in b)
    private Node previousState;
    private String action;

    /**
     * A argument constructor for node.
     * 
     * @param _a
     * 			int value to set for a.
     * @param _b
     * 			int value to set for b.
     */
    public Node(int _a, int _b)
    {
        a = _a;
        b = _b;
        previousState = null;
        action = "";
    }

    public Node(int _a, int _b, Node prevState)
    {
        a = _a;
        b = _b;
        previousState = prevState;
        action = "";
    }

    public Node(int _a, int _b, Node prevState, String act)
    {
        a = _a;
        b = _b;
        previousState = prevState;
        action = act;
    }

    /**
     * Getter for action.
     * 
     * @return action
     */
    public String getAction()
    {
        return action;
    }

    /**
     * Setter for action.
     * 
     * @param newAct
     */
    public void getAction(String newAct)
    {
        action = newAct;
    }


    /**
     * Getter for previousState.
     * 
     * @return previous state.
     */
    public Node getPrevState()
    {
        return previousState;
    }

    /**
     * Setter for previousState.
     * 
     * @param new previous state.
     */
    public void setPrevState(Node prevState)
    {
        previousState = prevState;
    }


    /**
     * Getter for A.
     * 
     * @return a
     */
    public int getA()
    {
        return a;
    }

    /**
     * Setter for A.
     * 
     * @param _a
     * 			new value to set for a.
     */
    public void setA(int _a)
    {
        a = _a;
    }

    /**
     * Getter for B.
     * 
     * @return b
     */
    public int getB() 
    {
        return b;
    }

    /**
     * Setter for B.
     * 
     * @param _b
     * 			new value to set for b.
     */
    public void setB(int _b)
    {
        b = _b;
    }

}
