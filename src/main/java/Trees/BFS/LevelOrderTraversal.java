package Trees.BFS;

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    // TODO: Write your code here
    List<Integer> levelByLevelNums = new ArrayList<>();
    Queue<TreeNode> levelTracker = new LinkedList<>();

    levelTracker.offer(root);
    while(!levelTracker.isEmpty())
    {
      int levelNodesCount = levelTracker.size();
      while(levelNodesCount>0)
      {
        TreeNode child=levelTracker.poll();
        //System.out.println("Chile is --"+child.val);
        if(child!=null){
        levelTracker.add(child.left);
        levelTracker.add(child.right);
        levelByLevelNums.add(child.val);
        }
        levelNodesCount--;
        
      }
      if(levelByLevelNums.size()>0)
      result.add(levelByLevelNums);
      levelByLevelNums= new ArrayList<>();
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
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}
