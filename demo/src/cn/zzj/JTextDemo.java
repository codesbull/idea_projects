package cn.zzj;

import javax.swing.*;

public class JTextDemo {
    public static void main(String[] args) {
        JFrame frm=new JFrame("使用绝对定位布局JTextFeild");
        JTextField name=new JTextField(30);
        JTextField noed=new JTextField("默认文本",10);
        JLabel nameLab=new JLabel("userName:");
        JLabel noedLab=new JLabel("不可编辑文本");
        name.setColumns(30);
        noed.setColumns(10);
        noed.setEditable(false);
        nameLab.setBounds(10,10,90,20);
        noedLab.setBounds(10,30,90,20);
        name.setBounds(110,10,90,20);
        noed.setBounds(110,30,90,20);

        frm.setLayout(null);
        frm.add(name);
        frm.add(noed);
        frm.add(nameLab);
        frm.add(noedLab);

        frm.setVisible(true);
        frm.setSize(500,250);
        frm.setLocation(250,250);


    }
}
