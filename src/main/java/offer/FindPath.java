package offer;

import java.util.ArrayList;

/**
 *
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return lists;
        }
        target -= root.val;
        list.add(root.val);
        if (root.left == null && root.left == null && target == 0){
            lists.add(new ArrayList<>(list));
        }

        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return lists;









    }
/*        if (root == null){
            return lists;
        }
        target -= root.val;
        list.add(root.val);
        if (root.right == null && root.left == null && target == 0 ){
            lists.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return lists;
    }*/
}
