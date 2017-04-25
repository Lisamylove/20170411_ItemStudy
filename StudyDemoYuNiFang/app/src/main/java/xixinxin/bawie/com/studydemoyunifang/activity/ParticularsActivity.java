package xixinxin.bawie.com.studydemoyunifang.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.adapter.ParticularsViewPagerAdapter;
import xixinxin.bawie.com.studydemoyunifang.bean.ParticularsBean;

public class ParticularsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp;
    private ParticularsBean particularsBean;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String data = (String) msg.obj;
                Gson gson = new Gson();
                particularsBean = gson.fromJson(data, ParticularsBean.class);
                tv_particulars.setText(particularsBean.getData().getGoods().getGoods_name());
                tv_price.setText("￥ " + particularsBean.getData().getGoods().getShop_price());
                tv_par_markprice.setText("￥ " + particularsBean.getData().getGoods().getMarket_price());
                tv_par_markprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                tv_par_fee.setText("￥ " + particularsBean.getData().getGoods().getShipping_fee());
                tv_volumn.setText("" + particularsBean.getData().getGoods().getSales_volume());
                tv_collect_count.setText("" + particularsBean.getData().getGoods().getCollect_count());
                tv_par_99.setText(particularsBean.getData().getActivity().get(0).getTitle());
                tv_par_69.setText(particularsBean.getData().getActivity().get(1).getTitle());
                tv_par_time.setText(particularsBean.getData().getActivity().get(2).getTitle());
                vp.setAdapter(new ParticularsViewPagerAdapter(ParticularsActivity.this, particularsBean));
            }
        }
    };
    private TextView tv_particulars, tv_par_99, tv_par_69;
    private TextView tv_price;
    private TextView tv_par_markprice, tv_par_time;
    private TextView tv_par_fee, tv_volumn, tv_collect_count;
    private String id;
    private ImageView iv_back, iv_pop;
    private TextView tv_add_cart;
    private TextView tv_repertory_pop, tv_number, tv_price_pop;
    private ImageView pw_jiaimg;
    private ImageView pw_jianimg;
    private RelativeLayout pw_jia;
    private RelativeLayout pw_jian;
    private TextView pw_num;
    private Button pw_queding;
    private PopupWindow popupWindow;
    private TextView tv_buy;
    private ParticularsBean.DataBean.GoodsBean goods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
        //去头
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        initView();//找控件
        initData();
    }

    private void initData() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://m.yunifang.com/yunifang/mobile/goods/detail?random=46389&encode=70ed2ed2facd7a812ef46717b37148d6&id=" + id;
        //创建request对象
        Request request = new Request.Builder().url(url).build();
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

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_par_99 = (TextView) findViewById(R.id.tv_par_99);
        tv_par_time = (TextView) findViewById(R.id.tv_par_time);
        tv_par_69 = (TextView) findViewById(R.id.tv_par_69);
        tv_collect_count = (TextView) findViewById(R.id.tv_collect_count);
        tv_volumn = (TextView) findViewById(R.id.volumn);
        tv_par_fee = (TextView) findViewById(R.id.tv_par_fee);
        tv_par_markprice = (TextView) findViewById(R.id.tv_par_markprice);
        tv_price = (TextView) findViewById(R.id.tv_par_price);
        tv_particulars = (TextView) findViewById(R.id.tv_particulars);
        tv_add_cart = (TextView) findViewById(R.id.tv_add_cart);
        tv_buy = (TextView) findViewById(R.id.tv_buy);
        tv_buy.setOnClickListener(this);
        tv_add_cart.setOnClickListener(this);
        vp = (ViewPager) findViewById(R.id.vp_particulars);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add_cart:
//                Toast.makeText(ParticularsActivity.this, "22", Toast.LENGTH_SHORT).show();
                boolean flag =RegisterActivity.isLogin;
                if (flag) {
                    initpopupwindow();
                    if (popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    } else {
                        popupWindow.showAtLocation(tv_add_cart, Gravity.BOTTOM, 0, 0);
                    }
                } else {
                    Intent intent = new Intent(ParticularsActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.tv_buy:
                Intent intent=new Intent(ParticularsActivity.this,SureActivity.class);
                goods = particularsBean.getData().getGoods();
                intent.putExtra("image",goods.getGoods_img());
                intent.putExtra("name",goods.getGoods_name());
                intent.putExtra("price",goods.getShop_price());
                intent.putExtra("number",pw_num.getText().toString());
                startActivity(intent);
                break;
        }
    }

    private void initpopupwindow() {
        View view = getLayoutInflater().inflate(R.layout.layout_popupwindow, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        //获取popupwindow布局中的id
        iv_pop = (ImageView) view.findViewById(R.id.iv_pop);
        tv_price_pop = (TextView) view.findViewById(R.id.tv_price_pop);
        tv_repertory_pop = (TextView) view.findViewById(R.id.tv_repertory_pop);
        tv_number = (TextView) view.findViewById(R.id.tv_number);
        pw_jiaimg = (ImageView) view.findViewById(R.id.pw_jiaimg);
        pw_jianimg = (ImageView) view.findViewById(R.id.pw_jianimg);
        pw_jia = (RelativeLayout) view.findViewById(R.id.pw_jia);
        pw_jian = (RelativeLayout) view.findViewById(R.id.pw_jian);
        pw_num = (TextView) view.findViewById(R.id.pw_num);
        pw_queding = (Button) view.findViewById(R.id.pw_queding);
        Picasso.with(this).load(particularsBean.getData().getGoods().getGoods_img()).into(iv_pop);
        tv_price_pop.setText("￥ " + particularsBean.getData().getGoods().getShop_price());
        tv_repertory_pop.setText("库存" + particularsBean.getData().getGoods().getStock_number() + "件");
        tv_number.setText("限购" + particularsBean.getData().getGoods().getRestrict_purchase_num() + "件");
        pw_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a =  Integer.parseInt(pw_num.getText().toString());
                if (a < particularsBean.getData().getGoods().getRestrict_purchase_num()) {
                    a++;
                    pw_jiaimg.setImageResource(R.mipmap.add_able);
                    pw_jianimg.setImageResource(R.mipmap.reduce_able);
                } else {
                    pw_num.setText(a + "");
                    pw_jiaimg.setImageResource(R.mipmap.add_unable);
                    pw_jianimg.setImageResource(R.mipmap.reduce_able);
                }
            }
        });
        pw_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(pw_num.getText().toString());
                if (a > 1) {
                    a--;
                    pw_jiaimg.setImageResource(R.mipmap.add_able);
                    pw_jianimg.setImageResource(R.mipmap.reduce_able);
                } else {
                    pw_num.setText(a + "");
                    pw_jiaimg.setImageResource(R.mipmap.add_able);
                    pw_jianimg.setImageResource(R.mipmap.reduce_unable);
                }
            }
        });
        pw_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://169.254.116.62:8080/bullking1/cart";
                int count = Integer.parseInt(pw_num.getText().toString());
                float price = (float) particularsBean.getData().getGoods().getShop_price();
                String name = particularsBean.getData().getGoods().getGoods_name();
                int UserId = RegisterActivity.id;
                String img = particularsBean.getData().getGoods().getGoods_img();
                //获取请求队列
                RequestQueue queue = Volley.newRequestQueue(ParticularsActivity.this);
                //创建StringRequest
                StringRequest request=new StringRequest(com.android.volley.Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(ParticularsActivity.this, "成功加入购物车", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(ParticularsActivity.this, "加入购物车失败", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }
}
