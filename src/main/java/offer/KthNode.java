package offer;

import leetcode.TreeNode;

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
}
