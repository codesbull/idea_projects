package cn.cherish;
public class Student {
    private String name;
    private String sex;
    private int age;
    public Student(String name,String sex,int age){
        //利用构造方法初始化域
        this.name=name;
        this.sex=sex;
        this.age=age;
    }
    //获得姓名
    public String getName() {
        return name;
    }
    //获得性别
    public String getSex() {
        return sex;
    }
    //获得年龄
    public int getAge() {
        return age;
    }
}
