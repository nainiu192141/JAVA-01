package com.nainiu192141.synchexample;

/**
 * Created by xfx on 2021/2/2 11:08
 */
public class SyncCounter {
    private int sum =0;
    public synchronized  int incrAndGet(){
        return ++sum;
    }
    public int addAndGet(){
        synchronized (this){
            return ++sum;
        }
    }
    public int getSum(){
        return sum;
    }
}
