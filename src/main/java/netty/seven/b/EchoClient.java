package netty.seven.b;

/**
 * @author litianwei 2016年12月14日
 */
public class EchoClient {

    private final String host;

    private final int    port;

    private final int    sendNumber;

    public EchoClient(String host, int port, int sendNumber) {
        this.host = host;
        this.port = port;
        this.sendNumber = sendNumber;
    }



}
