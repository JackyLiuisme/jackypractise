package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest1 {
    static CyclicBarrier barrier = new CyclicBarrier(2,new A());

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                    System.out.println("first barrier");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        barrier.await();
        System.out.println("second barrier");

    }
    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println("third free");
        }
    }
}
