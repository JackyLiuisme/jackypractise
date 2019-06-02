package concurrent.waitNotify;

public class WaitTest {
    private static boolean flag = true;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Wait()).start();
        new Thread(new Notify()).start();
    }


    static class Wait implements Runnable {

        @Override
        public void run() {
            while (flag){
                synchronized (lock){
                    System.out.println(Thread.currentThread()+"first time get lock flag is :" + flag);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread()+"seconde time get lock , flag is : " + flag);

        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread() + "get the lock");
                lock.notify();
                flag = false;
            }

            synchronized (lock){
                System.out.println(Thread.currentThread() + "get  loci again");
            }
        }
    }
}

