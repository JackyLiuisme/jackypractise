package leetcode;

public class connect116 {


    public Node connect(Node root){

        Node head = root;
        while (head != null){
            Node temp = head;

            while (temp != null){
                if (temp.left != null){
                    temp.left.next = temp.right;
                }
                if (temp.right != null && temp.next != null){
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            head = head.left;
        }

        return root;
    }
}
