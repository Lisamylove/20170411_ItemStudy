package xixinxin.bawie.com.studydemoyunifang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import xixinxin.bawie.com.studydemoyunifang.R;

public class ViewPagerActivity extends AppCompatActivity {

    private WebView wb_viewpager;
    private String url;
    private ProgressBar viewpager_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Intent it=getIntent();
        url = it.getStringExtra("url");
        initView();//找控件
        setWebView();
    }

    private void initView() {
        wb_viewpager = (WebView) findViewById(R.id.wb_viewpager);
        viewpager_progress = (ProgressBar) findViewById(R.id.viewpager_progress);
    }

    private void setWebView() {
        WebSettings settings = wb_viewpager.getSettings();
        //设置webView属性  能执行javascript脚本
        settings.setJavaScriptEnabled(true);
        //设置可以访问文件
        settings.setAllowFileAccess(true);
        //设置可以支持缩放
        settings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        wb_viewpager.loadUrl(url);
        wb_viewpager.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress==100){
                    //加载完进度条消失
                    viewpager_progress.setVisibility(View.GONE);
                }else{
                    //开始加载网页时显示进度条
                    viewpager_progress.setVisibility(View.VISIBLE);
                    viewpager_progress.setProgress(newProgress);//设置进度值
                }
            }
        });
    }
}
