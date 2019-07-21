package offer;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class maxPathSum124 {
    public int maxPathSum(TreeNode root) {
        int [] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        int rusult = getRusult(root, result);
        System.out.println(rusult);
        return result[0];

    }



    private int getRusult(TreeNode root, int[] result) {
        if (root == null){
            return 0;
        }
        int left = Math.max(0,getRusult(root.left,result));
        int right = Math.max(0,getRusult(root.right,result));
        result[0] = Math.max(result[0],left + right + root.val);
        //这里需要注意，因为结果是需要一条路径的最大值，不能有分支
        return Math.max(left,right)+root.val;
    }
}
