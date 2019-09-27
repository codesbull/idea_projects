package com.company;

import javax.swing.*;
import java.awt.*;
public class Client {
    public Client(){
        JFrame p=new JFrame();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
        p.setVisible(true);//显示JFrame

        JLabel s=new JLabel("这是JFrame");//标签
        s.setPreferredSize(new Dimension(175,100));//标签位置

        p.getContentPane();//取得ContentPane
        p.add(s,BorderLayout.CENTER);
        p.pack();//调整窗口
        p.setTitle("用户注册");
        p.setLocationRelativeTo(null);//窗口居中显示
        p.setResizable(false);
    }
    public static void main(String[] args) {
        Client g=new Client();
    }
}
