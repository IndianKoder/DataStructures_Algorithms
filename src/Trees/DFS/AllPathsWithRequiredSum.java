package Trees.DFS;
import java.util.*;



class AllPathsWithRequiredSum {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    // TODO: Write your code here
    findPathsHelper(allPaths,new ArrayList<Integer>(),root,sum);
    return allPaths;
  }
  public static void findPathsHelper(List<List<Integer>> allPaths,List<Integer> path,TreeNode root, int sum)
  {
     if (root == null)
     {
	      return;
     }
      path.add(root.val);
	    // if the current node is a leaf and its value is equal to the sum, we've found a path
	    if (root.val == sum && root.left == null && root.right == null)
	      allPaths.add(new ArrayList<Integer>(path));

	    // recursively call to traverse the left and right sub-tree
	    // return true if any of the two recursive call return true
	    findPathsHelper(allPaths,path,root.left, sum - root.val);
      findPathsHelper(allPaths,path,root.right, sum - root.val);
      path.remove(path.size()-1);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = AllPathsWithRequiredSum.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}

/**
 * 
 * 
 * 
 * Time complexity #

The time complexity of the above algorithm is O(N^2), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once (which will take O(N)O(N)O(N)), and for every leaf node we might have to store its path which will take O(N)O(N)O(N).

We can calculate a tighter time complexity of O(NlogN)O(NlogN)O(NlogN) from the space complexity discussion below.
Space complexity #

If we ignore the space required for the allPaths list, the space complexity of the above algorithm will be O(N)O(N)O(N) in the worst case. This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child).

How can we estimate the space used for the allPaths array? Take the example of the following balanced tree:

Here we have seven nodes (i.e., N = 7). Since, for binary trees, there exists only one path to reach any leaf node, we can easily say that total root-to-leaf paths in a binary tree can’t be more than the number of leaves. As we know that there can’t be more than N/2N/2N/2 leaves in a binary tree, therefore the maximum number of elements in allPaths will be O(N/2)=O(N)O(N/2) = O(N)O(N/2)=O(N). Now, each of these paths can have many nodes in them. For a balanced binary tree (like above), each leaf node will be at maximum depth. As we know that the depth (or height) of a balanced binary tree is O(logN)O(logN)O(logN) we can say that, at the most, each path can have logNlogNlogN nodes in it. This means that the total size of the allPaths list will be O(N∗logN)O(N*logN)O(N∗logN). If the tree is not balanced, we will still have the same worst-case space complexity.

From the above discussion, we can conclude that the overall space complexity of our algorithm is O(N∗logN)O(N*logN)O(N∗logN).

Also from the above discussion, since for each leaf node, in the worst case, we have to copy log(N)log(N)log(N) nodes to store its path, therefore the time complexity of our algorithm will also be O(N∗logN)O(N*logN)O(N∗logN).
Similar Problems #

Problem 1: Given a binary tree, return all root-to-leaf paths.

Solution: We can follow a similar approach. We just need to remove the “check for the path sum”.

Problem 2: Given a binary tree, find the root-to-leaf path with the maximum sum.

Solution: We need to find the path with the maximum sum. As we traverse all paths, we can keep track of the path with the maximum sum.

**/
