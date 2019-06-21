package design.creational.singelton;

public class DoubleCheckSingleton {
    volatile static DoubleCheckSingleton instance =null;
    private DoubleCheckSingleton(){}

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
