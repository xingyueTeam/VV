package staym.vv.base;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import staym.vv.R;

/**
 * Created by lingxiao on 2017/8/12.
 */

public class BaseViewPagerAdapter extends PagerAdapter{
    private String[] mCount;
    public BaseViewPagerAdapter(String[] count){
        this.mCount = count;
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
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(container.getContext(), R.layout.pager_dynamic,null);
        TextView textView = (TextView) view.findViewById(R.id.tv_pager);
        textView.setText(mCount[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
