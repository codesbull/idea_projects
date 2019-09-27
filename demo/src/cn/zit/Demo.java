package cn.zit;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*JTextField文本框未输入时，在文本框上的提示信息颜色设置为灰色，
点击文本框时，提示信息消失，输入的字体颜色变成黑色，
再次点击时，输入的信息不会被清空。
 */
public class Demo extends JFrame {
    private static final long serialVersion=1L;
    private JTextField IDText;
    private JTextField CardText;
    private JLabel IDNumber;
    private JLabel CardNumer;
    private JButton ConfirmButton;
    private JButton ResetButton;

    public Demo(){
        getContentPane().setLayout(null);

        IDNumber=new JLabel("身份证号码");
        IDNumber.setFont(new Font("宋体",Font.BOLD,18));
        IDNumber.setBounds(96,66,95,18);

        CardNumer=new JLabel("银行卡号码");
        CardNumer.setFont(new Font("宋体",Font.BOLD,18));
        CardNumer.setBounds(96,103,95,18);

        IDText=new JTextField("身份证号码");
        IDText.setToolTipText("身份证号码");
        IDText.setBounds(204,65,132,24);
        IDText.setColumns(10);
        IDText.setForeground(Color.lightGray);//设置前景色为灰色
        IDText.setEditable(false);//设置为不可编辑状态
        IDText.setBackground(Color.WHITE);//设置背景色为白色
        IDText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //点击输入框去除文字，激活文本框
                if(e.getButton()==MouseEvent.BUTTON1){
                    if(!IDText.isEnabled()){
                        IDText.setText("");
                        IDText.setForeground(Color.BLACK);
                        IDText.setEditable(true);
                        IDText.requestFocus();
                    }
                }
            }
        });

        CardText=new JTextField("银行卡号码");
        CardText.setToolTipText("银行卡号码");
        CardText.setBounds(204,102,132,24);
        CardText.setColumns(10);
        CardText.setForeground(Color.lightGray);//设置前景色为灰色
        CardText.setEditable(false);//设置为不可编辑状态
        CardText.setBackground(Color.WHITE);//设置背景色为白色
        CardText.addMouseListener(new MouseAdapter() {
            @Override
            //点击输入框去除文字，激活文本框
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON1){
                    if (!CardText.isEnabled()){
                        CardText.setText("");
                        CardText.setForeground(Color.BLACK);
                        CardText.setEditable(true);
                        CardText.requestFocus();
                    }
                }
            }
        });

        ConfirmButton=new JButton("确认");
        ConfirmButton.setFont(new Font("宋体",Font.BOLD,18));
        ConfirmButton.setBounds(96,148,113,27);

        ResetButton=new JButton("重置");
        ResetButton.setFont(new Font("宋体",Font.BOLD,18));
        ResetButton.setBounds(223,148,113,27);
        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IDText.setForeground(Color.lightGray);
                CardText.setText("身份证号码");
                CardText.setText("银行卡卡号");
                IDText.setEditable(false);
                CardText.setEditable(false);
            }
        });

        getContentPane().add(IDNumber);
        getContentPane().add(IDText);
        getContentPane().add(CardNumer);
        getContentPane().add(CardText);
        getContentPane().add(ConfirmButton);
        getContentPane().add(ResetButton);

        setLocationRelativeTo(null);//窗口居中
        setTitle("Demo");
        setVisible(true);
        setSize(450,301);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Demo();
    }
}
