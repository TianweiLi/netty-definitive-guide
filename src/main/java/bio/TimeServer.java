package bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author litianwei 2016年11月17日
 */
public class TimeServer {

    public static void main(String[] args) {
        TimeServer timeServer = new TimeServer();
        timeServer.start(8888);
    }

    public void start(int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

            while (true) {

                Socket socket = serverSocket.accept();

                //阻塞式I/O编程，一个客户端接入，就要启动一个线程处理
                new Thread(new TimeServerHandler(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
