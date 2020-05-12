package ArraysNLinkedLists;

class ReverseEveryKElements {

   public static ListNode reverse(ListNode head, int k) {
    // TODO: Write your code here

    if(head==null || head.next==null || k==0)
      return head;

    ListNode prev=null,curr=head;
    for(int p=0,q=k;curr!=null;p=p+k,q=p+k){
     
          ListNode reversedHead=reverseSubList(curr,q-p);
          if(prev!=null)
            prev.next=reversedHead;
          else  
            head=reversedHead;
      
        prev=curr;
        curr=curr.next;
      
    }
    
    return head;
  }

  public static ListNode reverseSubList(ListNode curr,int toBeReveresed)
  {
    ListNode prev=null,next=null,head=curr;
    while(curr!=null && toBeReveresed>0)
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
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
