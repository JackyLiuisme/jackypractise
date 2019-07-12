package basic.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

public class Cilent {
    public static void main(String[] args) {
        System.out.println("启动客户端");
        SocketChannel channel = null;
        try {
            channel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
            channel.configureBlocking(false);
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String str = scanner.next();
                allocate.put((new Date().toString()+" \n" + str).getBytes());
                allocate.flip();
                channel.write(allocate);
                allocate.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
