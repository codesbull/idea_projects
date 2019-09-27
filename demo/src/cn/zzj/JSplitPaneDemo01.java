package cn.zzj;
/*
JSplitPane的主要功能是分割面板
可以将一个窗体分成两个子窗口，
可以是水平排列也可以是水平排列。

 */

import com.sun.corba.se.impl.protocol.giopmsgheaders.FragmentMessage;

import javax.swing.*;
import java.awt.*;

public class JSplitPaneDemo01 {
    public static void main(String[] args) {
        //实例化窗体对象
        JFrame frm=new JFrame("分割窗口");
        //获取当前窗体的容器对象
        Container cont=frm.getContentPane();
        JSplitPane left_split_right=null;//左右分割
        JSplitPane up_split_down=null;//上下分割
        //左右分割：左标签/右标签
        JLabel leftLabel=new JLabel("左标签");
        JLabel rightLabel=new JLabel("右标签");
        left_split_right=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftLabel,rightLabel);
        //注意：水平分割线是垂直的，垂直分割线是水平的
        left_split_right.setDividerSize(10);//设置左右分割条的分割线大小
        //--------------------------------
        //下标签
        left_split_right.setOneTouchExpandable(true);
        left_split_right.setSize(400,200);
        up_split_down=new JSplitPane(JSplitPane.VERTICAL_SPLIT,left_split_right,new JLabel("下标签"));
        up_split_down.setDividerSize(10);//设置左右分割条分割线大小
        //提供快速展开/折叠功能
        up_split_down.setOneTouchExpandable(true);
        cont.add(up_split_down);
        frm.setSize(400,300);
        frm.setLocation(300,200);
        frm.setVisible(true);

    }
}
