package cn.zzj;
import javax.swing.*;
import java.awt.*;

public class SendKey{
    Frame frm=new Frame("SendKey V1.0");
    JTextField text1=new JTextField();
    JTextField text2=new JTextField();
    JLabel label1=new JLabel("ID");
    JButton btn=new JButton("发送");

    public SendKey(){
        frm.add(text1);
        frm.add(text2);
        frm.add(label1);
        frm.setLayout(null);
        frm.add(btn);
        text1.setBounds(20,40,50,20);
        text2.setBounds(20,65,220,20);
        label1.setBounds(5,40,40,20);
        btn.setBounds(240,65,100,20);
        frm.setSize(350,150);
        frm.setResizable(false);
        frm.setVisible(true);
        frm.setLayout(null);
        frm.setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        SendKey send=new SendKey();

    }

}
