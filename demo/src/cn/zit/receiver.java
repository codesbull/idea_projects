package cn.zit;
import jdk.nashorn.internal.ir.CatchNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

class receiver extends JFrame implements ActionListener{
    Font font=new Font("仿宋",Font.BOLD,14);
    private JLabel lbTip1=new JLabel("ID:5689");

    private  JButton btn3=new JButton("Act");
    private static JTextField my=new JTextField("Key    Input   Box");

    //private  JButton btn2=new JButton("证书查看");
    private  JButton btn=new JButton("CID激活");
   public receiver()
    {
        this.setTitle("MSAct v1.0");
        this.setSize(370,100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        Container cont=this.getContentPane();
        cont.setLayout(null);

        lbTip1.setFont(font);

        lbTip1.setForeground(Color.blue);

        lbTip1.setBounds(280,30,400,50);

        btn3.setBounds(270,10,80,25);
        //btn2.setBounds(5,40,100,25);
        my.setBounds(5,10,250,25);
        btn.setBounds(175,40,80,25);

        cont.add(lbTip1);
        cont.add(my);


        cont.add(btn3);
        //cont.add(btn2);
        cont.add(btn);
        btn3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==btn3){
          my.setText("F22VV-8BNQH-MTVWT-WMCR6-KTPJR");

       }
    }
    //接收密钥


    public static void main(String[] args) {
        new receiver();
    }
}
