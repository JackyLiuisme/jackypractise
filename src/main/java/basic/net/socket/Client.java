package basic.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        Socket socket = new Socket("localhost", 2000);
        printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.println("hello");

        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true){
            String str = bufferedReader.readLine();
            if (str == null){
                break;
            }
            System.out.println(str);
        }














       /* PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            Socket socket = new Socket("localhost",2000);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            printWriter = new PrintWriter(socket.getOutputStream(),true);

            printWriter.println("hello");
            while (true){
                String s = bufferedReader.readLine();
                if (s == null){
                    break;
                }
                System.out.println(s);
            }
        }catch (Exception e){
        }finally {
            bufferedReader.close();
            printWriter.close();
        }*/
    }
}
