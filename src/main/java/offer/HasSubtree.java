package offer;

/**
 *输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 * 对root的判断一定是先判断是否为空，避免空指针异常的发生
 */
public class HasSubtree {
    public static void main(String[] args) {

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val == root2.val){
            result = isRight(root1,root2);
        }
        if (!result){
            result =  HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }

        return result;
    }

    public boolean isRight(TreeNode root1,TreeNode root2){
        if (root1 == null &&  root2 != null){
            return false;
        }
        if (root2 == null){
            return true;
        }
        if (root1.val != root2.val){
            return false;
        }
        return isRight(root1.left,root2.left) && isRight(root1.right,root2.right);

    }

}
