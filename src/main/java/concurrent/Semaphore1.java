package concurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semaphore1 {
    private static final int COUNT = 30;
    private static ExecutorService executorService = Executors.newFixedThreadPool(COUNT);
    private static Semaphore s = new Semaphore(10);
    public static void main(String[] args) {
        for (int i = 0; i < COUNT ; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
