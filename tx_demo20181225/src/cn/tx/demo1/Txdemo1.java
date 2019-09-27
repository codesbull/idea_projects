package cn.tx.demo1;
import com.sun.javafx.scene.text.TextLayout;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.w3c.dom.Text;
import javax.swing.*;
import java.awt.*;

public class Txdemo1 {
    public static void main(String[] args) {
        //窗口的类，jdk中提供的类
        JFrame frame=new JFrame();
        //设置大小
        //frame.setSize(400,300);
        //设置窗口显示的位置
        frame.setBounds(100,100,400,300);

        //设置布局方式，使用流式布局
        frame.setLayout(new FlowLayout());

        //布局影响效果，默认是边界布局
        //布局
        //把按钮放到窗口
        //创建按钮对象，把按钮放到窗口上去
        JButton button=new JButton( "我是按钮");
        //把按钮放到窗口上去
        //frame.add(button, BorderLayout.SOUTH);
        frame.add(button);

        JButton button1=new JButton("按钮");
        frame.add(button1);

        //调用方法，显示窗口
        frame.setVisible(true);
    }
}
