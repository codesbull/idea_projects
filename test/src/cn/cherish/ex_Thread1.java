package cn.cherish;
import sun.awt.CharsetString;
import javax.swing.*;
import java.awt.*;
//主程序
public class ex_Thread1 extends JApplet {
    public void init(){
        //得到窗口容器对象
        Container cp=getContentPane();
        CString pa=new CString();//创建JPanel对象
        CSquare pal=new CSquare();//创建JPanel类的对象
        pa.setPreferredSize(new Dimension(300,150));
        pa.setBackground(Color.cyan);//设置pa的对象背景颜色
        pal.setPreferredSize(new Dimension(300,150));
        pal.setBackground(Color.cyan);//设置pal的对象背景颜色
        //cp容器的布局为BorderLayout,添加pa及pal的对象到cp容器中
        cp.add(pa,BorderLayout.NORTH);
        cp.add(pal,BorderLayout.SOUTH);
    }
}
