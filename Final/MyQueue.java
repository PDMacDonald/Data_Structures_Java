/**
  This class implements a circular array.
  It expands if the queue becomes full.
 **/
public class MyQueue {
    private Node [] queue;		// Array that stores the queue elements.
    private int front;				// Index pointing to the front of the queue.
    private int end;					// Index pointing to the element that is one less
    // than the end of the queue.
    private int numElements;	// The number of elements currently stored in the queue.
    private int size;					// The capacity of the allocated array. If the
    // number of elements reaches this
    // capacity, we need to expand.

    /**
Constructor: Allocates a queue with inital size of 1000.
     **/
    public MyQueue() {

        numElements = 0;
        size = 1000;
        front = 0;
        end = 0;
        queue = new Node[size];
    }

    /**
      This function enqueues a new element p into the queue. 
      This also expands the array if it is full.
     **/
    public void enqueue(Node p) {
        if (numElements == size) {
            // TODO: Expand the array, by first creating another one with twice the size
            // and copying the contents of the old array.
            Node [] oldQueue = queue;
            int tempNumE = numElements;
            int tempFront = front;

            size = size << 1;
            numElements = 0;
            front = 0;
            end = 0;
            queue = new Node[size];
            copyArray(oldQueue, tempFront, tempNumE);

        }
        // TODO: Code for normal enqueue.
        if(numElements == 0)
        {
            queue[end] = new Node(p);
            numElements++;
        }
        else
        {
            queue[end] = new Node(p);
            numElements++;
        }


        end = (end + 1) % size;
    }

    /**
      This function removes and returns the end front element in the queue.
     **/
    public Node dequeue() {
        if (numElements == 0) {
            return null;
        }
        // TODO: Code to remove and return the front element.

        Node node = queue[front];
        front = (front + 1) % size;
        numElements--;
        return node;

    }

    /**
      This function returns true if the queue is empty, otherwise returns false.
     **/
    public boolean isEmpty() {
        if (numElements == 0) 
            return true;
        return false;
    }

    /**
      This function prints the contents of the queue.
     **/
    public void print() {
        int cursor = front;
        // TODO: print the contents of the queue from front to end.
        for(int i = 0; i < numElements; i++)
        {
            queue[cursor].print();
        }
        System.out.print("\n");
    }

    /**
      This function copies the contents of the array passed in, into the queue.
      This is usually called when expanding the array size.
     **/
    private void copyArray(Node [] array, int front, int numE) {
        // TODO: Code to copy the array into queue. Make sure that the queue parameters
        //  -- front, end and numElements and size are all set correctly.

        int cursor = front;

        for (int i = 0; i < numE; i++)
        {
            enqueue(array[cursor]);
            cursor = (cursor + 1) % size;
        }
    }
}
