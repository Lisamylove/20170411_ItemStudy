package xixinxin.bawie.com.studydemoyunifang.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import xixinxin.bawie.com.studydemoyunifang.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_login;
    private EditText edit_name;
    private EditText edit_pwd;
    public static Boolean isLogin=false;
    public static int id=0;
    Handler handler = new Handler() {

        private SharedPreferences sha;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String json = (String) msg.obj;
                try {
                    String s = (String) new JSONObject(json).get("dataStr");
                    Log.i("xxx", s);
                    if ("login succeed".equals(s)) {
                        isLogin=true;
                        id = new JSONObject(json).getInt("id");
                        Toast.makeText(RegisterActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(RegisterActivity.this, HomeActivity.class);
                        startActivity(it);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "输入的账号不存在", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private TextView tv_register;
    private ImageView iv_login_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();//找控件
    }

    private void initView() {
        iv_login_back = (ImageView) findViewById(R.id.iv_login_back);
        bt_login = (Button) findViewById(R.id.bt_login);
        tv_register = (TextView) findViewById(R.id.tv_register);
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_pwd = (EditText) findViewById(R.id.edit_pwd);
        bt_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        iv_login_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                String name = edit_name.getText().toString().trim();
                String pwd = edit_pwd.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
                    String url = "http://169.254.116.62:8080/bullking1/login?name=" + name + "&&pwd=" + pwd;
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(url).build();
                    Call call = client.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(RegisterActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_register:
                Intent intent = new Intent(RegisterActivity.this, ZhuCeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.iv_login_back:
                finish();
                break;
        }
    }
}
