package cn.cherish;

public class B extends A {
    String nameB = "llyB";
    @Override
    protected void getName() {
        System.out.println("子类getName->"+nameB);
        super.getName();
    }
    public static void main(String[] args) {
        B b = new B();
        b.getName();
    }
}