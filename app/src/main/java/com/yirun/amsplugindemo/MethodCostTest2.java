package com.yirun.amsplugindemo;

import android.util.Log;

public class MethodCostTest2 {
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
        if(costTime >= 500){
            Log.e("MethodTime", "cost time:" + costTime);
        }else if(costTime >= 200){
            Log.w("MethodTime", "cost time:" + costTime);
        }else if(costTime >= 100){
            Log.i("MethodTime", "cost time:" + costTime);
        }else if(costTime >= 10){
            Log.d("MethodTime", "cost time:" + costTime);
        }else if(costTime >= 1){
            Log.v("MethodTime", "cost time:" + costTime);
        }
    }
}
