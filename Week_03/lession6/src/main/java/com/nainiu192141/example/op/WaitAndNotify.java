package com.nainiu192141.example.op;

/**
 * Created by xfx on 2021/2/2 14:49
 *
 * @author 86134
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        MethodClass methodClass = new MethodClass();
        Thread t1 = new Thread(()->{
            try{
                methodClass.produce();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        },"t1");

        Thread t2 = new Thread(()->{
           try {
                methodClass.customer();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}

class MethodClass{
    private final int MAX_COUNT=20;
    int productCount = 0;

    public synchronized void produce() throws InterruptedException {
        while (true){
            System.out.println(Thread.currentThread().getName() + ":::run:::" + productCount);
            Thread.sleep(10);
            if (productCount>=MAX_COUNT){
                System.out.println("货仓已满，，，不能再生产");
                wait();
            }else{
                productCount++;
            }
            notifyAll();
        }
    }

    public synchronized void customer() throws InterruptedException {
        while (true){
            System.out.println(Thread.currentThread().getName()+":::run:::"+productCount);
            Thread.sleep(10);
            if(productCount<=0){
                System.out.println("货仓已无货，，，无法消费");
                wait();
            }else{
                productCount--;
            }
            notifyAll();
        }
    }
}
