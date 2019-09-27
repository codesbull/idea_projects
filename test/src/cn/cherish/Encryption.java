package cn.cherish;
import java.util.Scanner;
public class Encryption {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入一个字符串或解密字符串");
        //获取用户输入
        String password=scan.nextLine();
        //获取字符数组
        char[] array=password.toCharArray();
        //遍历字符数组
        for(int i=0;i<array.length;i++){
            //对每个数组元素进行异或运算
            array[i]=(char)(array[i]^20000);
        }
        System.out.println("加密或解密结果如下：");
        //输出密钥
        System.out.println(new String(array));
    }
}
