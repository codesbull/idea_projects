package cn.zzj;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;

/*
如果要输入多行文本，
则可以使用JTextArea实现多行文本的输入。
JTextArea拓展了JTextComponent类
 */
public class JTextAreaDemo {
    public static void main(String[] args) {
        JFrame frm=new JFrame("多行文本域");
        //设置文本域的行数，列数
        JTextArea jTextArea=new JTextArea(3,20);
        JLabel label=new JLabel("多行文本域：");
        //设置标签大小
        label.setBounds(10,10,100,140);
        //设置文本域大小
        jTextArea.setBounds(100,10,200,140);
        //取消布局管理器，使用绝对定位
        frm.setLayout(null);//取消布局管理器
        frm.add(label);
        frm.add(jTextArea);
        frm.setSize(400,200);
        frm.setLocation(300,200);
        frm.setVisible(true);

    }
}
