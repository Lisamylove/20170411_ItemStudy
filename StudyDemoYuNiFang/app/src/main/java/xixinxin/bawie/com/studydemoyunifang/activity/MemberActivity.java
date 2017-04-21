package xixinxin.bawie.com.studydemoyunifang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.adapter.MemberAdapter;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

public class MemberActivity extends AppCompatActivity {
    private TextView tv_member;
    private ImageView iv_back;
    private ListView lv_member;
    private FirstPageBean.DataBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        initView();//找控件
        Intent it = getIntent();
        bean = (FirstPageBean.DataBean) it.getSerializableExtra("bean");
        Toast.makeText(MemberActivity.this, ""+ bean.getBestSellers().get(0).getGoodsList().size(), Toast.LENGTH_SHORT).show();
        String result = it.getStringExtra("result");
        tv_member.setText(result + "");
        lv_member.setAdapter(new MemberAdapter(MemberActivity.this, bean));
    }

    private void initView() {
        tv_member = (TextView) findViewById(R.id.tv_member);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lv_member = (ListView) findViewById(R.id.lv_member);
    }
}
