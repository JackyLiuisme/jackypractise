package basic.net.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuffer = (ByteBuf) msg;
        System.out.println(new Date() + "服务端读到的数据 ： "+ byteBuffer.toString(Charset.forName("utf-8")))
        ;

        System.out.println(new Date() + "服务端写出数据");
        ByteBuf send  = getByte(ctx);
        ctx.channel().writeAndFlush(send);
    }

    private ByteBuf getByte(ChannelHandlerContext cxt) {
        byte[] bytes = "hello , I am jcaky".getBytes();
        ByteBuf byteBuffer = cxt.alloc().buffer();
        byteBuffer.writeBytes(bytes);
        return byteBuffer;
    }
}
