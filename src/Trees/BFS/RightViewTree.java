package Trees.BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class RightViewTree {
  public static List<TreeNode> traverse(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    // TODO: Write your code here
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
   // result.add(queue.peek());
    while(!queue.isEmpty())
    {
      int levelSize = queue.size();
      
      while(levelSize>0)
      {
          TreeNode child = queue.poll();
          if(child.left!=null)
            queue.offer(child.left);
          if(child.right!=null)
            queue.offer(child.right);
          if(levelSize==1)
            result.add(child);
          levelSize--;
      }
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
    root.left.left.left = new TreeNode(3);
    List<TreeNode> result = RightViewTree.traverse(root);
    for (TreeNode node : result) {
      System.out.print(node.val + " ");
    }
  }
}

