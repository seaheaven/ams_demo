package com.yirun.amsplugindemo

import android.util.Log

class MethodCostTestKotlin {
    fun test(){

    }
    fun test1(){
        val startTime = System.currentTimeMillis()
        Log.d("MethodTime", "cost time:${System.currentTimeMillis() - startTime}")
    }
}