package cn.zzj;

import com.sun.deploy.util.SessionState;
import com.sun.java.accessibility.util.java.awt.CheckboxTranslator;
import javafx.beans.property.adapter.JavaBeanLongPropertyBuilder;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.Socket;

/*
*服务器指定端口号，测试完端口号可用即可启动

客户端连接 server的端口号和ip，
指定自己昵称，客户端可以开启多个，实现群聊，
昵称就是各自客户端的“发言者”，
客户端可在不同的多个主机上启动，同时聊天。
*
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client
 *
 * @author hx0272
 */
public class Client{
    public static void main(String[] args) {
        ClientFrame frame = new ClientFrame(); }

}
class ClientFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel headPanel;
    private JPanel footPanel;
    private JTextArea showArea;
    private JTextField inputTxt;
    private JLabel portLbl;
    private JLabel ipLbl;
    private JLabel nameLbl;
    private JTextField portTxt;
    private JTextField ipTxt;
    private JTextField nameTxt;
    private JButton submitBtn;
    private JButton nameBtn;
    private JButton loginBtn;
    private Socket clientSocket = null;
    private DataOutputStream dos = null;
    private DataInputStream dis = null;
    private boolean bConnect = false;
    private String name = "";


    public ClientFrame()  { init(); }
    private void init() {
//main panel Begin
        mainPanel = new JPanel();
        showArea = new JTextArea(15, 50);
        showArea.setEditable(false);
        mainPanel.add(showArea);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
//main panel End
//head panel Begin
        headPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        portLbl = new JLabel("PORT");
        portTxt = new JTextField(7);
        ipLbl = new JLabel("IP");
        ipTxt = new JTextField(15);
        nameLbl = new JLabel("name");
        nameTxt = new JTextField(10);
        nameBtn = new JButton("OK");
        loginBtn = new JButton("login");
        nameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tmp = nameTxt.getText();
                if (tmp != null || !tmp.equals("")) {
                    int id = javax.swing.JOptionPane.showConfirmDialog(null, "yes or no", "choose yes",
                            javax.swing.JOptionPane.OK_OPTION);
                    if (id == 0) {
                        name = nameTxt.getText();
                        loginBtn.setEnabled(true);
                        nameBtn.setEnabled(false);
                    }
                }
            }
        });

        headPanel.add(portLbl);
        headPanel.add(portTxt);
        headPanel.add(ipLbl);
        headPanel.add(ipTxt);
        headPanel.add(loginBtn);
        headPanel.add(nameLbl);
        headPanel.add(nameTxt);
        headPanel.add(nameBtn);
        loginBtn.setEnabled(false);
        loginBtn.addActionListener(new ButtonClickAction());
        getContentPane().add(headPanel, BorderLayout.NORTH);
//head panel End
//foot panel Begin
        footPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputTxt = new JTextField(50);
        submitBtn = new JButton("submit");
        footPanel.add(inputTxt);
        footPanel.add(submitBtn);
        submitBtn.addActionListener(new ButtonClickAction());
        submitBtn.setEnabled(false);
        getContentPane().add(footPanel, BorderLayout.SOUTH);

//foot panel End
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                disConnect();
                System.exit(0);
            }
        });
        this.setSize(100, 100);

        setLocation(100, 100);
        pack();
        setVisible(true);


    }

    /**
     * send message to server
     *
     * @author hx0272
     */
    private void sendToServer(String str) {
        try {
            dos.writeUTF(name + ":" + str);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * close resource
     *
     * @author hx0272
     */
    private void disConnect() {
        try {
// clientSocket.close();
//
// dos.close();
            bConnect = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * connection begin
     *
     * @author hx0272
     */
    private void connect() {
        try {
            if (ipTxt.getText().matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}") && portTxt.getText().matches("\\d+")) {
                clientSocket = new Socket(ipTxt.getText(), Integer.parseInt(portTxt.getText()));
                dos = new DataOutputStream(clientSocket.getOutputStream());
                dis = new DataInputStream(clientSocket.getInputStream());
                bConnect = true;
                new Thread(new Receive()).start();
                System.out.println("I am coming");
                javax.swing.JOptionPane.showMessageDialog(null, "connect server success");
                submitBtn.setEnabled(true);
                inputTxt.addActionListener(new EnterClickAction());
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "port or ip be inputted is illegal");
            }
        } catch (UnknownHostException uhe) {
            javax.swing.JOptionPane.showMessageDialog(null, "connect server error");
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "connect server error");
        }
    }

    /**
     * login button / submit button action listener
     *
     * @author hx0272
     */
    class ButtonClickAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("submit".equals(e.getActionCommand())) {
                String str = inputTxt.getText().trim();
                inputTxt.setText("");
                sendToServer(str);
            } else if ("login".equals(e.getActionCommand())) {
                connect();
            }
        }
    }

    /**
     * enter be inputted event
     *
     * @author hx0272
     */
    class EnterClickAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str = inputTxt.getText().trim();
            inputTxt.setText("");
            sendToServer(str);
        }
    }

    /**
     * receive message from server
     *
     * @author hx0272
     */
    private class Receive implements Runnable {
        public void run() {
            try {
                while (bConnect) {
                    String str = dis.readUTF();
                    showArea.setText(showArea.getText() + str + "\n");
                }
            } catch (IOException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "connect server error");
            }
        }
    }

}

