package offer;

import leetcode.TreeNode;

import java.util.Stack;

public class KthNode {
    int index = 0;
    TreeNode kthNode(TreeNode root,int k){
        if (root != null){
            TreeNode node = kthNode(root.left, k);
            if (node != null){
                return node;
            }
            index++;
            if (index == k){
                return root;
            }
            node = kthNode(root.right,k);
            if (node != null){
                return node;
            }
        }
        return null;
    }
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while (!stack.isEmpty() || root !=null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            index++;
            if (index == k){
                return root.val;
            }
            root = root.right;

        }
        return 0;
    }
    }
