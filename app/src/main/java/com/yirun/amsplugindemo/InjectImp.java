package com.yirun.amsplugindemo;

import android.util.Log;

public class InjectImp {

    /**
     * 次方法被插入到方法的前面
     * @param method 方法名称
     * @return 当前时间
     */
    public static long s(String method){
        return System.currentTimeMillis();
    }

    /**
     * 次方法被插入到方法后面
     * @param startTime 被插入方法开始时间
     * @param method 方法名称
     */
    public static void e(long startTime, String method){
        long thread = Thread.currentThread().getId();
        if(thread != 2){
            return;
        }
        long costTime = System.currentTimeMillis() - startTime;
        //        String thread = Thread.currentThread().getName();
        if(costTime >= 50){
            Log.e("MethodTime", method + " thread:" + thread + "_,cost time:" + costTime);
        }else if(costTime >= 20){
            Log.w("MethodTime", method + " thread:" + thread + "_,cost time:" + costTime);
        }else if(costTime >= 10){
            Log.i("MethodTime", method + " thread:" + thread + "_,cost time:" + costTime);
        }else if(costTime >= 5){
            Log.d("MethodTime", method + " thread:" + thread + "_,cost time:" + costTime);
        }else if(costTime >= 1){
            Log.v("MethodTime", method + " thread:" + thread + "_,cost time:" + costTime);
        }
    }
}
