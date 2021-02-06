package com.nainiu192141.example.synchexample;


/**
 * Created by xfx on 2021/2/2 12:14
 */
public class testSyncCounter {
    public static void main(String[] args) {
        testSyncCounter1();

    }
    public static void testSyncCounter1(){
        int loopNUm = 10000;
        SyncCounter counter = new SyncCounter();
        /*IntStream.range(0,loopNUm).parallel().forEach(
                i->counter.incrAndGet());*/
        for(int i=0;i<loopNUm;i++){
            System.out.println(counter.incrAndGet());

        }
//        for(int i=0;i<loopNUm;i++){
//            System.out.println(counter.addAndGet());
//
//        }
    }

}
