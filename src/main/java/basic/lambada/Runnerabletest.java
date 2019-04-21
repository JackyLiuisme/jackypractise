package basic.lambada;

public class Runnerabletest {
    public static void main(String[] args) {
        Object object;
        object = (Runnable)()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };
        String str = "abc";

        int c = str.indexOf("cd");
        testRunner run = Integer::valueOf;
                //code -> Integer.valueOf(code);
      /*  Integer run1 = run.run("993");
        System.out.println(run1);*/
        ((Runnable) object).run();
         new Thread((Runnable) () -> System.out.println("hello")).start();
    }
}
