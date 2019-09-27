package cn.cherish;
public class Test {
    public static void main(String[] args) {
        //创建对象
        Student stu=new Student("张三","男",20);
        //输出姓名
        System.out.println("姓名："+stu.getName());
        System.out.println("性别："+stu.getSex());
        System.out.println("年龄："+stu.getAge()+"岁");
    }
}
