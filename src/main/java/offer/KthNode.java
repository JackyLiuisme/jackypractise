package offer;

import leetcode.TreeNode;

import java.util.Stack;

public class KthNode {
    int index = 0;
    TreeNode kthNode(TreeNode pRoot,int k){
        if (pRoot != null){
            TreeNode node = kthNode(pRoot.left, k);
            if (node != null){
                return node;
            }
            index++;
            if (index == k){
                return pRoot;
            }
            node = kthNode(pRoot.right,k);
            if (node != null){
                return node;
            }
        }
        return null;
    }
    public TreeNode kthSmallest(TreeNode pRoot, int k) {

        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while (!stack.isEmpty() || pRoot !=null){
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.pop();
            index++;
            if (index == k){
                return pRoot;
            }
            pRoot = pRoot.right;

        }
        return null;
    }
    }
