package offer;

import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args) {
        int [] pushA = {1,2,3,4,5};
        int [] pushB = {4,5,3,2,1};
        boolean flag = IsPopOrder(pushA, pushB);
        System.out.println(flag);
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && popA[count] == stack.peek()){
                stack.pop();
                count++;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
