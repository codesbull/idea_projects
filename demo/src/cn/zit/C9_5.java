package cn.zit;

import javax.swing.*;
import java.awt.*;

public class C9_5 extends JApplet {
    public void paint(Graphics g)
    {
        Graphics2D g2=(Graphics2D)g;
        int red,green,blue;
        red=255;blue=255;green=0;

        //设置前景颜色
        g2.setPaint(new Color(red,green,blue));
        //设置背景颜色
        getContentPane().setBackground(Color.cyan);

        g2.drawString("Welcome to Xi\037an",25,75);
        //状态行显示绘图文字颜色信息
        showStatus("Current RGB:"+g2.getPaint().toString());
    }
}
