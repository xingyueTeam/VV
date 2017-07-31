package staym.vv.utils;

import android.util.Log;

import staym.vv.core.BuildCons;

/**
 * 日志管理
 * Created by MooreLi on 2017/7/31.
 */

public class Logs {
    private static boolean isDebug = BuildCons.isDebug;

    private static final String TAG = "VV";

    public static void i(String message) {
        if (isDebug)
            Log.i(TAG, message);
    }

    public static void v(String message) {
        if (isDebug)
            Log.v(TAG, message);
    }

    public static void w(String message) {
        if (isDebug)
            Log.w(TAG, message);
    }

    public static void e(String message) {
        if (isDebug)
            Log.e(TAG, message);
    }

    public static void i(String tag, String message) {
        if (isDebug)
            Log.i(tag, message);
    }

    public static void v(String tag, String message) {
        if (isDebug)
            Log.v(tag, message);
    }

    public static void w(String tag, String message) {
        if (isDebug)
            Log.w(tag, message);
    }

    public static void e(String tag, String message) {
        if (isDebug)
            Log.e(tag, message);
    }
}
