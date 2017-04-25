package xixinxin.bawie.com.studydemoyunifang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import xixinxin.bawie.com.studydemoyunifang.R;

public class ClassityActivity extends AppCompatActivity {

    private GridView grid_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classity);
        initView();
        initData();
    }

    private void initData() {
        String url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=9";
    }

    private void initView() {
        grid_class = (GridView) findViewById(R.id.grid_class);
    }
}
