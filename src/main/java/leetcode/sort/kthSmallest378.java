package leetcode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallest378 {
    public static void main(String[] args) {
        int [][] nums = {
        {1,  5,  9},
        {10, 11, 13},
        {12, 13, 15}
    };
        kthSmallest378 kthSmallest378 = new kthSmallest378();
        int i = kthSmallest378.kthSmallest1(nums, 8);
        System.out.println(i);
    }

    public  int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                if (queue.size() < k) {
                    queue.add(matrix[i][j]);
                }else {
                    if (matrix[i][j] < queue.peek()){
                        queue.poll();
                        queue.offer(matrix[i][j]);
                    }
                }
            }
        }
        return queue.poll();
    }
        public  int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(k){};
        for(int j = 0; j <= n-1; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) {
                continue;
            }
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }


class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}

    public int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
