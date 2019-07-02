package basic.serializ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class readObject {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/jacky/Desktop/file.txt"));
        Person person = new Person("jacky", "man");
        objectOutputStream.writeObject(person);
    }
}
