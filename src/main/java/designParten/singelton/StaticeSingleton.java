package designParten.singelton;

public class StaticeSingleton {
    private StaticeSingleton(){};
    public static StaticeSingleton staticeSingleton;
    private static class inner{
        private static StaticeSingleton Instace = new StaticeSingleton();
    }
    public StaticeSingleton getStaticeSingleton(){
       return inner.Instace;
    }
}
