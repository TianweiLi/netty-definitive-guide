package threadPoolBio;

import bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author litianwei 2016年11月21日
 */
public class TimeServer {

    public static void main(String[] args) {

    }

    public void start(int port) {

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);

            System.out.println("the time server is start in port : " + port);

            Socket socket;

            TimeServerHandlerExecutePool pool = new TimeServerHandlerExecutePool();

            while (true) {
                socket = server.accept();
                pool.execute(new TimeServerHandler(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
