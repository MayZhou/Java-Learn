package com.mayzhou.internet.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * @author MayZhou
 */
public class SocketTest {
    public static void main(String[] args) {
        /**
         * new Socket("time-a.nist.gov", 13)会一直无限期的阻塞下去，直到建立了到达主机的初始连接为止
         */
        try (Socket socket = new Socket("time-a.nist.gov", 13);
             Scanner scanner = new Scanner(socket.getInputStream(), "UTF-8");) {
            Socket socket1 =new Socket();
            socket1.connect(new InetSocketAddress("time-a.nist.gov",13),1000);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                out.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
