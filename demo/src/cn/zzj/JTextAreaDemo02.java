package cn.zzj;

import javax.swing.*;
import java.awt.*;

public class JTextAreaDemo02 {
    public static void main(String args[])
    {
        JFrame frame = new JFrame("文本域中加入滚动条");

        JTextArea jtextarea = new JTextArea(3, 10); // 设置大小
        JLabel lab = new JLabel("多行文本域：");
        //在有带滚动条的面板中设置文本域，并设置垂直滚动条，垂直滚动条。
        JScrollPane scr = new JScrollPane(jtextarea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.setLayout(new GridLayout(1, 2));
        frame.add(lab);
        frame.add(scr);
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
    }

}
