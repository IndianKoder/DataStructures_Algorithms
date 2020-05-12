package ArraysNLinkedLists;

import ArraysNLinkedLists.ListNode;

class RotateList {

  public static ListNode rotate(ListNode head, int rotations) {
    // TODO: Write your code here
    ListNode curr=head,prev=null;
    ListNode rotatingNode=null;
    if(curr==null||curr.next==null)
      return curr;
    int noOfNodes=0;
    while(curr!=null)
    {
      noOfNodes++;
      curr=curr.next;
    }
    rotations%=noOfNodes;
    curr=head;
    for(int node=1;curr.next!=null;node++)
    {
        if(node==rotations)
        {
          rotatingNode=curr;
         // head=curr.next;
        }
        curr=curr.next;
    }
    curr.next=head;
    head=rotatingNode.next;
    rotatingNode.next=null;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    //head.next.next.next.next.next = new ListNode(6);

    ListNode result = RotateList.rotate(head, 2);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
