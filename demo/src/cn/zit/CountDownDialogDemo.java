package cn.zit;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class CountDownDialogDemo extends JFrame{

    private static final long serialVersionUID = 1L;
    private JButton Button;
    int res;
    public CountDownDialogDemo(){
        Button = new JButton("点我弹出倒计时窗口");
        Button.setToolTipText("点我弹出倒计时窗口");
        Button.setFont(new Font("宋体", Font.BOLD, 18));
        Button.setBounds(111, 111, 229, 27);
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				/*CountDownFrame cdf = new CountDownFrame();
				cdf.showCountDownFrame(Demo.this);*/
                CountDownDialog cdd = new CountDownDialog();
                res = cdd.showCountDownDialog(CountDownDialogDemo.this);
                System.out.println("返回结果=="+res);
            }
        });

        getContentPane().setLayout(null);
        getContentPane().add(Button, BorderLayout.CENTER);
        // 第一种窗口居中方式
        //Demo.this.setLocationRelativeTo(null);
        // 第二种窗口居中方式
        //得到显示器屏幕的宽、高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        // 得到窗体的宽、高
        int windowsWidth = this.getWidth();
        int windowsHeight = this.getHeight();
        //System.out.println(windowsWidth+","+windowsHeight);
        CountDownDialogDemo.this.setBounds((width - windowsWidth) / 2,(height - windowsHeight) / 2, windowsWidth, windowsHeight);

        setTitle("Demo");
        setVisible(true);
        setSize(450, 301);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new CountDownDialogDemo();
    }
}
