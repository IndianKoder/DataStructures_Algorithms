package Trees.DFS;

import java.util.Stack;

class PathWithRequiredSumNonRecursive {
	
	//=============================Not Solved====================================
	  public static boolean hasPath(TreeNode root, int sum) {
	    if (root == null)
	      return false;

	    // if the current node is a leaf and its value is equal to the sum, we've found a path
	    Stack<TreeNode> stack = new Stack<>();
	    stack.push(root);
	    int prevChildVal=0;
	    while(!stack.isEmpty())
	    {
	      TreeNode child = stack.pop();
	      if(sum==0 || child.val == sum)
	        return true;
	      if(child.right!=null)
	        stack.push(child.right);
	      if(child.left!=null)
	        stack.push(child.left);
	      prevChildVal=child.val;
	      sum-=child.val;

	    }
	    return false;
	  }

	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    System.out.println("Tree has path: " + PathWithRequiredSumNonRecursive.hasPath(root, 23));
	    System.out.println("Tree has path: " + PathWithRequiredSumNonRecursive.hasPath(root, 16));
	  }
	}
