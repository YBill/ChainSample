package com.bill.chainsample;

import android.content.Context;
import android.view.WindowManager;

public class DeviceHelper {

    public static int getScreenHeight(Context ctx) {

        WindowManager wm = (WindowManager) ctx.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);

        return wm.getDefaultDisplay().getHeight();

    }

    public static int getScreenWidth(Context ctx) {

        WindowManager wm = (WindowManager) ctx.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);

        return wm.getDefaultDisplay().getWidth();

    }
}
