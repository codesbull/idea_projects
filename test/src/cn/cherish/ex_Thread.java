package cn.cherish;
import jdk.nashorn.internal.ir.CatchNode;
import java.util.Calendar;

class ex_Thread extends Thread{
     int pauseTime;
     String name;
     public ex_Thread(int hTime,String hStr){
         pauseTime=hTime;
         name=hStr;
     }
      public void run(){
         Calendar now;//Calendar是Java系统提供的日期时间类的类型标识符
         int year,month,data,hour,minute,secend;
         for (int i=1;i<10;i++){
             try {
                 now=Calendar.getInstance();//取系统时间
                 year=now.get(Calendar.YEAR);//取年
                 month=now.get(Calendar.MONTH)+1;//取月
                 data=now.get(Calendar.DATE);//取日期值
                 hour=now.get(Calendar.HOUR_OF_DAY);//取小时值
                 minute=now.get(Calendar.MINUTE);//取分
                 secend=now.get(Calendar.SECOND);//取秒

                 //显示时间
                 System.out.println(" "+name+"时间:"+year+"年"+month+"月"+data+"日"+hour+"小时"+minute+"分"+secend+"秒");
                 Thread.sleep(pauseTime);
             }catch (Exception e){
                 System.out.println("线程错误"+e);
             }
         }
     }
      public static void main(String args[]){
         //A线程执行一次后睡眠2000毫秒
         ex_Thread myThread1=new ex_Thread(2000,"线程A");
         myThread1.start();

         //B线程执行一次后睡眠1000毫秒
         ex_Thread myThread2=new ex_Thread(1000,"线程B");
         myThread2.start();
     }
}
