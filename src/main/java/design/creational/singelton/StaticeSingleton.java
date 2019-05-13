package design.creational.singelton;

public class StaticeSingleton {
   // public static StaticeSingleton staticeSingleton;
    private static class inner{
        private static StaticeSingleton Instace = new StaticeSingleton();
    }
    public static StaticeSingleton getStaticeSingleton(){

        return inner.Instace;
    }
    public void say(){
        System.out.println("hello ");
    }

    public static void main(String[] args) {
        StaticeSingleton staticeSingleton = getStaticeSingleton();
        staticeSingleton.say();
    }
}
