package concurrent.CyclicBarrierTest;

import java.util.concurrent.CyclicBarrier;

public class BankWaterService implements Runnable{
    private CyclicBarrier c = new CyclicBarrier(4,this);

    @Override
    public void run() {

    }
}
