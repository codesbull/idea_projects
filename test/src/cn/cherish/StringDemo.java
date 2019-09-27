package cn.cherish;

import com.sun.org.apache.xpath.internal.SourceTree;

public class StringDemo {
    public static void main(String[] args) {
        String str="hello";
        String str1=new String("hello");
        //System.out.println(str==str1);
        System.out.println(str.equals(str1));
    }
}
