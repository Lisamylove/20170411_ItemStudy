package xixinxin.bawie.com.studydemoyunifang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.activity.RegisterActivity;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/13 20:18
 */
public class UserFragment extends Fragment implements View.OnClickListener {

    private ImageView iv_setting;
    private ImageView iv_head;
    private TextView tv_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.userfragment, null);
        initView(view);//找控件
        return view;
    }

    private void initView(View view) {
        tv_login = (TextView) view.findViewById(R.id.tv_login);
        iv_head = (ImageView) view.findViewById(R.id.iv_head);
        iv_setting = (ImageView) view.findViewById(R.id.iv_setting);
        iv_setting.setOnClickListener(this);
        iv_head.setOnClickListener(this);
        tv_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_setting:
                break;
            case R.id.iv_head:
                Register();
                break;
            case R.id.tv_login:
                Register();
                break;
        }
    }

    private void Register() {
        Intent intent=new Intent(getActivity(), RegisterActivity.class);
        startActivity(intent);
    }
}
