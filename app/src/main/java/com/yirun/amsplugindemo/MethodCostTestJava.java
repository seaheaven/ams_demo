package com.yirun.amsplugindemo;

import android.util.Log;

public class MethodCostTestJava {
    public void test(){

    }
    public void test1(){
        long startTime = System.currentTimeMillis();
        long costTime = System.currentTimeMillis() - startTime;
        Log.e("MethodTime", "cost time:" + costTime);
    }

    public void test2(){
        long startTime = System.currentTimeMillis();
        long costTime = System.currentTimeMillis() - startTime;
        if(costTime >= 10){
            Log.e("MethodTime", "cost time:" + costTime);
        }
    }

    public void test3(){
        long startTime = System.currentTimeMillis();
        long costTime = System.currentTimeMillis() - startTime;
        if(costTime >= 10){
            Log.e("MethodTime", "cost time:" + costTime);
        }else if(costTime >= 1){
            Log.v("MethodTime", "cost time:" + costTime);
        }
    }

    public void test4(){
        long startTime = System.currentTimeMillis();

        long costTime = System.currentTimeMillis() - startTime;
//        String thread = Thread.currentThread().getName();
        long thread = Thread.currentThread().getId();
        if(costTime >= 50){
            Log.e("MethodTime", "thread:" + thread + "_,cost time:" + costTime);
        }else if(costTime >= 20){
            Log.w("MethodTime", "thread:" + thread + "_,cost time:" + costTime);
        }else if(costTime >= 10){
            Log.i("MethodTime", "thread:" + thread + "_,cost time:" + costTime);
        }else if(costTime >= 5){
            Log.d("MethodTime", "thread:" + thread + "_,cost time:" + costTime);
        }else if(costTime >= 1){
            Log.v("MethodTime", "thread:" + thread + "_,cost time:" + costTime);
        }
    }
}
