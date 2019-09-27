package cn.cherish;
class ThreadPriority{
    public static void main(String[] args) {
        Thread first=new myThread("A线程");//创建A线程
        first.setPriority(Thread.MIN_PRIORITY);//设置A线程优先级为1
        Thread second=new myThread("B线程");//创建B线程
        second.setPriority(Thread.NORM_PRIORITY+1);//设置B线程优先级为6
        Thread third=new myThread("C线程");//创建C线程
        third.setPriority(Thread.MAX_PRIORITY);//设置C线程优先级为10

        first.start();
        second.start();
        third.start();
    }
}
 class myThread extends Thread {
    String message;
    myThread(String message){
        this.message=message;
    }
    public void run(){
        for (int i=0;i<2;i++)
            System.out.println(message+" "+getPriority());
    }
}
