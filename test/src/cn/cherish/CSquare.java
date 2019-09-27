package cn.cherish;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
//实现屏幕矩形框走动的线程程序
public class CSquare extends JPanel implements Runnable {
    int x1,y1,w1,h1;
    Thread th2=new Thread(this);
    public CSquare(){
        x1=5;y1=100;w1=40;h1=40;
        start();
    }
    private void start(){
        th2.start();
    }
    public void run(){
        while(true){
            x1=x1+5;
            if (x1==250)
                x1=0;
            repaint();//repaint()方法调用paint()方法重画矩形框
            try {
                Thread.sleep(500);//使th2线程睡眠500ms
            }catch (InterruptedException e){}
        }//while
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D) g;
        Rectangle2D.Double rec1=new Rectangle2D.Double(x1,y1,w1,h1);
        g2.draw(rec1);
    }
}
