package company.practise18;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public Node getLChild(){
        return left;
    }

    public Node getRChild(){
        return right;
    }
    public Integer getValue(){
        return val;
    }
}
