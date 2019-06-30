package SimpleDesign.ChainHandler;

public class ConcreateHandler2 extends Handler {


    @Override
    public void dealWithRquest(int request) {
        if (request >=10 ){
            System.out.println("我处理大于十个的请求"+request);
        }else {
            handler.dealWithRquest(request);
        }
    }
}
