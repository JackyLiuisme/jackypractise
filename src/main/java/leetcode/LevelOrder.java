package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的z字型遍历层序遍历，重点在于如何记住层数,
 *
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        List<List<Integer>> lists = zigzagLevelOrder(head);
        for (List<Integer> l:lists
             ) {
            for (Integer n:l
                 ) {
                System.out.println(n);
            }
        }
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++){
                TreeNode temp = queue.pop();

                if (flag) {
                    list.add(0,temp.val);
                }else {
                    list.offer(temp.val);
                }
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
            }
            flag = !flag;
            lists.add(list);
        }
        return lists;
    }
}
