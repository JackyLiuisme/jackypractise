package SimpleDesign.Singletom;

public class fullSingle {
    private final static fullSingle instance = new fullSingle();

    private fullSingle(){}

    public fullSingle getInstance(){
        return instance;
    }
}
