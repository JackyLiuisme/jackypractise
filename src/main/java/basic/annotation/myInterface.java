package basic.annotation;

public interface myInterface {
     String name = "jacky";
    default public void get(){
        System.out.println("getMethod");
    }
}
