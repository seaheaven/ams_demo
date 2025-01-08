package com.yirun.amsplugindemo;

import android.util.Log;

public class MethodCostTest2 {
    public void test(){
        long startTime = System.currentTimeMillis();
        long costTime = System.currentTimeMillis() - startTime;
        if(costTime >= 10){
            Log.e("MethodTime", "cost time:" + costTime);
        }
    }
}
