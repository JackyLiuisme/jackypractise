package concurrent.producerAndcomsumer;

import java.util.concurrent.atomic.AtomicInteger;

public class StorageWN {
        private static AtomicInteger count = new AtomicInteger(0);
        private static Integer size = 5;
        private static Object lock = new Object();

    public static void main(String[] args) {
        StorageWN storageWN = new StorageWN();
        new Thread(storageWN.new producer()).start();
        new Thread(storageWN.new producer()).start();
        new Thread(storageWN.new comsumer()).start();
    }
       class producer2 implements Runnable{

           @Override
           public void run() {
                synchronized (lock){
                    if (count.equals(size)){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count.addAndGet(1);
                    lock.notifyAll();
                }
           }
       }


        class producer implements Runnable{

            @Override
            public void run() {
                for (int i = 0;i <= 10; i++ ) {
                    synchronized (lock) {
                        if (count.equals(size)) {
                            System.out.println("仓库已满，【"+count+"】： 暂时不能执行生产任务!");

                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.getMessage();
                            }
                        }
                        count.addAndGet(1);
                        System.out.println(Thread.currentThread().getName()+"生产者生产了一个产品，当前库存为" + count);
                        lock.notifyAll();
                    }
                }

            }
        }
        class comsumer implements Runnable{

            @Override
            public void run() {
                for (int i = 0; i <= 10; i++){
                    synchronized (lock){
                        if (count.equals(0)){
                            try {
                                System.out.println("仓库已空，【"+count+"】： 暂时不能执行消费任务!");

                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        count.addAndGet(-1);
                        System.out.println(Thread.currentThread().getName()+"消费者消费了一个产品，当前库存为： "+count);
                        lock.notifyAll();
                    }
                }
            }
        }
}
