package cn.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient extends JFrame implements ActionListener {

    JTextArea jta = null;
    JTextField jtf = null;
    JButton jb = null;
    JPanel jp1 = null;
    JScrollPane jsp = null;
    PrintWriter pw = null;

    public MyClient() {
        jta = new JTextArea();//文本区
        jsp = new JScrollPane(jta);//滚动面板
        jtf = new JTextField(10);//文本框
        // 注册回车事件
        jtf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        jb = new JButton("send");
        jb.addActionListener(this);// 注册一个监听事件
        jp1 = new JPanel();
        jp1.add(jtf);
        jp1.add(jb);
        this.add(jsp, BorderLayout.CENTER);
        this.add(jp1, BorderLayout.SOUTH);
        this.setTitle("Client");
        this.setSize(300, 200);
        this.setVisible(true);
        // 接收从服务端发送过来的消息
        try {
            Socket s = new Socket("192.168.169.1", 6000);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(), true);
            while (true) {
                String info = in.readLine();
                String str = null;
                if (jta.getText() == null || "".equals(jta.getText())) {
                    str = "Server:" + info;
                } else {
                    str = jta.getText() + "\r\nServer:" + info;
                }
                jta.setText(str);
                jta.setCaretPosition(jta.getDocument().getLength());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new MyClient();
    }

    // 把信息给服务器端
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            sendMessage();
        }
    }


    /**
     * @throws
     * @Description: 发送消息给服务器端
     */
    public void sendMessage() {
        String info = jtf.getText();
        pw.println(info);
        pw.flush();
        jtf.setText("");
        if (jta.getText() == null || "".equals(jta.getText())) {
            jta.append("Client:" + info);
        } else {
            jta.append("\r\nClient:" + info);
        }
        jta.setCaretPosition(jta.getDocument().getLength());// 设置滚动条自动滚动
    }
}
