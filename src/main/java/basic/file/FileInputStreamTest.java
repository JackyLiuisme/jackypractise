package basic.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamTest {


    public static void main(String[] args) throws IOException {
        /*FileInputStream fileInputStream = new FileInputStream("FileInputStreamTest.java");

        byte[] bytes = new byte[1024];
        int hasRead = 0;
        while ((hasRead = fileInputStream.read(bytes))>0){
            System.out.println(new String(bytes,0,hasRead));
        }
        fileInputStream.close();*/
        InputStreamReader inputStream = new InputStreamReader(System.in) ;
        BufferedReader reader = new BufferedReader(inputStream);

        String s = null;
        while ( ( s = reader.readLine()) != null){
            if (s.equals("exit")){
                System.exit(1);
            }
            System.out.println("输入为：" + s);

        }
    }
}
