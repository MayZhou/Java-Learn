package com.mayzhou.internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author MayZhou
 */
public class ThreadEchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            int i = 1;
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("spawning : " + i);
                Runnable runnable = new ThreadedEchoHandler(socket);
                Thread t = new Thread(runnable);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class ThreadedEchoHandler implements Runnable {

    private Socket socket;


    public ThreadedEchoHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            writer.println("Hello! Enter BYE to exit.");
            boolean down = false;
            while (!down && scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.trim().equals("BYE")) {
                    down = true;
                }
                writer.println(line);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

