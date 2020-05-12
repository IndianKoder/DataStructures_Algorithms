package ArraysNLinkedLists;

import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseSubList {

  public static ListNode reverse(ListNode head, int p, int q) {
    // TODO: Write your code here
    if(head==null || head.next==null || q-p==0)
      return head;

    ListNode prev=null,curr=head;
    int pos=1;
    
    while(curr!=null)
    {
      if(pos==p)
      {
          ListNode reversedHead=reverseSubList(curr,q-p);
          prev.next=reversedHead;
          break;
          
      }
      else
      {
        pos++;
        prev=curr;
        curr=curr.next;
      }
    }
    return head;
  }

  public static ListNode reverseSubList(ListNode head,int toBeReveresed)
  {
    ListNode curr=head,prev=null,next=null;
    while(curr!=null && toBeReveresed>=0)
    {
      next=curr.next;
      curr.next=prev;
      prev=curr;
      curr=next;
      toBeReveresed--;
    }
    head.next=next;
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ListNode result = ReverseSubList.reverse(head, 2, 4);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
