package cn.zzj;

import javax.swing.*;

public class JText {
    //创建文本行组件，30列
    private JTextField jtf=new JTextField("该文本不可编辑30",30);

    //创建密码文本行组件 ，30列
    private JPasswordField jpf=new JPasswordField("密码文本",30);

    //创建文本区组件，10行，30列
    private JTextArea jta =new JTextArea("您好",10,30);

    //创建滚动窗格，其显示内容是文本区对象
    private JScrollPane jsp =new JScrollPane(jta);

    public void display(){
        //布局
        JFrame f=new JFrame("文本编辑功能窗口");
       f.setBounds(200,150,350,227);
       f.setLayout(null);

       //设置自动换行
        jta.setLineWrap(true);
        jpf.setBounds(20,10,140,20);
        jtf.setBounds(20,40,140,20);
        jsp.setBounds(20,70,160,100);

        //把组件添加到窗口f中
        f.add(jpf);
        f.add(jtf);
        f.add(jsp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        (new JText()).display();
    }
}
