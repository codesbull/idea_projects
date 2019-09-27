package ChatTwoPackage;
/*
说明：

1.两台计算机一台作为服务端，作为服务端的计算机需要有两个代码。
首先运行服务端的代码，等待客户端机器连接，客户端运行客户端代码后，提示连接成功。就可以发送信息了。

2.运行代码前需要将ip地址改为自己计算机当前的ip地址
（Modem、ISDN、ADSL、有线宽频、小区宽频等方式上网的计算机，每次上网所分配到的IP地址都不相同，这称为动态IP地址）。
如果要用一台计算机充当客户端和服务端，就将ip地址写为：127.0.0.1（127.0.0.1是回送地址，指本地机，一般用来测试使用）。
先运行服务端代码，再运行客户端代码即可。

 */
import java.io.*;
import java.net.*;

public class ChatTwoServer {

    public ChatTwoServer(int port,String name) throws IOException
    {
        ServerSocket server=new ServerSocket(port);//创建seversocket对象，提供tcp连接服务。指定端口port，等待tcp连接。
        System.out.print("正在等待连接，请勿操作！");
        Socket client=server.accept();//创建socket对象，它等待接收客户端的连接。
        new ChatTwoClient(name,client);//实现图形界面。
        server.close();
    }

    public static void main(String[] args) throws IOException {
        new ChatTwoServer(2019,"SQ");

    }

}
