package basic.annotation;

import java.lang.annotation.Annotation;

public class annotaions {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Annotation[] annotation = new test().getClass().getMethod("getMessage").getAnnotations();
        for (Annotation a:annotation
        ) {
            System.out.println(a);
        }
    }
}
