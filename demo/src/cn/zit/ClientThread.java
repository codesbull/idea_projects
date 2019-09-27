package cn.zit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientThread  extends Thread {
    private Socket socket;
    private Client client;
    private BufferedReader br;
    private PrintWriter pw;
    /**
     * 从过主线程传入的socket和client对象来构造
     * @param socket
     * @param client
     */
    public ClientThread(Socket socket, Client client){
        this.client = client;
        this.socket = socket;
        try {
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            System.out.println("cannot get inputstream from socket.");
        }
    }

    /**
     * 不断的读数据并处理
     * 调用主线程的方法来处理：client.method();
     */
    public void run() {
        try{
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String msg = br.readLine();
                parseMessage(msg);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 处理从服务器收到的消息
     * @param message
     */
    public void parseMessage(String message){
        String code = null;
        String msg=null;
        /*
         * 先用正则表达式匹配code码和msg内容
         */
        if(message.length()>0){
            Pattern pattern = Pattern.compile("<code>(.*)</code>");
            Matcher matcher = pattern.matcher(message);
            if(matcher.find()){
                code = matcher.group(1);
            }
            pattern = Pattern.compile("<msg>(.*)</msg>");
            matcher = pattern.matcher(message);
            if(matcher.find()){
                msg = matcher.group(1);
            }
            System.out.println(code+":"+msg);
            switch(code){
                case "1":   /*一个普通消息处理*/
                    client.updateTextArea(msg);
                    break;
                case "2":   /*退出消息*/
                    client.showEscDialog(msg);
                    break;
                case "3":   /*列出房间*/
                    client.listRooms(msg);
                    break;
                case "4":   /*其他用户的消息*/
                    client.updateTextAreaFromUser(msg);
                    break;
                case "5":   /*普通消息处理*/
                    client.updateTextArea(msg);
                    break;
                case "11":  /*添加用户*/
                    client.addUser(msg);
                    break;
                case "12":  /*删除用户*/
                    client.delUser(msg);
                    break;
                case "13":  /*删除房间*/
                    client.delRoom(msg);
                    break;
                case "15":  /*添加房间*/
                    client.addRoom(msg);
                    break;
                case "16":  /*更新用户名称*/
                    client.updateUser(msg);
                    break;
                case "21":  /*列出用户列表*/
                    client.listUsers(msg);
                    break;
            }
        }
    }
}
