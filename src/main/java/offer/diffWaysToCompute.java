package offer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class diffWaysToCompute {
    public static void main(String[] args) {
        String str = "2*3-4*5";
        List<Integer> list = diffWaysToCompute(str);
        for (int n:list
             ) {
            System.out.println(n);
        }
    }
    public static List<Integer> diffWaysToCompute(String inpus) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < inpus.length(); i++) {
            if (inpus.charAt(i) == '+' || inpus.charAt(i) == '*' || inpus.charAt(i) == '-') {
                List<Integer> left = diffWaysToCompute(inpus.substring(0, i));
                List<Integer> right = diffWaysToCompute(inpus.substring(i + 1));
                for (Integer l : left
                ) {
                    for (Integer r : right) {
                        switch (inpus.charAt(i)) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(inpus));
        }
        return result;

    }
}
