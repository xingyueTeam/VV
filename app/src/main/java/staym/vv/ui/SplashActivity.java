package staym.vv.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

import staym.vv.R;

/**
 * Created by xx on 2017/7/5.
 * 引导页
 */

public class SplashActivity extends AhoyOnboarderActivity {

    public static final String JSONCACHE = "sp_configure";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = getSharedPreferences(JSONCACHE, Context.MODE_PRIVATE);
        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("QQ", "腾讯厉害", R.drawable.qq);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("微博", "微博更吊", R.drawable.weibo);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("微信", "微信无敌", R.drawable.weixin);

        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);

        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);


        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.grey_200);
            page.setTitleTextSize(dpToPixels(12, this));
            page.setDescriptionTextSize(dpToPixels(8, this));
        }
        setFinishButtonTitle("Finish");
        showNavigationControls(true);
        setGradientBackground();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setFinishButtonDrawableStyle(ContextCompat.getDrawable(this, R.drawable.rounded_button));
        }

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        setFont(face);

        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {
        sp.edit().putBoolean("isFirstUse", false).commit();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
