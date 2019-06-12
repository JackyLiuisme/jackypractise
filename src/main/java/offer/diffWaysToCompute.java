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
    public static List<Integer> diffWaysToCompute(String inpus){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inpus.length(); i++){
            char c = inpus.charAt(i);
            if ((c =='+')|| (c=='-')|| (c== '*') ){
                List<Integer> left = diffWaysToCompute(inpus.substring(0, i));
                List<Integer> right = diffWaysToCompute(inpus.substring(i+1));
                for (int l :left
                        ) {
                    for (int r: right
                         ) {
                        switch (c){
                            case '+': result.add(l+r);
                            break;
                            case '-': result.add(l-r);
                                break;
                            case '*': result.add(l*r);
                                break;
                        }
                    }
                }

            }
        }
        if (result.size() == 0){
            result.add(Integer.valueOf(inpus));
        }
        return result;
    }
}
