package concurrent.producerAndcomsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class StorageCondition {
       static private Integer count = 0;
        static private Integer size = 10;
        static ReentrantLock reentrantLock = new ReentrantLock();
        Condition empty = reentrantLock.newCondition();
        Condition full = reentrantLock.newCondition();

        class producter implements Runnable{

            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    if (count.equals(size)){
                        try {
                            full.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;

                }
            }
        }

}
