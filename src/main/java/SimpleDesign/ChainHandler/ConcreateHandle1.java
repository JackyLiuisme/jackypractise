package SimpleDesign.ChainHandler;

public class ConcreateHandle1 extends Handler {

    @Override
    public void dealWithRquest(int request) {
        if (request > 0 && request < 10){
            System.out.println("我处理10以内"+request);
        }else {
            handler.dealWithRquest(request);
        }
    }
}
