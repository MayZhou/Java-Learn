package com.mayzhou.log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

/**
 * @author MayZhou
 */
public class LoggingImageViewer {
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                //这里不需要同步。添加新日志记录器对象的所有同步都由LogManager.addLogger()处理。
                Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;

                /**
                 * 初始化<tt>FileHandler</tt>以写入一组文件。当(近似地)将给定的限制写入一个文件时，将打开另一个文件。输出将循环通过一组计数文件。
                 * <tt>FileHandler</tt>是基于<tt>LogManager</tt>属性(或它们的默认值)配置的，只是使用给定的模式参数作为文件名模式，
                 * 文件限制设置为limit参数，文件计数设置为给定的count参数。
                 *
                 * @param pattern  命名输出文件的模式
                 *@param limit  要写入任何一个文件的最大字节数
                 *@param count  要使用的文件数量
                 */
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                /**
                 * 添加一个日志处理程序来接收日志消息。
                 * *默认情况下，日志记录器还将其输出发送给父日志记录器。
                 * 通常，根日志程序配置了一组处理程序，这些处理程序本质上充当所有日志程序的默认处理程序。
                 @param   handler 日志处理程序
                 */
                Logger.getLogger("com.horstmann.corejava").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE,
                        "Can't create log file handler", e);
            }
        }

        /**
         * 代码>EventQueue</code>是一个独立于平台的类，它对来自底层对等类和受信任的应用程序类的事件进行排队。
         * invokeLater()方法的作用是将在处理所有挂起事件之后再运行这个方法。运行结束就销毁
         */
        EventQueue.invokeLater(() ->
        {
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.horstmann.corejava").fine("Showing frame");
            frame.setVisible(true);
        });
        //获得给定名字的日志记录器,如果这个日志记录器不存在，创建一个日志记录器
    Logger loggers = Logger.getLogger("com.mycompany.myapp");
        /**
         * 为已命名的子系统查找或创建日志程序。如果已经创建了具有给定名称的日志程序，则返回该日志程序。
         * 否则将创建一个新的日志记录器。
         * 如果创建了一个新的日志记录器，它的日志级别将基于LogManager进行配置，并且还将配置为将日志输出发送到其父处理程序。
         * 它将在LogManager全局名称空间中注册。
         *
         * 注意:LogManager可能只保留对新创建的日志程序的弱引用。
         * 重要的是要理解，如果没有对日志程序的强引用，那么以前创建的具有给定名称的日志程序可能在任何时候被垃圾收集。
         * 特别是，这意味着，如果程序中没有对名为“MyLogger”的日志程序的强引用，
         * 则getLogger(“MyLogger”，…).log(…)这样的两个背对背调用可能使用不同的名为“MyLogger”的日志程序对象。
         * 如果已命名的日志程序已经存在，并且还没有本地化资源包，则使用给定的资源包名称。
         * 如果已命名的日志程序已经存在，并且具有不同的资源束名称，则抛出IllegalArgumentException。
         *
         * @param   name    日志记录器的名称。这应该是一个点分隔的名称，通常应该基于子系统的包名或类名，例如java.net或javax.swing
         * @param   resourceBundleName  要用于本地化此日志程序的消息的ResourceBundle名称。如果没有任何消息需要本地化，则可能为空。
         * @return a 一个合适的记录器
         */
    loggers = Logger.getLogger("com.mycompany.myapp","");


    }
}

/**
 * 图形化显示框架
 * The frame that shows the image.
 */
class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    //
    private static Logger logger = Logger.getLogger("com.horstmann.corejava");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });

        // use a label to display the images
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");
    }

    private class FileOpenListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", event);

            // set up file chooser
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            // accept all files ending with .gif
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                public String getDescription() {
                    return "GIF Images";
                }
            });

            // show file chooser dialog
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            // if image file accepted, set it as icon of the label
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            } else logger.fine("File open dialog canceled.");
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
    }
}

/**
 * A handler for displaying log records in a window.
 */
class WindowHandler extends StreamHandler {
    private JFrame frame;

    public WindowHandler() {
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            public void write(int b) {
            } // not called

            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        });
    }

    public void publish(LogRecord record) {
        if (!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
