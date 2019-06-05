package offer;

import java.util.*;

public class topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n:nums
             ) {
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue =
                new PriorityQueue<>((a,b)->(b.getValue() - a.getValue()));

        for (Map.Entry<Integer,Integer> e: map.entrySet() ){
            priorityQueue.add(e);
        }

        List<Integer> list = new LinkedList<>();
        while (list.size() < k){
            Map.Entry<Integer,Integer> entry = priorityQueue.poll();
            list.add(entry.getKey());
        }
        return list;
    }
}
