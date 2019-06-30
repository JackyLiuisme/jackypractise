package offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            if (pRoot == null){
                return lists;
            }
        LinkedList<TreeNode> queue = new LinkedList<>();
         queue.offer(pRoot);
         ArrayList<Integer> list = new ArrayList<>();
         while (!queue.isEmpty()){

            int size = queue.size();
             for (int i= 0; i < size; i++){
                 TreeNode temp = queue.poll();
                 list.add(temp.val);
                 if (temp.left != null){
                     queue.offer(temp.left);
                 }
                 if (temp.right != null){
                     queue.offer(temp.right);
                 }
             }
             lists.add(new ArrayList<>(list));
             list.clear();
         }
         return lists;
    }
}
