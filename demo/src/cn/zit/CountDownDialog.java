package cn.zit;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownDialog {
    private JDialog Dialog;
    private int secends = 11;//倒计时时间
    private JButton ConfirmButton;
    private JButton Cancelbutton;
    private JLabel label;
    private int res = -1;//确认为1，取消为0，关闭为-1

    /**
     * @param jfather
     * @Description: 创建倒计时弹出对话框，并返回点击结果
     * @return 确认为1，取消为0，关闭为-1
     */
    public int showCountDownDialog(JFrame jfather){
        Dialog = new JDialog(jfather, true);//创建一个具有空标题和指定模态的对话框，并以 jfather作为其所有者。
        Dialog.setLayout(null);
        Dialog.pack();
        Dialog.setSize(new Dimension(266, 125));
        Dialog.setLocationRelativeTo(jfather);
        Dialog.setTitle("倒计时开始!");
        Dialog.setResizable(false);

        ConfirmButton = new JButton("确认");
        ConfirmButton.setBounds(14, 44, 99, 27);
        ConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res = 1;
                Dialog.dispose();
            }
        });

        Cancelbutton = new JButton("取消");
        Cancelbutton.setBounds(139, 44, 99, 27);
        Cancelbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res = 0;
                Dialog.dispose();
            }
        });

        label = new JLabel("这是一个倒计时弹出窗口");
        label.setBounds(55, 13, 165, 18);

        Dialog.add(ConfirmButton);
        Dialog.add(Cancelbutton);
        Dialog.add(label);
        //任务调度
        ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
        s.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                secends--;
                String str = "取消(" + String.valueOf(secends) + "秒)";
                Dialog.setTitle("提示: 对话框将在"+secends+"秒后自动关闭");
                if (secends == 0) {
                    res = 0;
                    Dialog.dispose();
                } else {
                    Cancelbutton.setText(str);
                }
            }
        }, 1, 1, TimeUnit.SECONDS);

        Dialog.setVisible(true);//模态下，setVisible要放在添加组件后面
        return res;
    }
}

