package netty.seven.b;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import netty.f.UserInfo;

/**
 * @author litianwei 2016年12月14日
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

    private final int sendNumber;

    public EchoClientHandler(int sendNumber) {
        this.sendNumber = sendNumber;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] userInfos = this.UserInfo();
        for (UserInfo infoE : userInfos) {
            ctx.write(infoE);
        }
        ctx.flush();
    }

    private UserInfo[] UserInfo() {
        UserInfo[] userInfos = new UserInfo[sendNumber];
        for (int i = 0; i < sendNumber; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("name -->" + i);
            userInfo.setUserId(i);
            userInfos[i] = userInfo;
        }
        return userInfos;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client receive the msgback message : " + msg);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
