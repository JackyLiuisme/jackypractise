package leetcode;

import offer.ListNode;

/**
 * 求两条链表内的数字相加的和，并用链表表示
 * 2->4->3  +  5->6->4
 * 等于 7->0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int count=0,temp = 0;
        ListNode head = new ListNode(0);
        ListNode pHead = head;
        while (l1 != null || l2 != null){
            count = count /10;
            if (l1 != null){
                count += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                count += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(count%10);
            head = head.next;
        }
        if (count / 10 == 1){
            head.next = new ListNode(count%10);
        }
        return head.next;



    }
}
