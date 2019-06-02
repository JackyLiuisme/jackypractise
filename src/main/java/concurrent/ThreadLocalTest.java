package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest {
        public final static ThreadLocal<Long> threadLocal = new ThreadLocal();

        public  static Long getStartTime(){
            long start = System.currentTimeMillis();
            threadLocal.set(start);
            System.out.println("startTime: " + start);
            return start;
        }

        public final static Long getEndTime(){
            long end = System.currentTimeMillis();
            System.out.println("endTime" + (end - threadLocal.get()) );
            return end - threadLocal.get();
        }

    public static void main(String[] args) throws InterruptedException {
        Long startTime = ThreadLocalTest.getStartTime();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread.sleep(1000);
        Long endTime = ThreadLocalTest.getEndTime();
        new Thread(){
            @Override
            public void run() {
                Long startTime = ThreadLocalTest.getStartTime();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Long endTime = ThreadLocalTest.getEndTime();
            }
        }.start();
    }

}
