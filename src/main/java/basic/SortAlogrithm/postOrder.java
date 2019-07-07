package basic.SortAlogrithm;

import offer.TreeNode;

import java.util.Stack;

public class postOrder {
    public static void main(String[] args) {

    }
    public void postOrder(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null){
                stack1.push(temp.left);
            }
            if (temp.right != null){
                stack2.push(temp.right);
            }

        }
        while (stack2.isEmpty()){
            TreeNode pop = stack2.pop();

            System.out.println(pop.val);
        }
    }
}
