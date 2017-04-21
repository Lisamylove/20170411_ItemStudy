package xixinxin.bawie.com.studydemoyunifang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.zxing.Result;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.io.IOException;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.activity.MainActivity;
import xixinxin.bawie.com.studydemoyunifang.adapter.FirstPageAdapter;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/13 20:18
*/
public class FirstPageFragment extends Fragment implements View.OnClickListener {

    private ViewPager vp_first;
    private String first_url = "http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String data = (String) msg.obj;
                Gson gson = new Gson();
                FirstPageBean bean = gson.fromJson(data, FirstPageBean.class);
                FirstPageBean.DataBean data1 = bean.getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(new FirstPageAdapter(getActivity(), data1));
            }
        }
    };
    private RecyclerView recyclerView;
    private ImageView iv_ma;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstfragment, null);
        initView(view);//找控件
        initData();
        return view;
    }

    private void initData() {
        //创建okHttpClient对象
        OkHttpClient client = new OkHttpClient();
        //创建request对象
        Request request = new Request.Builder().url(first_url).build();
        //得到Call
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Message message = handler.obtainMessage(0, string);
                message.sendToTarget();
            }
        });
    }

    private void initView(View view) {
        iv_ma = (ImageView) view.findViewById(R.id.iv_erweima);
        iv_ma.setOnClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == getActivity().RESULT_OK) {
//            String result = data.getStringExtra("result");
//            Intent intent = new Intent(getActivity(), WebViewActivity.class);
//            intent.putExtra("result", result);
//            startActivity(intent);
//        }
//    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(getActivity(), CaptureActivity.class);
        startActivity(it);
    }
}
