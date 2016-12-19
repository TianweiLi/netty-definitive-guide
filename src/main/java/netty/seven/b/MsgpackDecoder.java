package netty.seven.b;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import org.msgpack.MessagePack;

/**
 * 解码器
 * 
 * @author litianwei 2016年12月14日
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        int length = msg.readableBytes();
        byte[] array = new byte[length];
        msg.getBytes(msg.readerIndex(), array, 0, length);
        MessagePack messagePack = new MessagePack();
        out.add(messagePack.read(array));
    }
}
