package com.company;

import javax.swing.*;
import java.awt.*;

public class C10_3 extends JApplet {
    JButton s1=new JButton("1");
    JButton s2=new JButton("2");
    JButton s3=new JButton("3");

    Container cp=getContentPane();
    CardLayout card=new CardLayout(20,20);


    public void init() {
        cp.setLayout(card);
        cp.setLayout(card);
        cp.setLayout(card);
       cp.add("a",s1);
       cp.add("b",s2);
       cp.add("c",s3);


    }
}
