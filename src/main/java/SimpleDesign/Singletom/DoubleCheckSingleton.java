package SimpleDesign.Singletom;

public class DoubleCheckSingleton {
    private DoubleCheckSingleton(){
    }

    private static volatile DoubleCheckSingleton instance;

    public DoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
