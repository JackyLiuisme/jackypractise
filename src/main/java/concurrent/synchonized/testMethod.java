package concurrent.synchonized;

public class testMethod {
    public static synchronized int add(int a, int b){
        System.out.println("result is ：" + a+ b);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep is over");
        return a+b;
    }
    public synchronized int minu(int a, int b) {
        System.out.println("minu result is ：" +(a - b));
        return a-b;
    }
    public void getResult() {
        Object lock = new Object();
        synchronized(testMethod.class){
            System.out.println("I am lock the mthod");
        }
    }

    public static void main(String[] args) {
        testMethod testMethod = new testMethod();
        new Thread(new Runnable() {
            @Override
            public void run() {

                int add = testMethod.add(1, 2);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                testMethod.getResult();
            }
        }).start();
    }
}
