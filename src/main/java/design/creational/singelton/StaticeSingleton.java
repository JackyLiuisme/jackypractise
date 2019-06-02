package design.creational.singelton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StaticeSingleton {
   // public static StaticeSingleton staticeSingleton;
    private static class inner{
        private static StaticeSingleton Instace = new StaticeSingleton();
    }
    public static StaticeSingleton getStaticeSingleton(){

        return inner.Instace;
    }
    public StaticeSingleton(){
        if (inner.Instace != null){
            System.out.println("can not build anthor instance");
            throw new RuntimeException();
        }
    }
    public StaticeSingleton(String name){
        System.out.println(name);
    }
    public void say(){
        System.out.println("hello ");
    }

    public static void main(String[] args) {
        StaticeSingleton staticeSingleton = getStaticeSingleton();
        staticeSingleton.say();
        Class<StaticeSingleton> staticeSingletonClass = StaticeSingleton.class;
        try {
            Constructor<StaticeSingleton> declaredConstructor = staticeSingletonClass.getDeclaredConstructor(String.class);
            try {
                StaticeSingleton staticeSingleton1 = declaredConstructor.newInstance("jacky");
                staticeSingleton1.say();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
      /*  try {
            StaticeSingleton staticeSingleton1 = staticeSingletonClass.newInstance();
            staticeSingleton1.say();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
    }
}
