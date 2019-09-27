package com.company;
import javax.swing.*;
import java.awt.*;

public class C10_2 extends JApplet  {

    Container cp=getContentPane();
    JButton button1,button2,button3;

    public  void init(){

        cp.setLayout(new FlowLayout());
        button1=new JButton("OK");
        button2=new JButton("Open");
        button3=new JButton("Close");
        cp.add(button1);
        cp.add(button2);
        cp.add(button3);

    }
}
