package com.mayzhou.internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 单线程模式
 * @author MayZhou
 */
public class EchoServer {
    public static void main(String[] args) {
        if (args.length>0){
            Arrays.stream(args).forEach(System.out::println);
        }
        try(ServerSocket s = new ServerSocket(8189)){
            try (Socket socket = s.accept()){
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                try (Scanner scanner = new Scanner(inputStream,"UTF-8")){
                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream,"UTF-8"),true /* autoFlush */);
                    printWriter.println("Hello,Enter BYE to exit.");
                    boolean down = false;
                    while (!down && scanner.hasNextLine()){
                        String line = scanner.nextLine();

                        if (line.trim().equals("BYE")){
                            down = true;

                        }
                        printWriter.println(line);
                    }
                    s.close();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
