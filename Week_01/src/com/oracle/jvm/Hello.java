package com.oracle.jvm;

/**
 * 作业1
 * Created by xfx on 2021/1/9 17:06
 */
public class Hello {
    private static int abc=10;
    private final static float fl = 12.5f;
    public static double dou = 12.232d;
    public static int[] iii = new int[]{5,2,3};
    public static void main(String[] args){
        FourCalculate four = new FourCalculate();
        for(int i:iii) {
            abc = four.plus(i);
            abc = four.multiply(2);
            abc = four.subtract(5);
            double d =  four.divide(3);
            System.out.println(d);
        }
    }
}
class FourCalculate{
    private int count = 0;
    private double result =0.0d;
    public int plus(int a){
        count = count+a;
        return count ;
    }
    public int subtract(int a){
        count = count-a;
        return count ;
    }
    public int multiply(int a){
        count = count*a;
        return count ;
    }
    public double divide(int a){
        if(a==0){
            System.out.println("b is not can be zero!!!");
            return count;
        }else{
            result = count/a;
            return result;
        }
    }
}
