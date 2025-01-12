package com.otherlib.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

public class DeviceUtil {
    @SuppressLint("MissingPermission")
    public static String getDeviceId(Context context) {
        String tac = "";
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (manager.getDeviceId() == null || manager.getDeviceId().equals("")) {
            if (Build.VERSION.SDK_INT >= 23) {
                tac = manager.getDeviceId(0);
            }
        } else {
            tac = manager.getDeviceId();
        }
        return tac;
    }
}
