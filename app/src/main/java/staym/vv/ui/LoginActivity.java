package staym.vv.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import staym.vv.R;
import staym.vv.base.BaseActivity;
import staym.vv.http.UserHttpUtils;
import staym.vv.network.HttpListener;
import staym.vv.network.NetworkManager;
import staym.vv.utils.Logs;

/**
 * Created by xx on 2017/7/20.
 * 登陆页面
 */

public class LoginActivity extends BaseActivity {

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.bt_go)
    Button btGo;
    @Bind(R.id.cv)
    CardView cv;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_go, R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                    startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(this, RegisterActivity.class));
                }
                break;
            case R.id.bt_go:
                /**
                 * 测试访问网络
                 */
                HttpListener listener = new HttpListener() {
                    @Override
                    public void onSuccess(String result, String code, String retMessage) {
                        Logs.e("LoginTest", "success:" + result);
                    }

                    @Override
                    public void onFail(String code, String retMessage) {
                        Logs.e("LoginTest", "failed  code:" + code + "   message:" + retMessage);
                    }
                };
                Logs.e("test","testNetwork");
                UserHttpUtils.test(listener,2,10);

                Explode explode = new Explode();
                explode.setDuration(500);

                getWindow().setExitTransition(explode);
                getWindow().setEnterTransition(explode);
                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                Intent i2 = new Intent(this, LoginSuccessActivity.class);
                startActivity(i2, oc2.toBundle());
                break;
        }
    }
}
