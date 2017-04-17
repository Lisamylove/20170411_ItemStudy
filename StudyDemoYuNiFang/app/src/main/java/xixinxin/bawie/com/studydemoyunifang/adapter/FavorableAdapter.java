package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/15 12:57
 */
public class FavorableAdapter extends PagerAdapter {
    private Context context;
    private FirstPageBean.DataBean data;

    public FavorableAdapter(Context context, FirstPageBean.DataBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        Picasso.with(context).load(data.getActivityInfo().getActivityInfoList().get(position % data.getActivityInfo().getActivityInfoList().size()).getActivityImg()).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
