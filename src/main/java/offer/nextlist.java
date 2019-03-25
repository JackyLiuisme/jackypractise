package offer;

public class nextlist {
    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode root = head;
        while (list1!=null && list2!=null){
            if (list1.val > list2.val){
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            }else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }
        if (list1!=null)
            head.next = list1;
        if (list2!=null)
            head.next = list2;

        return root.next;
    }

    public static void main(String[] args) {
        int n = 1;
        String str = "find";
        System.out.println(str);
        for (int i = 0; i < 10; i++){
            n++;
            System.out.println(n);
        }

        System.out.println(str);
    }
}
