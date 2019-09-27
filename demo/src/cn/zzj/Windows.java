package cn.zzj;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;

public class Windows {
    public static void main(String[] args) throws Exception {
        JFrame frm=new JFrame("IP by Cherish");
        JLabel jlb =new JLabel("IP:"+"主机：");
        jlb.setForeground(Color.red);
        InetAddress inet=InetAddress.getLocalHost();

        frm.setBounds(100,100,300,100);

        //frm中包含一个内容窗格，需要获取内容窗格，在设置背景颜色，直接设置frm的背景颜色会被类容窗格挡住
        Container c=frm.getContentPane();
        //c.setBackground(Color.LIGHT_GRAY);
        //如果不设置为null默认，按钮会充满整个内容框，挡住背景颜色
        frm.setLayout(null);
        jlb.setBounds(10,5,300,50);
        //添加了按钮会把背景颜色挡住，可以通过面板来调节
        frm.add(jlb);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            if(localhost!=null)
                jlb.setText("IP："+localhost.getHostAddress()+"  主机: "+localhost.getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        }



