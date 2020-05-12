package Trees.BFS;
import java.util.*;



class LevelOrderSuccessor {
  public static TreeNode findSuccessor(TreeNode root, int key) {
    // TODO: Write your code here
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty())
    {
      TreeNode child = queue.poll();

      if(child.left!=null)
        queue.offer(child.left);
      if(child.right!=null)
        queue.offer(child.right);
      if(child.val==key)
      {
        TreeNode successor=queue.poll();
        
        return successor;
      }
    }
    return null;    
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
    if (result != null)
      System.out.println(result.val + " ");
    result = LevelOrderSuccessor.findSuccessor(root, 9);
    if (result != null)
      System.out.println(result.val + " ");
  }
}
