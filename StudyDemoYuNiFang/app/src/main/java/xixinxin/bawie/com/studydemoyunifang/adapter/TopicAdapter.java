package xixinxin.bawie.com.studydemoyunifang.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.activity.SubjectActivity;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/16 20:02
 */
public class TopicAdapter extends BaseAdapter{
    private Context context;
    private FirstPageBean.DataBean data;
    private FirstPageBean.DataBean.SubjectsBean subjectsBean;

    public TopicAdapter(Context context, FirstPageBean.DataBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.getSubjects().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getSubjects().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.topicdapter, null);
            v = new ViewHolder();
            v.iv = (ImageView) convertView.findViewById(R.id.iv_topic);
            v.rv = (RecyclerView) convertView.findViewById(R.id.recyclerView_topic);
            convertView.setTag(v);
        } else {
            v = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(data.getSubjects().get(position).getImage()).into(v.iv);
        v.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, SubjectActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data.getSubjects().get(position));
                it.putExtras(bundle);
                context.startActivity(it);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        v.rv.setLayoutManager(linearLayoutManager);
        subjectsBean = data.getSubjects().get(position);
        v.rv.setAdapter(new TopicItem4Adapter(context, subjectsBean));
        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        RecyclerView rv;
    }
}
