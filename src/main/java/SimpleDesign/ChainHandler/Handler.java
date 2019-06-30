package SimpleDesign.ChainHandler;

public abstract class Handler {
    Handler handler;
    public void  setHandler(Handler handler) {
        this.handler = handler;
    }
    public abstract void dealWithRquest(int request);
}
