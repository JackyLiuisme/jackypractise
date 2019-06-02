package concurrent;

public class Join {
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++){
            Thread current = new Thread(new Demo(previous));
            current.start();
            previous = current;
        }
        System.out.println("I am Main");
    }

    static class Demo implements Runnable{

        private Thread thread;

        public  Demo(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+ "I am waiting" );
        }
    }
}
