package xixinxin.bawie.com.studydemoyunifang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import xixinxin.bawie.com.studydemoyunifang.R;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/19 8:57
 */
public class WebViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        Intent intent = getIntent();
        String url = intent.getStringExtra("result");
        WebView webview = (WebView) findViewById(R.id.webview);
        //设置支持JavaScript脚本l
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
    }
}
