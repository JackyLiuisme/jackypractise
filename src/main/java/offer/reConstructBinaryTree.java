package offer;

import java.util.Arrays;

public class reConstructBinaryTree {
    public static void main(String[] args) {
        int [] pre = {1,2,3,4,5,6,7}, in = {3,2,4,1,6,5,7};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode.val);
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int count = 0;
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        for (int i = 0; i < in.length; i++){
            if (pre[0] == in[i]){
                count = i;
                break;
            }
        }
        TreeNode head = new TreeNode(pre[0]);
       head.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,count+1),
                Arrays.copyOfRange(in,0,count));
        head.right = reConstructBinaryTree(Arrays.copyOfRange(pre,count+1,pre.length),
                Arrays.copyOfRange(in,count+1,in.length));
        return head;
    }
}
