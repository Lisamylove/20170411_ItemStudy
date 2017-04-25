package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.activity.ParticularsActivity;
import xixinxin.bawie.com.studydemoyunifang.activity.WebViewActivity;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/14 18:37
 */
public class FirstPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context context;
    private FirstPageBean.DataBean data1;
    private Handler handler;
    private Hotadapter hotadapter;

    public FirstPageAdapter(Context context, FirstPageBean.DataBean data1) {
        this.context = context;
        this.data1 = data1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = View.inflate(context, R.layout.item1, null);
            final MyViewHolder1 holder1 = new MyViewHolder1(view);
            return holder1;
        } else if (viewType == 2) {
            View view = View.inflate(context, R.layout.item2, null);
            MyVIewHolder2 vIewHolder2 = new MyVIewHolder2(view);
            return vIewHolder2;
        } else if (viewType == 3) {
            View view = View.inflate(context, R.layout.item3, null);
            MyVIewHolder3 vIewHolder3 = new MyVIewHolder3(view);
            return vIewHolder3;
        } else if (viewType == 4) {
            View view = View.inflate(context, R.layout.item4, null);
            MyVIewHolder4 vIewHolder4 = new MyVIewHolder4(view);
            return vIewHolder4;
        } else if (viewType == 5) {
            View view = View.inflate(context, R.layout.item5, null);
            MyVIewHolder5 vIewHolder5 = new MyVIewHolder5(view);
            return vIewHolder5;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder1) {
            ((MyViewHolder1) holder).viewpager.setAdapter(new ViewpagerAdapter(context, data1));
            //重新设置给viewpager
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 0) {
                        int current = ((MyViewHolder1) holder).viewpager.getCurrentItem();
                        ((MyViewHolder1) holder).viewpager.setCurrentItem(current + 1);
                        handler.sendEmptyMessageDelayed(0, 5000);
                    }
                }
            };
            new Thread() {
                @Override
                public void run() {
                    handler.sendEmptyMessageDelayed(0, 5000);
                }
            }.start();
            Picasso.with(context).load(data1.getAd5().get(0).getImage()).into(((MyViewHolder1) holder).iv_day);
            enter((MyViewHolder1) holder);
            Picasso.with(context).load(data1.getAd5().get(1).getImage()).into(((MyViewHolder1) holder).iv_integral);
            Picasso.with(context).load(data1.getAd5().get(2).getImage()).into(((MyViewHolder1) holder).iv_chage);
            Picasso.with(context).load(data1.getAd5().get(3).getImage()).into(((MyViewHolder1) holder).iv_selector);
            ((MyViewHolder1) holder).tv_day.setText(data1.getAd5().get(0).getTitle());
            ((MyViewHolder1) holder).tv_integral.setText(data1.getAd5().get(1).getTitle());
            ((MyViewHolder1) holder).tv_chage.setText(data1.getAd5().get(2).getTitle());
            ((MyViewHolder1) holder).tv_selector.setText(data1.getAd5().get(3).getTitle());
        } else if (holder instanceof MyVIewHolder2) {
            ((MyVIewHolder2) holder).tv_item2.setText("-- " + data1.getBestSellers().get(0).getName() + " --");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
            ((MyVIewHolder2) holder).item2_recyclerView.setLayoutManager(linearLayoutManager);
            hotadapter = new Hotadapter(context, data1);
            ((MyVIewHolder2) holder).item2_recyclerView.setAdapter(hotadapter);
            hotadapter.setOnItemClickListener(new Hotadapter.OnItemClickListener() {
                @Override
                public void OnItemClickListener(View view, int position) {
                    Intent intent=new Intent(context, ParticularsActivity.class);
                    intent.putExtra("id",data1.getBestSellers().get(0).getGoodsList().get(position).getId());
                    context.startActivity(intent);
                }
            });

        } else if (holder instanceof MyVIewHolder3) {
            ((MyVIewHolder3) holder).tv_item2.setText("-- " + "优惠活动" + " --");
            ((MyVIewHolder3) holder).viewpager.setAdapter(new FavorableAdapter(context, data1));
        } else if (holder instanceof MyVIewHolder4) {
            ((MyVIewHolder4) holder).tv_item4.setText("-- " + "热门专题" + " --");
            ((MyVIewHolder4) holder).item4_lv.setAdapter(new TopicAdapter(context, data1));
        } else if (holder instanceof MyVIewHolder5) {
            GridLayoutManager gridView = new GridLayoutManager(context, 2);
            ((MyVIewHolder5) holder).rv.setLayoutManager(gridView);
//            DividerItemDecortion decortion=new DividerItemDecortion(context,2);
//            ((MyVIewHolder5) holder).rv.addItemDecoration(decortion);
            ((MyVIewHolder5) holder).rv.setAdapter(new GridAdapter(context, data1));
        }
    }

    private void enter(MyViewHolder1 holder) {
        holder.iv_day.setOnClickListener(this);
        holder.iv_integral.setOnClickListener(this);
        holder.iv_chage.setOnClickListener(this);
        holder.iv_selector.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_day:
                Intent it = new Intent(context, WebViewActivity.class);
                it.putExtra("result", data1.getAd5().get(0).getAd_type_dynamic_data());
                context.startActivity(it);
                break;
            case R.id.iv_integral:
                Intent it1 = new Intent(context, WebViewActivity.class);
                it1.putExtra("result", data1.getAd5().get(1).getAd_type_dynamic_data());
                context.startActivity(it1);
                break;
            case R.id.iv_chage:
                Intent it2 = new Intent(context, WebViewActivity.class);
                it2.putExtra("result", data1.getAd5().get(2).getAd_type_dynamic_data());
                context.startActivity(it2);
                break;
            case R.id.iv_selector:
                Intent it3 = new Intent(context, WebViewActivity.class);
                it3.putExtra("result", data1.getAd5().get(3).getAd_type_dynamic_data());
                context.startActivity(it3);
                break;
        }
    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final ViewPager viewpager;
        private final ImageView iv_day, iv_integral, iv_chage, iv_selector;
        private final TextView tv_day, tv_integral, tv_chage, tv_selector;

        public MyViewHolder1(View itemView) {
            super(itemView);
            viewpager = (ViewPager) itemView.findViewById(R.id.iv_page);
            iv_day = (ImageView) itemView.findViewById(R.id.iv_day);
            iv_integral = (ImageView) itemView.findViewById(R.id.iv_integral);
            iv_chage = (ImageView) itemView.findViewById(R.id.iv_chage);
            iv_selector = (ImageView) itemView.findViewById(R.id.iv_selector);
            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_integral = (TextView) itemView.findViewById(R.id.tv_integral);
            tv_chage = (TextView) itemView.findViewById(R.id.tv_chage);
            tv_selector = (TextView) itemView.findViewById(R.id.tv_selector);
        }
    }

    public static class MyVIewHolder2 extends RecyclerView.ViewHolder {

        private final TextView tv_item2;
        private final RecyclerView item2_recyclerView;

        public MyVIewHolder2(View itemView) {
            super(itemView);
            item2_recyclerView = (RecyclerView) itemView.findViewById(R.id.item2_recyclerView);
            tv_item2 = (TextView) itemView.findViewById(R.id.tv_item2);
        }
    }

    public static class MyVIewHolder3 extends RecyclerView.ViewHolder {

        private final TextView tv_item2;
        private final ViewPager viewpager;

        public MyVIewHolder3(View itemView) {
            super(itemView);
            viewpager = (ViewPager) itemView.findViewById(R.id.item3_viewpager);
            tv_item2 = (TextView) itemView.findViewById(R.id.tv_item2);
        }
    }

    public static class MyVIewHolder4 extends RecyclerView.ViewHolder {
        private final TextView tv_item4;
        private final ListView item4_lv;

        public MyVIewHolder4(View itemView) {
            super(itemView);
            item4_lv = (ListView) itemView.findViewById(R.id.item4_lv);
            tv_item4 = (TextView) itemView.findViewById(R.id.tv_item4);
        }
    }

    public static class MyVIewHolder5 extends RecyclerView.ViewHolder {

        private final RecyclerView rv;

        public MyVIewHolder5(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.item5_rv);
        }
    }
}
