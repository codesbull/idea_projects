package cn.zzj;

import javafx.scene.chart.BarChart;
import jdk.nashorn.internal.ir.CatchNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class JMenuDemo extends JFrame {
    JTextArea tf=new JTextArea("当前系统版本:");

    JMenuBar bar=new JMenuBar();//创建菜单栏
    JMenu menu=new JMenu("Key");//创建菜单
    JMenu InstallKey=new JMenu("Install Key");
    JMenuItem key1=new JMenuItem("Win7 key");//创建菜单项
    JMenuItem key2=new JMenuItem("Office2010 key");
    JMenuItem key3=new JMenuItem("Win10 key");
    JMenuItem key4=new JMenuItem("Office2019 key");
    JMenuItem exit=new JMenuItem("exit");
    JMenuItem winkey=new JMenuItem("Install Windows Key");
    JMenuItem offkey=new JMenuItem("Install Office Key");
    JMenuItem About=new JMenuItem("About");

    public JMenuDemo(){
        super("Key by cherish");
        getContentPane().add(new JScrollPane(tf));//创建JFame的容器对象
        tf.setEnabled(true);//文本区域不可编辑
        bar.setOpaque(false);//设置bar为不透明
        setJMenuBar(bar);//加入bar到JFrame中
        menu.add(key1);//加入JMenuItem到menu中
        menu.add(key2);
        menu.add(key3);
        menu.add(key4);
        menu.add(exit);
        InstallKey.add(winkey);
        InstallKey.add(offkey);
        menu.addSeparator();//在JMenu中加入一分割线
        bar.add(InstallKey);
        bar.add(menu);
        bar.add(About);


        key1.addActionListener(new Ac());//注册监听器对象
        key2.addActionListener(new Ac());
        key3.addActionListener(new Ac());
        key4.addActionListener(new Ac());
        exit.addActionListener(new Ac());
        About.addActionListener(new Ac());
    }
    class Ac implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==key1)tf.setText("Win7 Ultimate Retail:RHTBY-VWY6D-QJRJ9-JGQ3X-Q2289");
            if (e.getSource()==key2)tf.setText("Office2010 Plus Retail:7PXYK-9CXTF-6JHGT-XDM4W-2TGR8");
            if (e.getSource()==key3)tf.setText("Win10 Professional(kms):W269N-WFGWX-YVC9B-4J6C9-T83GX");
            if (e.getSource()==key4)tf.setText("Office2019(kms):NMMKJ-6RK4F-KMJVX-8D9MJ-6MWKP");
            if (e.getSource()==exit)System.exit(0);
            if (e.getSource()==About){
                //JOptionPane.showMessageDialog(null, (Object)"http://student.csdn.net/space.php?do=home");
                String Content=	"*Author:cherish\n*Version:1.0\n*Date:2019-2-23 23:00\n版权所有,翻版必究!";
                JOptionPane.showMessageDialog(null, Content, "关于我们", JOptionPane.INFORMATION_MESSAGE);

            }

        }}

        class WinLis extends WindowAdapter{
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
    }
            public  static void main(String[] args) {
                JFrame frame = new JMenuDemo();
                frame.setSize(400, 200);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            }
}

