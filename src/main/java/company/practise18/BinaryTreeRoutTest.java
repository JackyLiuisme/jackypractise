package company.practise18;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRoutTest {
    public static void main(String[] args) {
        Node node7 = new Node(7, null, null);
        Node node9 = new Node(9, null, null);
        Node node8 = new Node(8, null, node9);
        Node node4 = new Node(4, node7, node8);
        Node node10 = new Node(10, null, null);
        Node node11 = new Node(11, null, null);
        Node node5 = new Node(5, node10, node11);
        Node node2 = new Node(2, node4, node5);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node6);
        Node node1 = new Node(1, node2, node3);
        findPath(node1);
        for (List<Node> item : mRoutes) {
            System.out.println("........." + getNodePath(item));
        }

    }

    private static List<Node> mTempRoute = new ArrayList<>();
    private static List<List<Node>> mRoutes = new ArrayList<>();

    public static void findPath(Node node) {
        mTempRoute.add(node);//将当前节点加入路径mTempRoute
        if (node.getLChild() == null && node.getRChild() == null) {
            List<Node> list = new ArrayList<>();
            list.addAll(mTempRoute);//将当前路径保存下来
            mRoutes.add(list);//将一条完整的路径存入路径集合mRoutes
            mTempRoute.remove(node);//将当前叶子节点从当前路径里删除
        }

        if (node.getLChild() != null) {
            findPath(node.getLChild());
        }

        if (node.getRChild() != null) {
            if (node.getLChild() != null) {//遍历到右子树的时候，需要更新当前的路径
                int index = mTempRoute.indexOf(node);//找到当前右子树的父节点在当前路径中的索引
                mTempRoute = mTempRoute.subList(0, index + 1);
            }
            findPath(node.getRChild());
        }
    }

    public static String getNodePath(List<Node> list) {
        StringBuilder sb = new StringBuilder();
        for (Node node : list) {
            sb.append(node.getValue()).append(",");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.toString().length() - 1);
        }
        return sb.toString();
    }
}