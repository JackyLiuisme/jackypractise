package offer;

public class HasSubtree {
    public static void main(String[] args) {

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val){
            result = isRight(root1,root2);
        }
        if (!result) {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean isRight(TreeNode root1,TreeNode root2){
        if (root1 == null && root2 != null){
            return false;
        }
        if ( root2 == null){
            return true;
        }
        if (root1.val != root2.val){
            return false;
        }
        return isRight(root1.left,root2.left) && isRight(root1.right,root2.right);
    }
}
