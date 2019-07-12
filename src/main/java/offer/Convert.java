package offer;

import java.util.Stack;

/**
 * TODO
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    TreeNode head = null;
    TreeNode pHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }

        Convert(pRootOfTree.left);
        if (head == null){
            head = pRootOfTree;
            pHead = pRootOfTree;
        }else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = head.right;
        }
        Convert(pRootOfTree.right);
        return pHead;
    }


    public TreeNode UnrecursiveConvert(TreeNode pRootOfTree) {
        TreeNode head = null;
        TreeNode pHead = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRootOfTree != null) {
            while (pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            pRootOfTree = stack.pop();
            if (head == null) {
                head = pRootOfTree;
                pHead = pRootOfTree;
            } else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = head.right;
            }

            pRootOfTree = pRootOfTree.right;

        }
        return pHead;
    }






















/*
       TreeNode head = null;
       Stack<TreeNode> stack = new Stack<>();
       while (!stack.isEmpty() || pRootOfTree != null){
           while (pRootOfTree!=null){
               stack.push(pRootOfTree);
               pRootOfTree = pRootOfTree.right;
           }
           pRootOfTree = stack.pop();
           if(head == null){
               head = pRootOfTree;
           }else {
               head.left = pRootOfTree;
               pRootOfTree.right = head;
               head = pRootOfTree;
           }
           pRootOfTree = pRootOfTree.left;
       }
       return head;*/
    }

