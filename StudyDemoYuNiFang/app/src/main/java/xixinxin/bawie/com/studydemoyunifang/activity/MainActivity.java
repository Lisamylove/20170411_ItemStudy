package xixinxin.bawie.com.studydemoyunifang.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.adapter.MyPageAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private List<Integer> list = new ArrayList<>();
    private Button bt_start;
    private SharedPreferences sha;
    private int time = 3;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (time > 0) {
                    time--;
                    handler.sendEmptyMessageDelayed(0, 1000);
                } else {
                    enter();
                    finish();
                }
            }
        }
    };
    private ImageView iv_gone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//找控件
        sha = getSharedPreferences("congin", MODE_PRIVATE);
        boolean flag = sha.getBoolean("flag", false);
        if (flag) {
            iv_gone.setVisibility(View.VISIBLE);
            handler.sendEmptyMessageDelayed(0, 1000);
        }
        //添加图片
        addImage();
        viewpager.setAdapter(new MyPageAdapter(this, list));
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == list.size() - 1) {
                    bt_start.setVisibility(View.VISIBLE);
                } else {
                    bt_start.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addImage() {
        list.add(R.mipmap.huawei_guidance_1);
        list.add(R.mipmap.huawei_guidance_2);
        list.add(R.mipmap.huawei_guidance_3);
        list.add(R.mipmap.huawei_guidance_5);
        list.add(R.mipmap.xiaomi_guidance_4);
    }

    private void initView() {
        iv_gone = (ImageView) findViewById(R.id.iv_gone);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = sha.edit();
                edit.putBoolean("flag", true);
                edit.commit();
                enter();
            }
        });
    }

    private void enter() {
        Intent it = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(it);
        finish();
    }
}
