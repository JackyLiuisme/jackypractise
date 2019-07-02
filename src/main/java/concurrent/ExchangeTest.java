package concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static final ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水a";
                try {
                    String B = exgr.exchange(A);
                    System.out.println("A: " +A+ " B :"+B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";
                try {
                    String A = exgr.exchange("b");
                    System.out.println("A: " +A+ " B :"+B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutdown();
    }
}
