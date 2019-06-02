package offer;

public class deletDuplicate {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode temp = head;
        ListNode pre = head.next;
        while (pre.next != null){
            if (pre.val == pre.next.val){
                while (pre.val == pre.next.val){
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre = pre.next;
            }else {
                pre = pre.next;
                temp = temp.next;
            }
        }
        return head.next;
    }
}
