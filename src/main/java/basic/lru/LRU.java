package basic.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU <K,V>{
    private final int SIZE;
    private final float LOAD_FACTORY = 0.75F;
    LinkedHashMap<K,V> hashMap;
    public LRU(int size) {
        SIZE = size;

    //    int capacity = (int) (Math.ceil(SIZE / LOAD_FACTORY) + 1);

        hashMap = new LinkedHashMap<K,V>(SIZE,LOAD_FACTORY,true){
           @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> entry){
               return size() > SIZE;
           }
        };
    }

    public synchronized void put(K key,V value){
        hashMap.put(key,value);
    }

    public synchronized V get(K key){
        return hashMap.get(key);

    }

    public synchronized void remove(K key){
        hashMap.remove(key);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<K, V> entry : hashMap.entrySet()) {
            stringBuilder.append(String.format("%s: %s  ", entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRU<Integer,Integer> lru = new LRU<>(5);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        System.out.println(lru);
        lru.get(1);
        System.out.println(lru);
        lru.put(5,5);
        lru.put(6,6);
        lru.put(7,7);
        System.out.println(lru);
    }
}
