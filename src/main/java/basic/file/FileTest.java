package basic.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        System.out.println(file.getName()+file.getAbsolutePath());
        File aaa = File.createTempFile("aaa", ".txt", file);
        aaa.deleteOnExit();
        File newFile = new File(System.currentTimeMillis() + "");
       System.out.println(newFile.exists());
        boolean newFile1 = newFile.createNewFile();
        System.out.println(newFile1);
        newFile.mkdir();
    }
}
