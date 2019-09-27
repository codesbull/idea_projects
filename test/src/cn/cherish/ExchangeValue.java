package cn.cherish;
import java.util.Scanner;
public class ExchangeValue {
    public static void main(String[] args) {
        //创建扫描器
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入变量A的值：");
        //接收第一个变量值
        long A=scan.nextLong();
        System.out.println("请输入变量B的值：");
        //接收第二个变量值
        long B=scan.nextLong();
        System.out.print("A="+A+"\tB="+B);
        System.out.print("\t执行变量互换...\t");
        //执行变量互换
        A=A^B;
        B=B^A;
        A=A^B;
        System.out.println("A="+A+"\tB="+B);
    }
}
