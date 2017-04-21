package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/20 18:21
 */
public class MemberAdapter extends BaseAdapter {
    private Context context;
    private FirstPageBean.DataBean bean;

    public MemberAdapter(Context context, FirstPageBean.DataBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.getBestSellers().get(0).getGoodsList().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getBestSellers().get(0).getGoodsList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.member, null);
            v = new ViewHolder();
            v.t1 = (TextView) convertView.findViewById(R.id.tv_member_title);
            v.t2 = (TextView) convertView.findViewById(R.id.tv_member_price);
            v.t3 = (TextView) convertView.findViewById(R.id.tv_member_markprice);
            v.iv = (ImageView) convertView.findViewById(R.id.iv_member_image);
            convertView.setTag(v);
        } else {
            v = (ViewHolder) convertView.getTag();
        }
        v.t1.setText(bean.getBestSellers().get(0).getGoodsList().get(position).getGoods_name());
        v.t2.setText("￥ "+bean.getBestSellers().get(0).getGoodsList().get(position).getShop_price());
        v.t3.setText("￥ "+bean.getBestSellers().get(0).getGoodsList().get(position).getMarket_price());
        v.t3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Picasso.with(context).load(bean.getBestSellers().get(0).getGoodsList().get(position).getGoods_img()).into(v.iv);
        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        TextView t1, t2, t3;
    }
}
