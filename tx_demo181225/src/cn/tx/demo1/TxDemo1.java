package cn.tx.demo1;

import javax.swing.*;
import java.awt.*;

/**
 * 拓薪教育：樱木老师
 * 腾讯课堂搜索：拓薪教育
 * 腾讯课堂直播间地址：https://ke.qq.com/course/149432
 * idea免费视频学习地址：https://ke.qq.com/course/363570
 * 加入QQ群领取免费资料和视频：QQ群号 344379612
 */
public class TxDemo1 {

    // 编写main主函数 psvm
    public static void main(String[] args) {
        // 演示窗口类，JDK中提供类
        JFrame frame = new JFrame();
        // 设置大小
        // frame.setSize(400,300);
        // 设置窗口显示的位置
        frame.setBounds(100,100,400,300);

        // 设置布局的方式，使用流式布局
        frame.setLayout(new FlowLayout());

        // 布局，布局影响的效果，默认的布局的效果，默认是边界布局
        // 把按钮放在窗口上
        // 创建按钮对象，把按钮存放到窗口上去
        JButton button = new JButton("我是按钮");
        // 把按钮存放到窗口上去
        // frame.add(button, BorderLayout.SOUTH);
        frame.add(button);

        JButton button1 = new JButton("按钮");
        frame.add(button1);

        // 调用方法，显示窗口
        frame.setVisible(true);
    }

}
