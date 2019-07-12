package basic.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        ServerSocket serverSocket = new ServerSocket(2000);
        Socket socket = serverSocket.accept();
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.println("I got it");
        while (true){
            String string = bufferedReader.readLine();
            if (string == null){
                break;
            }
        }










    /*    BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try{
            ServerSocket server = new ServerSocket(2000);
            Socket socket = server.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);
            String s = bufferedReader.readLine();
            printWriter.println(s);
        }catch (Exception e){

        }finally {
            bufferedReader.close();
            printWriter.close();
        }
*/
    }
}
