package xixinxin.bawie.com.studydemoyunifang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.io.Serializable;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.adapter.SubjectAdapter;
import xixinxin.bawie.com.studydemoyunifang.bean.FirstPageBean;

public class SubjectActivity extends AppCompatActivity {

    private GridView gv_subject;
    private  FirstPageBean.DataBean.SubjectsBean data;
    private TextView tv_subject_title, tv_subject_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        Intent it = getIntent();
        data = (FirstPageBean.DataBean.SubjectsBean) it.getSerializableExtra("data");
        initView();//找控件
        tv_subject_title.setText("#" + data.getTitle() + "#");
        tv_subject_detail.setText(data.getDetail());
        gv_subject.setAdapter(new SubjectAdapter(this, data));
    }

    private void initView() {
        tv_subject_detail = (TextView) findViewById(R.id.tv_subject_detail);
        tv_subject_title = (TextView) findViewById(R.id.tv_subject_title);
        gv_subject = (GridView) findViewById(R.id.gv_subject);
    }
}
