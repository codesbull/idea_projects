package cn.zit;

import javax.swing.*;
import java.awt.*;

public class C10_7 extends JFrame{
    //创建标签数组
    JLabel[] lb=new JLabel[3];
    //创建面板对象
    JPanel pa1=new JPanel();
    JPanel pa2=new JPanel(new GridLayout(1,2));

    public C10_7()
    {
        setLayout(new GridLayout(2,1));
        for (int i=0;i<lb.length;i++)//设置每个标签的属性
        {
            lb[i]=new JLabel("标签"+(i+1),JLabel.CENTER);
            //设置标签颜色
            lb[i].setBackground(Color.blue);
            //设置标签边框
            lb[i].setBorder(BorderFactory.createEmptyBorder());
            //让组件变得不透明，使标签颜色显示出来
        }
        //加载第0,1,2个标签在面板上
        pa1.add(lb[0]);
        pa2.add(lb[1],BorderLayout.NORTH);
        pa2.add(lb[2],BorderLayout.SOUTH);
        add(pa1);//pa1的对象添加到cc的对象中
        add(pa2);
        setTitle("JPanelDemo");
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        C10_7 cc=new C10_7();
    }
}
