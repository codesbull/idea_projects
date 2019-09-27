package cn.tx.demo1;

import javax.swing.*;
import java.awt.*;

/**
 * 拓薪教育：樱木老师
 * 腾讯课堂搜索：拓薪教育
 * 腾讯课堂直播间地址：https://ke.qq.com/course/149432
 * idea免费视频学习地址：https://ke.qq.com/course/363570
 * 加入QQ群领取免费资料和视频：QQ群号 344379612
 *
 * QQ登录页面编写
 * 事件绑定，服务器开发...
 */
public class TxDemo2 {

    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame();
        // 设置显示的位置
        frame.setBounds(300,300,400,350);

        // 分析代码编写过程
        // 存放图片或者存放文字，这么设计的，反射的代码，照着抄。
        JLabel label1 = new JLabel(new ImageIcon(TxDemo2.class.getResource("/3.gif")));
        // 把label1存放到窗口上，北
        frame.add(label1, BorderLayout.NORTH);

        // =====================================================
        JPanel panel = new JPanel();
        // 清除布局方式，自由式的布局
        panel.setLayout(null);
        // 把面板存放窗口上
        frame.add(panel);

        // 存放图片
        JLabel label2 = new JLabel(new ImageIcon(TxDemo2.class.getResource("/2.jpg")));
        // 设置label2的位置
        label2.setBounds(25,10,80,80);
        // 把图片存放面板上
        panel.add(label2);

        // =====================================================
        // 文本框
        JTextField field1 = new JTextField();
        field1.setBounds(110,10,180,30);
        panel.add(field1);

        // 密码框
        JPasswordField field2 = new JPasswordField();
        field2.setBounds(110,35,180,30);
        panel.add(field2);

        // 记住密码
        JCheckBox box1 = new JCheckBox("记住密码");
        box1.setBounds(110,75,80,15);
        panel.add(box1);

        // 记住密码
        JCheckBox box2 = new JCheckBox("自动登录");
        box2.setBounds(210,75,80,15);
        panel.add(box2);

        // 登录按钮，组件
        JLabel label3 = new JLabel(new ImageIcon(TxDemo2.class.getResource("/4.png")));
        label3.setBounds(110,100,180,30);
        panel.add(label3);

        // 显示窗口
        frame.setVisible(true);
    }

}
