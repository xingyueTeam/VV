package staym.vv.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuguangqiang.cookie.CookieBar;

import staym.vv.R;
import staym.vv.utils.UIUtils;

/**
 * Created by lingxiao on 2017/8/12.
 */

public class BaseViewPagerAdapter extends PagerAdapter{
    private String[] mCount,mTabCont;
    private TabLayout tabLayout;
    private ViewPager vp_school;
    private FloatingActionButton flActionBtn;
    private Activity mActivity;
    public BaseViewPagerAdapter(String[] count,Activity activity){
        this.mCount = count;
        this.mActivity = activity;
    }
    @Override
    public int getCount() {
        return mCount.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {

        View view = null;
        if (position == 0){
            //校园动态
            view = View.inflate(container.getContext(),R.layout.pager_school,null);
            tabLayout = (TabLayout) view.findViewById(R.id.tab_school);
            vp_school = (ViewPager) view.findViewById(R.id.vp_school);
            flActionBtn = (FloatingActionButton) view.findViewById(R.id.floatbtn_school);
            mTabCont = new String[]{"校园动态","作业拍拍","我的动态"};
            for (int i = 0; i < mTabCont.length; i++) {
                tabLayout.addTab(tabLayout.newTab().setText(mTabCont[i]));
            }
            SchoolViewPagerAdapter tabAdapter = new SchoolViewPagerAdapter(mTabCont);
            vp_school.setAdapter(tabAdapter);
            //联动
            tabLayout.setupWithViewPager(vp_school);
            flActionBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new CookieBar.Builder(mActivity)
                            .setTitle("恭喜")
                            .setMessage("妹子发来一条消息")
                            .setBackgroundColor(R.color.colorPrimary)
                            .show();
                }
            });
        }else {
            view = View.inflate(container.getContext(),R.layout.pager_dynamic,null);
            TextView textView = (TextView) view.findViewById(R.id.tv_pager);
            textView.setText(mCount[position]);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
