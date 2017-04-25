package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.bean.ClassityBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/19 13:59
 */
public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {
    private Context context;
//    private String jsonurl = "http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414";
private ClassityBean.DataBean data;

    public StarAdapter(Context context, ClassityBean.DataBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public StarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.griditem, null);
        StarViewHolder star = new StarViewHolder(view);
        return star;
    }

    @Override
    public void onBindViewHolder(StarViewHolder holder, int position) {
        Picasso.with(context).load(data.getGoodsBrief().get(position).getGoods_img()).into(holder.image_grid);
        holder.text_title.setText(data.getGoodsBrief().get(position).getEfficacy());
        holder.text_goodsname.setText(data.getGoodsBrief().get(position).getGoods_name());
        holder.text_price.setText("￥" + data.getGoodsBrief().get(position).getShop_price());
        holder.text_market_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.text_market_price.setText("￥" + data.getGoodsBrief().get(position).getMarket_price());
    }

    @Override
    public int getItemCount() {
        return data.getGoodsBrief().size();
    }

    public static class StarViewHolder extends RecyclerView.ViewHolder {
        private final TextView text_title, text_goodsname, text_market_price, text_price;
        private final ImageView image_grid;

        public StarViewHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.text_title);
            text_goodsname = (TextView) itemView.findViewById(R.id.text_goodsname);
            text_market_price = (TextView) itemView.findViewById(R.id.text_market_price);
            text_price = (TextView) itemView.findViewById(R.id.text_price);
            image_grid = (ImageView) itemView.findViewById(R.id.image_grid);
        }
    }
}