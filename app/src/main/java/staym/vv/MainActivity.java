package staym.vv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import staym.vv.ui.LoginActivity;
import staym.vv.ui.SplashActivity;

public class MainActivity extends AppCompatActivity {

    public static final String JSONCACHE = "sp_configure";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences(JSONCACHE, Context.MODE_PRIVATE);
        isFirstInstall();

    }


    /**
     * 判断是否首次安装，如果是打开splash页面，否就打开登陆页面
     */
    private void isFirstInstall() {
        boolean isFirstUse = sp.getBoolean("isFirstUse", true);

//        if (isFirstUse) {
            Intent intent = new Intent(this, SplashActivity.class);
            startActivity(intent);
            finish();
//        } else {
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
        //////
    }
}
