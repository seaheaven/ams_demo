package com.yirun.amsplugindemo

import android.util.Log

class MethodCostTest4 {
    fun test(){
        val startTime = System.currentTimeMillis()
        Log.d("MethodTime", "cost time:${System.currentTimeMillis() - startTime}")
    }
}