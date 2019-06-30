package SimpleDesign.ChainHandler;

public class test {
    public static void main(String[] args) {
        ConcreateHandle1 handle1 = new ConcreateHandle1();
        ConcreateHandler2 handler2 = new ConcreateHandler2();
        int [] nums = {3,4,7,22,11,99,8,0};
        handle1.setHandler(handler2);
        for (int n : nums
             ) {
            handle1.dealWithRquest(n);
        }
    }
}
