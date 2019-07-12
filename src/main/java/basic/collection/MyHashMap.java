package basic.collection;

public class MyHashMap<K,V>  {
    private class Entry<K,V>{
        int hash;
        K key;
        V value;
        Entry<K,V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private static final int DEAFAULT_CAPACITY = 1 << 4;
    private int capacity;
    private int size;
    private Entry<K,V> [] table;
    public MyHashMap(){
        this(DEAFAULT_CAPACITY);
    }
    public MyHashMap(int capacity){
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    public Integer put(K key,V value){
        if (key == null){
            throw new IllegalArgumentException();
        }
        int hash = myHash(key);
        Entry<K,V> entry = new Entry<>(hash,key,value,null);
        Entry<K, V> temp = table[hash];
        while (temp != null){
            if (temp.key.equals(key)){
                temp.value = entry.value;
                return hash;
            }
            temp = temp.next;
        }
        entry.next = table[hash];
        table[hash] = entry;
        size++;
        return hash;
    }
    public Integer size(){
        return size;
    }
    public V getValue(K key){
        if (key == null){
            throw  new IllegalArgumentException();
        }
        int hash = myHash(key);
        Entry<K, V> temp = table[hash];
        while (temp != null){
            if (temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    private int myHash(K key) {
        return key.hashCode() & (capacity - 1);
    }

    public static void main(String[] args) {
        MyHashMap<Integer,String> myHashMap = new MyHashMap(15);
        myHashMap.put(1,"hello");
        myHashMap.put(2,"world");
        String value = myHashMap.getValue(1);
        System.out.println(value + "  " + myHashMap.size());
    }
}
