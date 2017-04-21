package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.bean.ClassityBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/17 19:03
 */
public class ClassityRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ClassityBean.DataBean.GoodsBriefBean> goods;

    public ClassityRecyclerViewAdapter(Context context, List<ClassityBean.DataBean.GoodsBriefBean> goods) {
        this.context = context;
        this.goods = goods;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = View.inflate(context, R.layout.classityadapter, null);
            MyViewHolder1 myViewHolder1 = new MyViewHolder1(view);
            return myViewHolder1;
        } else if (viewType == 2) {
            View view = View.inflate(context, R.layout.effectadapter, null);
            MyViewHolder2 myViewHolder2 = new MyViewHolder2(view);
            return myViewHolder2;
        } else if (viewType == 3) {
            View view = View.inflate(context, R.layout.skit, null);
            MyViewHolder3 myViewHolder3 = new MyViewHolder3(view);
            return myViewHolder3;
        } else if (viewType == 4) {
            View view = View.inflate(context, R.layout.star, null);
            MyViewHolder4 myViewHolder4 = new MyViewHolder4(view);
            return myViewHolder4;
        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder1) {

        } else if (holder instanceof MyViewHolder2) {

        } else if (holder instanceof MyViewHolder3) {

        } else if (holder instanceof MyViewHolder4) {
            GridLayoutManager drid = new GridLayoutManager(context, 2);
            ((MyViewHolder4) holder).rv_star.setLayoutManager(drid);
            ((MyViewHolder4) holder).rv_star.setAdapter(new StarAdapter(context,goods));
        }
    }

    @Override
    public int getItemCount() {
        return 4;
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
        }
        return 0;
    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder {

        public MyViewHolder1(View itemView) {
            super(itemView);
        }
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        public MyViewHolder2(View itemView) {
            super(itemView);
        }
    }

    public static class MyViewHolder3 extends RecyclerView.ViewHolder {

        private final TextView tv_skit_dry, tv_skit_mixture, tv_skit_neutral, tv_skit_oily, tv_skit_pimple, tv_skit_sensitive;

        public MyViewHolder3(View itemView) {
            super(itemView);
            tv_skit_dry = (TextView) itemView.findViewById(R.id.tv_skit_dry);
            tv_skit_mixture = (TextView) itemView.findViewById(R.id.tv_skit_mixture);
            tv_skit_neutral = (TextView) itemView.findViewById(R.id.tv_skit_neutral);
            tv_skit_oily = (TextView) itemView.findViewById(R.id.tv_skit_oily);
            tv_skit_pimple = (TextView) itemView.findViewById(R.id.tv_skit_pimple);
            tv_skit_sensitive = (TextView) itemView.findViewById(R.id.tv_skit_sensitive);
        }
    }

    public static class MyViewHolder4 extends RecyclerView.ViewHolder {

        private final RecyclerView rv_star;

        public MyViewHolder4(View itemView) {
            super(itemView);
            rv_star = (RecyclerView) itemView.findViewById(R.id.rv_star);
        }
    }

}
