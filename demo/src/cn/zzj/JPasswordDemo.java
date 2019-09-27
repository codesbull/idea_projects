package cn.zzj;
/*
JTextField是使用明文方式进行数据显示的，
如果现在需要将回显的内容设置成其他字符，
则可以使用JPasswordFieldl
 */
import javax.swing.*;
import java.awt.*;

public class JPasswordDemo {
    public static void main(String[] args) {
        JFrame frm=new JFrame("使用密码框");
        JPasswordField jps1=new JPasswordField();
        JPasswordField jps2=new JPasswordField();
        //密码框二设置回显为"#"
        jps2.setEchoChar('#');//设置回显
        JLabel label1=new JLabel("默认的回显：");
        JLabel label2=new JLabel("回显设置为'#'：");

        label1.setBounds(10,10,100,20);
        label2.setBounds(10,30,100,20);
        jps1.setBounds(100,10,100,20);
        jps2.setBounds(100,30,100,20);

        frm.setLayout(null);
        frm.add(label1);
        frm.add(label2);
        frm.add(jps1);
        frm.add(jps2);
        frm.setIconImage(new ImageIcon("E://1.png").getImage());


        frm.setLocation(500,300);
        frm.setSize(350,260);
        frm.setVisible(true);
    }
}
