package Trees.DFS;

class SumOfPathNumbers {
  public static int findSumOfPathNumbersRecursive(TreeNode root) {
    // TODO: Write your code here
    if(root==null)
      return 0;
    int totalSum=0;
    totalSum=findSumOfPathNumbersRecursiveHelper(root,"0");
    return totalSum;
  }
  public static int findSumOfPathNumbersRecursiveHelper(TreeNode root,String sum)
  {
    
    if(root.left==null && root.right==null)
      return Integer.parseInt(sum+root.val);
    //System.out.println("sum is"+sum);
    int num1=0,num2=0;
    if(root.left!=null)
      num1=findSumOfPathNumbersRecursiveHelper(root.left,sum+root.val);
    if(root.right!=null)
      num2=findSumOfPathNumbersRecursiveHelper(root.right,sum+root.val);
    return num1+num2;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbersRecursive(root));
  }
}



/**
 *======================Alternate Solution=======================
 * class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root) {
    return findRootToLeafPathNumbers(root, 0);
  }

  private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
    if (currentNode == null)
      return 0;

    // calculate the path number of the current node
    pathSum = 10 * pathSum + currentNode.val;

    // if the current node is a leaf, return the current path sum.
    if (currentNode.left == null && currentNode.right == null) {
      return pathSum;
    }

    // traverse the left and the right sub-tree
    return findRootToLeafPathNumbers(currentNode.left, pathSum) +
           findRootToLeafPathNumbers(currentNode.right, pathSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}



Time complexity #

The time complexity of the above algorithm is O(N)O(N)O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.
Space complexity #

The space complexity of the above algorithm will be O(N)O(N)O(N) in the worst case. This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child).

 * 
 * 
 **/
