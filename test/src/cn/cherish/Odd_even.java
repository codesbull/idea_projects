package cn.cherish;

import java.util.Scanner;

public class Odd_even {
    public static void main(String[] args) {
        //创建输入流扫描器
        Scanner scan =new Scanner(System.in);
        System.out.println("请输入一个整数：");
        //获取用户输入的整数
        long number =scan.nextLong();
        String check=(number%2==0)?"这个数是：偶数":"这个数是：奇数";
        System.out.println(check);
    }
}
