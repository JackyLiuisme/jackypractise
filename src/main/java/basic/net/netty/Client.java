package basic.net.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Client {
    private static final int MAX_RETRY = 5;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    public static void main(String[] args) {

        NioEventLoopGroup work = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
         bootstrap.group(work).channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1024).
                 option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true).
                 handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new FirstClientHandler());
                    }
                });
        bootstrap.connect(HOST,PORT);





/*
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        final AttributeKey<Object> clientKey = AttributeKey.newInstance("clientKey");
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup).channel(NioSocketChannel.class).handler(new ChannelInboundHandlerAdapter(){
            @Override
            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                super.channelActive(ctx);
            }
        }).attr(AttributeKey.newInstance("clientName"),"nettyClient")
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,1024)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new FirstClientHandler());
                    }
                });
        connect(bootstrap,HOST,PORT,MAX_RETRY);*/

    }

    private static void connect(Bootstrap bootstrap, String host , int port, int retry) {
        bootstrap.connect(host,port).addListener(future -> {
            if (future.isSuccess()){
                System.out.println("链接成功");
            }else if (retry == 0){
                System.out.println("重试结束");
            }else {
                int order = (MAX_RETRY - retry) + 1;
                int delay = 1 << order;
                System.out.println(new Date() + "链接失败： 第" + order + " 次重连");
                bootstrap.config().group().schedule(()->connect(bootstrap,host,port,retry-1),
                        delay, TimeUnit.SECONDS);
            }
        });
    }
}
