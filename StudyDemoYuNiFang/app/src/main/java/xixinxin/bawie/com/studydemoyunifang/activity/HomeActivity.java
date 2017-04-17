package xixinxin.bawie.com.studydemoyunifang.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import xixinxin.bawie.com.studydemoyunifang.R;
import xixinxin.bawie.com.studydemoyunifang.fragment.ClassityFragment;
import xixinxin.bawie.com.studydemoyunifang.fragment.FirstPageFragment;
import xixinxin.bawie.com.studydemoyunifang.fragment.ShoppingFragment;
import xixinxin.bawie.com.studydemoyunifang.fragment.UserFragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton rb_first_page, rb_classity, rb_shopping, rb_user;
    private FrameLayout fram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();//找控件
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fram, new FirstPageFragment(), "firstFragment");
        fragmentTransaction.commit();
    }

    private void initView() {
        fram = (FrameLayout) findViewById(R.id.fram);
        rb_first_page = (RadioButton) findViewById(R.id.rb_first_page);
        rb_classity = (RadioButton) findViewById(R.id.rb_classity);
        rb_shopping = (RadioButton) findViewById(R.id.rb_shopping);
        rb_user = (RadioButton) findViewById(R.id.rb_user);
        //button按钮监听事件
        rb_first_page.setOnClickListener(this);
        rb_classity.setOnClickListener(this);
        rb_shopping.setOnClickListener(this);
        rb_user.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_first_page:
                ChageFragment(new FirstPageFragment(), "firstFragment");
                break;
            case R.id.rb_classity:
                ChageFragment(new ClassityFragment(), "classityFragment");
                break;
            case R.id.rb_shopping:
                ChageFragment(new ShoppingFragment(), "shoppingFragment");
                break;
            case R.id.rb_user:
                ChageFragment(new UserFragment(), "userFragment");
                break;
        }
    }

    public void ChageFragment(Fragment fragment, String tag) {
        //fragment事务管理   开启事务beginTransaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fram, fragment, tag);//fragment进行替换
        transaction.commit();//提交
    }
}
