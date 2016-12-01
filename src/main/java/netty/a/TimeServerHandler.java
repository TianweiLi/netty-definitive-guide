package netty.a;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * 用于对网络事件读写操作
 * 
 * @author litianwei 2016年11月28日
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()]; //获取缓冲区可读字节数
        buf.readBytes(req); //将缓冲区字节数组复制到byte数组中
        String body = new String(req, "UTF-8");
        System.out.println("the time server receive order : " + body);
        String currentTime = "query time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString()
                : "bad order";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp); // 把待发送消息写入缓冲区
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush(); //将缓冲区消息全部写入SocketChannel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
