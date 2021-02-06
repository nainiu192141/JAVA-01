package com.nainiu192141.example.synchexample;

/**
 * Created by xfx on 2021/2/2 11:08
 */
public class SyncCounter {
    private int sum =0;
    public synchronized  int incrAndGet(){//阻塞其他线程执行该方法
        return ++sum;
    }
    public int addAndGet(){
        synchronized (this){//阻塞其他线程执行该代码块
            return ++sum;
        }
    }
    public int getSum(){
        return sum;
    }
}
