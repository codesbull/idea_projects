package cn.tx.demo1;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginDemo extends JFrame{
    public static void main(String[] args) {
        //创建窗口
        JFrame frame=new JFrame();
        //设置显示位置
        frame.setBounds(300,300,400,350);
        //居中显示
        //this.setLocationRelativeTo(null);
        //窗体大小不能改变
       // this.setResizable(false);

        //存放图片或者存放文字,反射的代码
        JLabel label1=new JLabel(new ImageIcon(LoginDemo.class.getResource("/3.gif")));
        //把lable1存放到窗口上
        frame.add(label1, BorderLayout.NORTH);
        //*******************************************
        JPanel panel=new JPanel();
        //清除布局方式，自由式的布局
        panel.setLayout(null);
        //把面板存放窗口上
        frame.add(panel);
        //存放图片
        JLabel label2=new JLabel(new ImageIcon(LoginDemo.class.getResource("/2.jpg")));
        //设置label2位置
        label2.setBounds(25,10,80,80);
        //把图片存放在面板上
        panel.add(label2);

        //********************************************
        //账号框
        JTextField field1=new JTextField();
        field1.setBounds(110,10,180,30);
        panel.add(field1);
        //密码框
        JTextField  field2=new JTextField();
        field2.setBounds(110,50,180,30);
        panel.add(field2);
        //记住密码
        JCheckBox jcbsPsw=new JCheckBox("记住密码");
        jcbsPsw.setBounds(110,85,80,15);
        panel.add(jcbsPsw);
        //自动登录
        JCheckBox jcbLogin=new JCheckBox("自动登陆");
        jcbLogin.setBounds(210,85,80,15);
        panel.add(jcbLogin);
        //注册账号
        JLabel jlbReg=new JLabel("注册账号");
        jlbReg.setBounds(300,15,60,15);
        panel.add(jlbReg);
        JLabel jlbPsw=new JLabel("找回密码");
        jlbPsw.setBounds(300,50,60,15);
        panel.add(jlbPsw);

        // 登录按钮,一个图片
        JLabel label3 = new JLabel(new ImageIcon(LoginDemo.class.getResource("/4.png")));
        label3.setBounds(110,100,180,30);
        panel.add(label3);

        //按钮
        /*JButton btnLogin=new JButton("Login");
        btnLogin.setBounds(110,100,180,25);
        panel.add(btnLogin);
        */

        //显示窗口
        frame.setVisible(true);
    }
}
