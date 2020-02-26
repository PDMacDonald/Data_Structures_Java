
public class AugmentTree {
	private static TreeNode root;

	private static void augment(TreeNode x) {
		// TODO: Code to augment each node of the tree with its subtree sizes.
        TStack stack = new TStack();
        int subTSize = 0;
        TreeNode c = root;
        stack.push(c);

        while(stack.getNumElements() != 0)
        {
            if(c.left == null && c.right == null)//if no children
            {
                c.size = 1;
                c = stack.pop();
                c = stack.peek();
            }
            else if(c.right == null) //if no right child.
            {
                c.size = c.left.size + 1;
                stack.pop();
                c = stack.peek();
            }
            else if(c.left == null)
            {
                if(c.right.size != 0)
                {
                    c.size = c.right.size + 1;
                    stack.pop();
                    c = stack.peek();
                }
                else 
                {
                    c = c.right;
                    stack.push(c);
                    while(c.left != null)
                    {
                        c = c.left;
                        stack.push(c);
                    }
                }
            }
            else if(c.left.size != 0 && c.right.size != 0)
            {
                c.size = c.left.size + c.right.size + 1;
                stack.pop();
                c = stack.peek();
            }
            else
            {
                if(c.left != null)//if left child exists.
                {
                    if(c.left.size != 0) // if left child has been calculate.
                    {
                        c = c.right;
                        stack.push(c);
                    }
                }
                else if(c.right != null)// if there is a right child.
                {
                    c = c.right;
                    stack.push(c);
                }
                while(c.left != null) //always move as far left as possible.
                {
                    c = c.left;
                    stack.push(c);   
                }    
            }

        }

	}

	public static void main(String [] args) {
		MyTree T = new MyTree();
		root = T.getRoot();
		
		augment(root);
		System.out.println(root.size);
		System.out.println(root.left.size);
		System.out.println(root.right.size);
	}
}
