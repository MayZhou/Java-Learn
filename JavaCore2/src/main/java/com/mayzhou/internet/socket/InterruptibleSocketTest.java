package com.mayzhou.internet.socket;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author MayZhou
 */
public class InterruptibleSocketTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame jFrame = new InterruptibleSocketFrame();
            jFrame.setTitle("InterruptibleSocketTest: ");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });
    }


}

class InterruptibleSocketFrame extends JFrame {
    private Scanner in;
    private JButton interruptibleButton;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea messages;
    private TestServer server;

    private Thread connectThread;

    public InterruptibleSocketFrame() {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        final int TEXT_ROWS = 20;
        final int TEXT_COLUMNS = 60;

        messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(messages));

        interruptibleButton = new JButton("interruptible");
        blockingButton = new JButton("blocking");

        northPanel.add(blockingButton);
        northPanel.add(interruptibleButton);

        interruptibleButton.addActionListener(event -> {
            interruptibleButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);
            connectThread = new Thread(() -> {
                try {
                    connectInterruptibly();
                } catch (IOException e) {
                    messages.append("\n InterruptibleSocketTest.connectInterruptibly: " + e);
                }
            });
            connectThread.start();
        });

        blockingButton.addActionListener(event -> {
            interruptibleButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);
            connectThread = new Thread(() -> {
                try {
                    connectBlocking();
                } catch (IOException e) {
                    messages.append("\n InterruptibleSocketTest.connectBlocking: " + e);
                }
            });
            connectThread.start();
        });

        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        northPanel.add(cancelButton);
        cancelButton.addActionListener(event -> {
            connectThread.interrupt();
            cancelButton.setEnabled(true);
        });
        server = new TestServer();
        new Thread(server).start();
        pack();
    }

    private void connectInterruptibly() throws IOException {
        messages.append("Interruptibly: \n");
        try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189))) {
            in = new Scanner(channel, "UTF-8");
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading ");
                if (in.hasNextLine()) {
                    String ling = in.nextLine();
                    messages.append(ling);
                    messages.append("\n");
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                messages.append("Channel close \n");
                interruptibleButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }

    private void connectBlocking() throws IOException {
        messages.append("Blocking:\n");
        try (Socket sock = new Socket("localhost", 8189)) {
            in = new Scanner(sock.getInputStream(), "UTF-8");
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading ");
                if (in.hasNextLine()) {
                    messages.append(in.nextLine() + "\n");
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                messages.append("Socket closed\n");
                interruptibleButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }

    class TestServer implements Runnable {
        public void run() {
            try (ServerSocket s = new ServerSocket(8189)) {
                while (true) {
                    Socket incoming = s.accept();
                    Runnable r = new TestServerHandler(incoming);
                    Thread t = new Thread(r);
                    t.start();
                }
            } catch (IOException e) {
                messages.append("\nTestServer.run: " + e);
            }
        }
    }

    class TestServerHandler implements Runnable {
        private Socket incoming;
        private int counter;

        public TestServerHandler(Socket incoming) {
            this.incoming = incoming;
        }

        @Override
        public void run() {
            try {
                try {
                    OutputStream outStream = incoming.getOutputStream();
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outStream, "UTF-8"),
                            true);
                    while (counter < 100) {
                        counter++;
                        if (counter <= 10) out.println(counter);
                        Thread.sleep(100);
                    }
                } finally {
                    incoming.close();
                    messages.append("Closing server\n");
                }
            } catch (Exception e) {
                messages.append("\nTestServerHandler.run: " + e);
            }
        }
    }
}



