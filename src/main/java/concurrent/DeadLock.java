package concurrent;

public class DeadLock {
    private Object lockA = new Object();
    private Object lockB = new Object();
    public void getLock(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    System.out.println("ThreadA lock by a");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB){
                        System.out.println("ThreadA lock by b");
                    }
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lockB){
                System.out.println("ThreadB lock by a");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA){
                    System.out.println("ThreadB lock by b");
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.getLock();
    }
}
