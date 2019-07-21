package basic.net.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class MyFirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端 write: ");
        ByteBuf bytes = getBytes(ctx);
        ctx.writeAndFlush(bytes);
    }

    private ByteBuf getBytes(ChannelHandlerContext ctx) {
        ByteBuf buffer = ctx.alloc().buffer();
        byte[] bytes = "how are you ".getBytes(Charset.forName("utf-8"));
        buffer.writeBytes(bytes);
        return buffer;
        
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端read:" + ( byteBuf).toString(Charset.forName("utf-8")));
    }
}
