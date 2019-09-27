package cn.zit;

import javax.swing.*;
import java.awt.*;
/*
使用不同字体绘制文字
 */

public class C9_3 extends JApplet {//创建font对象
    Font f1=new Font("TimesRoman",Font.BOLD,16);
    Font f2=new Font("Courir",Font.ITALIC,24);
    Font f3=new Font("Helvetica",Font.PLAIN,14);

    String hStr="Courir";

    public void paint(Graphics g)
    {//使用.setFont()设置创建好的Font类的对象
        Graphics2D g2=(Graphics2D)g;
        g2.setFont(f1);
    //调用drawString方法绘制文字
        g2.drawString("TimesRoman",20,50);

        g2.setFont(f2);

        g2.drawString(hStr,20,100);

        g2.setFont(f3);

        g2.drawString("Helvetica",20,150);
    }
}
