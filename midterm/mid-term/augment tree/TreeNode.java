
public class TreeNode {
	public int key;
	public int size;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int _key, TreeNode l, TreeNode r) {
		key = _key;
		left = l;
		right = r;
		size = 0;
	}

}
