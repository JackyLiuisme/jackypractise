package basic.serializ;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class WritObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/jacky/Desktop/file.txt"));
        Person o = (Person) objectInputStream.readObject();
        System.out.println(o.getSex() + o.getName());
    }
}
