class SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode itr=head;
        int count=1;
        while(count++<k){
          itr=itr.next;      
        }
        ListNode first=itr;
        ListNode second=head;

        while(itr.next!=null){
          itr=itr.next;      
          second=second.next;
        }

        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        
        return head;
    }
}