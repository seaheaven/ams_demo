package com.yirun.amsplugindemo;

import android.util.Log;

public class MethodCostTest2 {
    public void test(){
        long startTime = System.nanoTime();
        long costTime = System.nanoTime() - startTime;
        Log.d("MethodTime", "cost time:" + costTime);
    }
}
