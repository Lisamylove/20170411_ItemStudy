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
 * 2:时间  2017/4/20 20:35
 */
public class SubjectAdapter extends BaseAdapter {
    private Context context;
    private FirstPageBean.DataBean.SubjectsBean data;

    public SubjectAdapter(Context context, FirstPageBean.DataBean.SubjectsBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.getGoodsList().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getGoodsList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.hotadapter, null);
            v = new ViewHolder();
            v.iv_hot1 = (ImageView) convertView.findViewById(R.id.iv_hot1);
            v.tv_hot1 = (TextView) convertView.findViewById(R.id.tv_hot1);
            v.tv_hot2 = (TextView) convertView.findViewById(R.id.tv_hot2);
            v.tv_hot3 = (TextView) convertView.findViewById(R.id.tv_hot3);
            convertView.setTag(v);
        } else {
            v = (ViewHolder) convertView.getTag();
        }
        v.tv_hot3.setText("￥" + data.getGoodsList().get(position).getMarket_price());
        v.tv_hot3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        v.tv_hot2.setText("￥" + data.getGoodsList().get(position).getShop_price());
        v.tv_hot1.setText(data.getGoodsList().get(position).getGoods_name());
        Picasso.with(context).load(data.getGoodsList().get(position).getGoods_img()).into(v.iv_hot1);
        return convertView;
    }

    class ViewHolder {
        ImageView iv_hot1;
        TextView tv_hot1;
        TextView tv_hot2, tv_hot3;
    }
}
