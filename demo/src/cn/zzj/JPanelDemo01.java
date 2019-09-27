package cn.zzj;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo01 {
    public static void main(String[] args) {
        //实例化窗体对象
        JFrame frm = new JFrame("使用面板JPanel容器");
        //准备好了一个面板
        JPanel pan = new JPanel();
        //现在所有的内容都加入到了JPanel之中
        //添加三个标签到面板中
        JLabel label = null;
        for (int i = 0; i < 3; i++) {
            label = new JLabel("标签" + i);
            label.setOpaque(true);
            //设置三原色渐变
            switch (i) {
                case 0:
                    label.setBackground(new Color(0, 0, 255));
                    break;
                case 1:
                    label.setBackground(new Color(0, 255, 0));
                    break;
                case 2:
                    label.setBackground(new Color(255, 0, 0));
                    break;
                default:
                    break;
            }
            pan.add(label);
        }
        //添加三个按钮到面板中
        JButton button = null;
        for (int i = 0; i < 3; i++) {
            button = new JButton("按钮" + i);
            switch (i) {
                case 0:
                    button.setBackground(new Color(0, 0, 255));
                    break;
                case 1:
                    button.setBackground(new Color(0, 255, 0));
                    break;
                case 2:
                    button.setBackground(new Color(255, 0, 0));
                    break;
                default:
                    break;
            }
            pan.add(button);
        }
        //将面板加到窗体上
        frm.add(pan);
        //根据组件自动调整大小
        frm.pack();
        frm.setLocation(300, 300);
        frm.setVisible(true);
    }
}
