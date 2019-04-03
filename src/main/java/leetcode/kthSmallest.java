package leetcode;

import java.util.Stack;

public class kthSmallest {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        head.left.right = new TreeNode(2);
        int n = kthSmallest(head, 1);
        System.out.println(n);
    }
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                k--;
                if (0 == k) {

                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
}
