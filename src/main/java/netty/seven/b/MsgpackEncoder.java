package netty.seven.b;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import org.msgpack.MessagePack;

/**
 * 编码器
 *
 * 将Object类型的POJO对象编码为byte数组，写入ByteBuf
 * 
 * @author litianwei 2016年12月14日
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {

    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        MessagePack messagePack = new MessagePack();
        byte[] raw = messagePack.write(msg);
        out.writeBytes(raw);
    }
}
