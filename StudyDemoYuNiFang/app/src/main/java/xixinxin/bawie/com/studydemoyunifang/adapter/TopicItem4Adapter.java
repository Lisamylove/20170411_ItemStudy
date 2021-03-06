package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.activity.SubjectActivity;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/16 19:48
 */
public class TopicItem4Adapter extends RecyclerView.Adapter {
    private Context context;
    private FirstPageBean.DataBean.SubjectsBean data;

    public TopicItem4Adapter(Context context, FirstPageBean.DataBean.SubjectsBean subjectsBean) {
        this.context = context;
        this.data = subjectsBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = View.inflate(context, R.layout.hotadapter, null);
            MyViewHolder1 viewHolder1 = new MyViewHolder1(view);
            return viewHolder1;
        } else {
            View view = View.inflate(context, R.layout.hot2adapter, null);
            MyViewHolder2 viewHolder2 = new MyViewHolder2(view);
            return viewHolder2;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder1) {
            ((MyViewHolder1) holder).tv_hot3.setText("￥" + data.getGoodsList().get(position).getMarket_price());
            ((MyViewHolder1) holder).tv_hot3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            ((MyViewHolder1) holder).tv_hot2.setText("￥" + data.getGoodsList().get(position).getShop_price());
            ((MyViewHolder1) holder).tv_hot1.setText(data.getGoodsList().get(position).getGoods_name());
            Picasso.with(context).load(data.getGoodsList().get(position).getGoods_img()).into(((MyViewHolder1) holder).iv_hot1);
        } else if (holder instanceof MyViewHolder2){
            ((MyViewHolder2) holder).iv_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it=new Intent(context, SubjectActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("data",data);
                    it.putExtras(bundle);
                    context.startActivity(it);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.getShow_number() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == data.getShow_number()) {
            return 2;
        } else {
            return 1;
        }
    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView iv_hot1;
        private final TextView tv_hot1;
        private final TextView tv_hot2, tv_hot3;

        public MyViewHolder1(View itemView) {
            super(itemView);
            iv_hot1 = (ImageView) itemView.findViewById(R.id.iv_hot1);
            tv_hot1 = (TextView) itemView.findViewById(R.id.tv_hot1);
            tv_hot2 = (TextView) itemView.findViewById(R.id.tv_hot2);
            tv_hot3 = (TextView) itemView.findViewById(R.id.tv_hot3);
        }
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        private final ImageView iv_more;

        public MyViewHolder2(View itemView) {
            super(itemView);
            iv_more = (ImageView) itemView.findViewById(R.id.iv_more);
        }
    }
}
