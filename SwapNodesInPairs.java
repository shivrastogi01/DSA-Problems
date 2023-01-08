class SwapNodesInPairs{
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode d = new ListNode(0), a;
        d.next = head;
        a=d;
        while(head!=null&&head.next!=null) {
            a.next = head.next;
            head.next = head.next.next;
            a.next.next = head;
            a = a.next.next;
            head =  head.next;
        }
        return d.next;
    }
}