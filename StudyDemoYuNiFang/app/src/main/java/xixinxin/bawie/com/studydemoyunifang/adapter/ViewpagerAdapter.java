package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import xixinxin.bawie.com.studydemoyunifang.activity.ViewPagerActivity;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/14 19:31
 */
public class ViewpagerAdapter extends PagerAdapter {
    private Context context;
    private FirstPageBean.DataBean data1;

    public ViewpagerAdapter(Context context, FirstPageBean.DataBean data1) {
        this.context = context;
        this.data1 = data1;
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
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);
        Picasso.with(context).load(data1.getAd1().get(position % (data1.getAd1().size())).getImage()).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, ViewPagerActivity.class);
                it.putExtra("url", data1.getAd1().get(position % (data1.getAd1().size())).getAd_type_dynamic_data());
                context.startActivity(it);
            }
        });
        container.addView(imageView);
        return imageView;
    }
}
