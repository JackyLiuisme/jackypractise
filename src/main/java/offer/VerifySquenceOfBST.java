package offer;

/**
 * 判断一个数组是不是二叉搜索树后序遍历的结果
 */
public class VerifySquenceOfBST {
    public static boolean isTure(int[] sequence, int start, int end){
        if (start >= end){
            return true;
        }
            int count = 0;
            while (sequence[count] < sequence[end]){
                count++;
            }
            int temp = count;

            for (int i = count; i < end; i++){
                if (sequence[i] < sequence[end]){
                    return false;
                }
            }
            return isTure(sequence,start,count-1) && isTure(sequence,count,end-1);
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
            if (sequence.length == 0 || sequence.length == 1){
                return true;
            }
            return isTure(sequence,0,sequence.length-1);


  /*      if (sequence.length == 0 || sequence.length == 1){
            return true;
        }

        int index = sequence[sequence.length-1],count=0,i=0;
        while (i < sequence.length && sequence[i] < index){
            i++;
        }
        count = i;
            while (i < sequence.length){
                if (sequence[i] < index){
                    return false;
                }
                i++;
            }
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,count))
                    ||  VerifySquenceOfBST(Arrays.copyOfRange(sequence,count,sequence.length-1));*/

    }

    public static void main(String[] args) {
        int [] array = {5,4,3,2,1};
        boolean b = VerifySquenceOfBST(array);
        System.out.println(b);
    }
}
