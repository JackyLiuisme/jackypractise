package offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * 中序遍历
 */
public class inorderTraversal {
    List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty() || root !=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
             root = stack.pop();
            list.add(root.val);


                root = root.right;
        }
        return list;
    }

    }
