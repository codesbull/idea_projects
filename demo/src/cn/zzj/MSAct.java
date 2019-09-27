package cn.zzj;

import javax.swing.*;

public class MSAct {
    public static void main(String[] args) {
        JFrame frm=new JFrame("MSAct-cherish");
        JButton btn1=new JButton("激活");
        JButton btn2=new JButton("查看证书");
        JTextField jtf=new JTextField("密钥输入框");

        jtf.setBounds(5,10,200,50);
        btn1.setBounds(250,10,100,50);

        frm.add(btn1);
        frm.add(btn2);
        frm.add(jtf);

        frm.setVisible(true);
        frm.setBounds(300,300,600,250);

    }
}
