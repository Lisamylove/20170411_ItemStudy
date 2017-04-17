package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/16 20:48
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {
    private Context context;
    private FirstPageBean.DataBean data;

    public GridAdapter(Context context, FirstPageBean.DataBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.griditem, null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(data.getDefaultGoodsList().get(position).getGoods_img()).into(holder.image_grid);
        holder.text_title.setText(data.getDefaultGoodsList().get(position).getEfficacy());
        holder.text_goodsname.setText(data.getDefaultGoodsList().get(position).getGoods_name());
        holder.text_price.setText("￥" + data.getDefaultGoodsList().get(position).getShop_price());
        holder.text_market_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.text_market_price.setText("￥" + data.getDefaultGoodsList().get(position).getMarket_price());
    }

    @Override
    public int getItemCount() {
        return data.getDefaultGoodsList().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView text_title, text_goodsname, text_market_price, text_price;
        private final ImageView image_grid;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.text_title);
            text_goodsname = (TextView) itemView.findViewById(R.id.text_goodsname);
            text_market_price = (TextView) itemView.findViewById(R.id.text_market_price);
            text_price = (TextView) itemView.findViewById(R.id.text_price);
            image_grid = (ImageView) itemView.findViewById(R.id.image_grid);
        }
    }
}
