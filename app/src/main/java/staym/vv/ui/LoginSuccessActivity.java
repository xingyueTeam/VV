package staym.vv.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.transition.Explode;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import staym.vv.R;
import staym.vv.base.BaseActivity;
import staym.vv.adapter.BaseViewPagerAdapter;

/**
 * Created by xx on 2017/7/20.
 * 登陆成功页面
 */

public class LoginSuccessActivity extends BaseActivity {

    @Bind(R.id.bottom_main) BottomNavigationBar bm_bar;
    private BadgeItem badgeItem;
    private String[] itemStr = {"校园动态","酷趣块","首页","VV聊","我"};
    @Bind(R.id.vp_main) ViewPager vp_main;
    private BottomNavigationItem item;
    private BaseViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);

        ButterKnife.bind(this);

        initView();
    }

    /**
     *初始化控件和底部导航栏
     */
    private void initView() {
        item = new BottomNavigationItem(R.mipmap.ic_dynamic,itemStr[0]);
        badgeItem = new BadgeItem();
        bm_bar.addItem(item);
        item = new BottomNavigationItem(R.mipmap.ic_interest,itemStr[1]);
        bm_bar.addItem(item);
        item = new BottomNavigationItem(R.mipmap.ic_home,itemStr[2]);
        bm_bar.addItem(item);
        item = new BottomNavigationItem(R.mipmap.ic_message,itemStr[3]);
        bm_bar.addItem(item);
        item = new BottomNavigationItem(R.mipmap.ic_mine,itemStr[4]);
        bm_bar.addItem(item);
        //bottom总体状态的颜色
        bm_bar.setActiveColor(R.color.colorPrimary);
        //未选中颜色
        bm_bar.setInActiveColor(R.color.colorBottomNav);
        //初始化
        bm_bar.initialise();
        mAdapter = new BaseViewPagerAdapter(itemStr,LoginSuccessActivity.this);
        vp_main.setAdapter(mAdapter);
        bm_bar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                vp_main.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        vp_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bm_bar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
