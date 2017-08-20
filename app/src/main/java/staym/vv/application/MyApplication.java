package staym.vv.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.mob.MobApplication;
import com.mob.MobSDK;

/**
 * Created by lingxiao on 2017/8/18.
 */

public class MyApplication extends MobApplication{
    private  static Context mContext;
    private static Handler mHandler;
    private static int mainThreadId;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mHandler = new Handler();
        mainThreadId = android.os.Process.myPid();
        // 通过代码注册你的AppKey和AppSecret
        MobSDK.init(this, "1f8bf5167c671", "b58dfa6c472937772125c97f1b98413e");
    }
    public static Context getContext(){
        return mContext;
    }
    public static Handler getHandler(){
        return mHandler;
    }
    public static int getMainThreadId(){
        return mainThreadId;
    }
}
