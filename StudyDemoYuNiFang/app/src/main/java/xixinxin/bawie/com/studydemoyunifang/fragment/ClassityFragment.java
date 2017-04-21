package xixinxin.bawie.com.studydemoyunifang.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.adapter.ClassityRecyclerViewAdapter;
import xixinxin.bawie.com.studydemoyunifang.bean.ClassityBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/13 20:18
 */
public class ClassityFragment extends Fragment {

    private RecyclerView rv_classity;
    private List<ClassityBean.DataBean.GoodsBriefBean> goods;
    private String jsonurl = "http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414";
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String json = (String) msg.obj;
                Gson gson = new Gson();
                ClassityBean bean = gson.fromJson(json, ClassityBean.class);
                goods = bean.getData().getGoodsBrief();
                Log.i("xxx", goods + "");
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                rv_classity.setLayoutManager(layoutManager);
                rv_classity.setAdapter(new ClassityRecyclerViewAdapter(getActivity(),goods));
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classityfragment, null);
        rv_classity = (RecyclerView) view.findViewById(R.id.rv_classity);
        initData();
        return view;
    }

    private void initData() {
        //创建OKHttpClient对象
        OkHttpClient clienet = new OkHttpClient();
        //创建request对象
        Request request = new Request.Builder().url(jsonurl).build();
        //得到Call
        Call call = clienet.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Log.i("xxx", string + "");
                Message message = handler.obtainMessage(0, string);
                message.sendToTarget();
            }
        });
    }

}
