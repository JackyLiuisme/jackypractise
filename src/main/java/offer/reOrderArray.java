package offer;

import java.util.Stack;

public class reOrderArray {
    public void reOrderArray(int [] array) {
        Stack<Integer> stack = new Stack<Integer>();
        int [] temp = new int[array.length];
        int count =0;
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                stack.push(array[i]);
            }else {
                temp[count++] = array[i];
            }
        }
        int n = array.length - 1;
        while (!stack.isEmpty()){
            temp[n--] = stack.pop();
        }
        for (int i = 0; i < array.length; i++){
            array[i] = temp[i];
        }
    }
}
