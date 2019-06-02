package concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue {
    private  ReentrantLock lock = new ReentrantLock();
    Condition empty = lock.newCondition();
    Condition full = lock.newCondition();
    Object[] array;
    int length,count,removCount,addCount;
    BlockQueue(int length){
        this.length = length;
        array = new Object[length];
    }
    public <T>T put(Object item) throws InterruptedException {
        lock.lock();
        try {


            while (count == length) {
                full.await();
            }
            if (++addCount == array.length){
                addCount = 0;
            }
            array[addCount] = item;
            ++count;
            empty.signal();
            return (T) item;
        }finally{
            lock.unlock();
        }
    }

    public <T> T get() throws InterruptedException {
        lock.lock();
        try{
            while (count == 0){
                empty.await();
            }
            Object item =array[removCount];

            if (++removCount == array.length){
                removCount = 0;
            }
            --count;
            full.signal();
            return (T) item;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockQueue blockQueue = new BlockQueue(5);
        for (int i = 0; i < 7; i++){
            new Thread(()-> {
                try {
                    blockQueue.put("thing");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i< 5; i++){
            new Thread(()-> {
                try {
                    Object o = blockQueue.get();
                    System.out.println(o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
