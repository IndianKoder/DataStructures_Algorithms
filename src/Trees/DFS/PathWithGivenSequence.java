package Trees.DFS;

class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    // TODO: Write your code here
    int sequenceLength = sequence.length;
    if(root==null || sequenceLength==0)
      return false;

    return findPathHelper(root,sequence,0,sequenceLength);
  }
  public static boolean findPathHelper(TreeNode root,int[] sequence,int index,int sequenceLength)
  {
    if(root==null && index==sequenceLength)
      return true;
    else if(root==null)
      return false;
    if(index>=sequenceLength || root.val!=sequence[index])
      return false;
    return findPathHelper(root.left,sequence,index+1,sequenceLength) || findPathHelper(root.right,sequence,index+1,sequenceLength);
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}





/**
 * ======Alternate Solution================
 * class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    if (root == null)
      return sequence.length == 0;

    return findPathRecursive(root, sequence, 0);
  }

  private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int sequenceIndex) {

    if (currentNode == null)
      return false;

    if (sequenceIndex >= sequence.length || currentNode.val != sequence[sequenceIndex])
      return false;

    // if the current node is a leaf, add it is the end of the sequence, we have found a path!
    if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1)
      return true;

    // recursively call to traverse the left and right sub-tree
    // return true if any of the two recusrive call return true
    return findPathRecursive(currentNode.left, sequence, sequenceIndex + 1)
        || findPathRecursive(currentNode.right, sequence, sequenceIndex + 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}
=======================================================================



Time complexity #

The time complexity of the above algorithm is O(N)O(N)O(N), where �N� is the total number of nodes in the tree. This is due to the fact that we traverse each node once.
Space complexity #

The space complexity of the above algorithm will be O(N)O(N)O(N) in the worst case. This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child).

 */
