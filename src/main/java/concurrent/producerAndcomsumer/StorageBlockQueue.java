package concurrent.producerAndcomsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class StorageBlockQueue {
    private static Integer count = 0;
    private static LinkedBlockingQueue blockQueue = new LinkedBlockingQueue(5);

    public static void main(String[] args) {
        StorageBlockQueue storageBlockQueue = new StorageBlockQueue();
        new Thread(storageBlockQueue.new producter()).start();
        new Thread(storageBlockQueue.new producter()).start();
        new Thread(storageBlockQueue.new producter()).start();
        new Thread(storageBlockQueue.new comsumer()).start();
        new Thread(storageBlockQueue.new comsumer()).start();
    }
    class producter implements Runnable{

        @Override
        public void run() {
            for (int i= 0; i < 10; i++){
                try {
                    blockQueue.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"生产者生产："+blockQueue.size());
            }
        }
    }
    class comsumer implements Runnable{

        @Override
        public void run() {
            for (int i= 0; i < 10; i++){
                try {
                    blockQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"消费者消费："+blockQueue.size());
            }
        }
    }
}
