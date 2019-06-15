package concurrent.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

    public static class myTask extends ForkJoinTask<Integer>{

        @Override
        public Integer getRawResult() {
            return null;
        }

        @Override
        protected void setRawResult(Integer value) {

        }

        @Override
        protected boolean exec() {
            return false;
        }
    }
    private static final int THRESHOLD = 2;
    private int start;
    private int end;
    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute){
            for(int i = start; i <= end; i++){
                sum += i;
            }
        }else {
            int mid = (start + end) / 2;
            CountTask leftTask = new CountTask(start,mid);
            CountTask rightTask = new CountTask(mid+1,end);
            leftTask.fork();
            rightTask.fork();
            Integer leftResult = leftTask.join();
            Integer rightReslut = rightTask.join();
            sum = leftResult + rightReslut;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        System.out.println(Runtime.getRuntime().availableProcessors());

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
