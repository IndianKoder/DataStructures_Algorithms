package Trees.BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    // TODO: Write your code here
    Queue<TreeNode> levelQueue = new LinkedList<>();
    levelQueue.offer(root);
    boolean toggle=false;
    while(!levelQueue.isEmpty())
    {
      List<Integer> currentLevel = new ArrayList<>();
      int nodesInLevel=levelQueue.size();
      while(nodesInLevel>0)
      {
          TreeNode child=levelQueue.poll();
            if(child.left!=null)
            levelQueue.offer(child.left);
            if(child.right!=null)
            levelQueue.offer(child.right);
            if(!toggle)
            {
              currentLevel.add(child.val);
            }
            else
              currentLevel.add(0,child.val);
          
          nodesInLevel--;
      }
      result.add(currentLevel);
      toggle=!toggle;
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverse(root);
    System.out.println("Zigzag traversal: " + result);
  }
}
