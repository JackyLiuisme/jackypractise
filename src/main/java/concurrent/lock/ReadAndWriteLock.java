package concurrent.lock;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLock {
    static HashMap<String,Object> hashMap = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock r = lock.readLock();
    static Lock w = lock.writeLock();
    public <T> T get(String key){
            r.lock();
        T value = (T) hashMap.get(key);
            r.unlock();
            return value;
    }

    public void put(String key,Object value){
        w.lock();
        hashMap.put(key,value);
        w.unlock();
    }

    public static void main(String[] args) {
        ReadAndWriteLock lock = new ReadAndWriteLock();
        final   int count =1 ;
        for (int i = 0; i < 5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    lock.put("shit",count);
                }
            }).start();

        }
    }
}
