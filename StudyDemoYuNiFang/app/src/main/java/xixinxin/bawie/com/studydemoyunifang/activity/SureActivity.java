package xixinxin.bawie.com.studydemoyunifang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xixinxin.bawie.com.studydemoyunifang.R;

public class SureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sure);
        initView();//找控件
    }

    private void initView() {
        findViewById(R.id.iv_sure);
    }
}
