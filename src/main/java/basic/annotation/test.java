package basic.annotation;

import java.lang.annotation.Annotation;

public class test {
    @myFirst(name = "jacky",age = 11)
    public void getMessage(){
            return;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Annotation[] annotation = Class.forName("test").getMethod("getMessage").getAnnotations();
        for (Annotation a:annotation
             ) {
            System.out.println(a);
        }
    }

}
