package Trees.DFS;

class CountAllPathSum {
  public static int countPaths(TreeNode root, int S) {
    // TODO: Write your code here

    int noOfPaths=0;
    noOfPaths=countPathsRecursive(root,S);
    return noOfPaths;
  }
  public static int countPathsRecursive(TreeNode root,int S)
  {
    if(root==null || S<=0)
      return 0;
    if(root.val==S)
      return 1;
    return countPathsRecursive(root.left,S-root.val)+countPathsRecursive(root.left,S)+countPathsRecursive(root.right,S-root.val)+countPathsRecursive(root.right,S);
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
  }
}


/**
*import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class CountAllPathSum {
  public static int countPaths(TreeNode root, int S) {
    List<Integer> currentPath = new LinkedList<>();
    return countPathsRecursive(root, S, currentPath);
  }

  private static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {
    if (currentNode == null)
      return 0;

    // add the current node to the path
    currentPath.add(currentNode.val);
    int pathCount = 0, pathSum = 0;
    // find the sums of all sub-paths in the current path list
    ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
    while (pathIterator.hasPrevious()) {
      pathSum += pathIterator.previous();
      // if the sum of any sub-path is equal to 'S' we increment our path count.
      if (pathSum == S) {
        pathCount++;
      }
    }

    // traverse the left sub-tree
    pathCount += countPathsRecursive(currentNode.left, S, currentPath);
    // traverse the right sub-tree
    pathCount += countPathsRecursive(currentNode.right, S, currentPath);

    // remove the current node from the path to backtrack, 
    // we need to remove the current node while we are going up the recursive call stack.
    currentPath.remove(currentPath.size() - 1);

    return pathCount;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
  }
}



Time complexity #

The time complexity of the above algorithm is O(N2)O(N^2)O(N​2​​) in the worst case, where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once, but for every node, we iterate the current path. The current path, in the worst case, can be O(N)O(N)O(N) (in the case of a skewed tree). But, if the tree is balanced, then the current path will be equal to the height of the tree, i.e., O(logN)O(logN)O(logN). So the best case of our algorithm will be O(NlogN)O(NlogN)O(NlogN).
Space complexity #

The space complexity of the above algorithm will be O(N)O(N)O(N). This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child). We also need O(N)O(N)O(N) space for storing the currentPath in the worst case.

Overall space complexity of our algorithm is O(N)O(N)O(N).

*=======Alternate Solution===============================\
*
**/