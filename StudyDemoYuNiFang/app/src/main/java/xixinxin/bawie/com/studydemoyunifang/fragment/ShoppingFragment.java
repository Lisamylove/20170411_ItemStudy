package xixinxin.bawie.com.studydemoyunifang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xixinxin.bawie.com.studydemoyunifang.R;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/13 20:18
 */
public class ShoppingFragment extends Fragment {

    private TextView tv_shop_chat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoppingfragment, null);
        initView(view);//找控件
        return view;
    }

    private void initView(View view) {
        tv_shop_chat = (TextView) view.findViewById(R.id.tv_shop_chat);
        tv_shop_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fram,new FirstPageFragment());
                transaction.commit();
            }
        });
    }
}
