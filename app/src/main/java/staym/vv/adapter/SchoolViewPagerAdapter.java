package staym.vv.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import staym.vv.R;
import staym.vv.utils.UIUtils;

/**
 * Created by lingxiao on 2017/8/18.
 */

public class SchoolViewPagerAdapter extends PagerAdapter{
    private String[] mTabCont;
    public SchoolViewPagerAdapter(String[] count){
        this.mTabCont = count;
    }
    @Override
    public int getCount() {
        return mTabCont.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(container.getContext(),R.layout.pager_dynamic,null);
        TextView textView = (TextView) view.findViewById(R.id.tv_pager);
        textView.setText(mTabCont[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabCont[position];
    }
}
