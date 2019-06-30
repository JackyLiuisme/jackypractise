package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class getMidNumber {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 0){
            if (!maxHeap.isEmpty() &&num < maxHeap.peek() ){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }else {
            if (!minHeap.isEmpty() &&num > minHeap.peek() ){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }
    public Double GetMedian() {
        if (count == 0){
            throw new RuntimeException("count can not be 0");
        }
        if ((count & 1) == 0){
            return Double.valueOf(maxHeap.peek());
        }else {
            return Double.valueOf((minHeap.peek() + maxHeap.peek()) / 2);
        }
    }

}
