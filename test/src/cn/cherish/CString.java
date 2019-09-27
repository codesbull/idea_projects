package cn.cherish;

import javax.swing.*;
import java.awt.*;
//实现屏幕上的字符"Hello Java"走动的线程程序
public class CString extends JPanel implements Runnable {
    int x=10,y=50;
    String Message="Hello Java";//字符串对象
    Font f=new Font("TimesRoman",Font.BOLD,24);//创建字体对象
    Thread th1=new Thread(this);
    public CString(){
        start();
    }
    private void start(){
        th1.start();
    }
    public void run(){
        while (true){
            x=x-5;
            if (x==0)
                x=300;
            repaint();//调用paint()方法重画字符串
            try {
                Thread.sleep(500);//使线程睡眠500ms
            }catch (InterruptedException e){}
        }//while
    }//run
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D) g;
        g2.setFont(f);//设置字体
        g2.drawString(Message,x,y);
    }
}
