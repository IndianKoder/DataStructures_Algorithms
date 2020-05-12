package Trees.BFS;
import java.util.*;

class ModifiedTreeNode {
  int val;
  ModifiedTreeNode left;
  ModifiedTreeNode right;
  ModifiedTreeNode next;

  ModifiedTreeNode(int x) {
    val = x;
    left = right = next = null;
  }

  // level order traversal using 'next' pointer
  void printLevelOrder() {
    ModifiedTreeNode nextLevelRoot = this;
    while (nextLevelRoot != null) {
      ModifiedTreeNode current = nextLevelRoot;
      nextLevelRoot = null;
      while (current != null) {
        System.out.print(current.val + " ");
        if (nextLevelRoot == null) {
          if (current.left != null)
            nextLevelRoot = current.left;
          else if (current.right != null)
            nextLevelRoot = current.right;
        }
        current = current.next;
      }
      System.out.println();
    }
  }
};

class ConnectLevelOrderSiblings {
  public static void connect(ModifiedTreeNode root) {
    // TODO: Write your code here
    Queue<ModifiedTreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty())
    {
      int noOfNodes = queue.size();
      ModifiedTreeNode linker = queue.peek();
      while(noOfNodes>0)
      {

        ModifiedTreeNode child = queue.poll();
        if(child.left!=null)
          queue.offer(child.left);
        if(child.right!=null)
          queue.offer(child.right);

         if(child!=linker)
         {
           linker.next=child;
           linker=child;
         }

        noOfNodes--;
      }
    }
  }

  public static void main(String[] args) {
    ModifiedTreeNode root = new ModifiedTreeNode(12);
    root.left = new ModifiedTreeNode(7);
    root.right = new ModifiedTreeNode(1);
    root.left.left = new ModifiedTreeNode(9);
    root.right.left = new ModifiedTreeNode(10);
    root.right.right = new ModifiedTreeNode(5);
    ConnectLevelOrderSiblings.connect(root);
    System.out.println("Level order traversal using 'next' pointer: ");
    root.printLevelOrder();
  }
}
