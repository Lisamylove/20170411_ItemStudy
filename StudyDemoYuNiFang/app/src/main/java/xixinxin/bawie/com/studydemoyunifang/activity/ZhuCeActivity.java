package xixinxin.bawie.com.studydemoyunifang.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import xixinxin.bawie.com.studydemoyunifang.R;

public class ZhuCeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_name;
    private EditText edit_pwd;
    private Button bt_submit;
    private ImageView zhuce;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String json = (String) msg.obj;
                Intent it = new Intent(ZhuCeActivity.this, RegisterActivity.class);
                startActivity(it);
                finish();
                Toast.makeText(ZhuCeActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();//找控件
    }

    private void initView() {
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_pwd = (EditText) findViewById(R.id.edit_pwd);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        zhuce = (ImageView) findViewById(R.id.iv_back_zhuce);
        zhuce.setOnClickListener(this);
        bt_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_submit:
                String name = edit_name.getText().toString().trim();
                String pwd = edit_pwd.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
                    String url = "http://169.254.116.62:8080/bullking1/register?name=" + name + "&pwd=" + pwd;
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(url).build();
                    Call call = client.newCall(request);//得到call
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(ZhuCeActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(Response response) throws IOException {
                            String string = response.body().string();
                            Message message = handler.obtainMessage(0, string);
                            message.sendToTarget();
                        }
                    });
                } else {
                    Toast.makeText(ZhuCeActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_back_zhuce:
                finish();
                break;
        }
    }
}
