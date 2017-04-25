package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import xixinxin.bawie.com.studydemoyunifang.bean.ParticularsBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/21 16:07
 */
public class ParticularsViewPagerAdapter extends PagerAdapter{
    private Context context;
    private ParticularsBean list;

    public ParticularsViewPagerAdapter(Context context, ParticularsBean particularsBean) {
        this.context = context;
        this.list = particularsBean;
    }

    @Override
    public int getCount() {
        return list.getData().getGoods().getGallery().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        Picasso.with(context).load(list.getData().getGoods().getGallery().get(position).getNormal_url()).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
