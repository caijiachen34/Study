package com.cjc.androidactivitydemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class Skip2BrowserActivity extends Activity {

    private static final String TAG = "Skip2BrowserActivity";
    private Button mbutton_visible;
    private Button mbutton_invisible;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip2browser);
        initView();
        initListener();
    }

    private void initView() {
        mbutton_visible = findViewById(R.id.button_skip2browser_visible);
        mbutton_invisible = findViewById(R.id.button_skip2browser_invisible);
    }


    // cmp=org.chromium.webview_shell/.WebViewBrowserActivity
    private void initListener() {
        //显式意图跳转到浏览器
        mbutton_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Skip2BrowserActivityVisible");
                Intent intent = new Intent();
                //第一种写法
                //intent.setClassName("org.chromium.webview_shell","org.chromium.webview_shell.WebViewBrowserActivity");

                //第二种写法
                ComponentName componentName = new ComponentName("org.chromium.webview_shell","org.chromium.webview_shell.WebViewBrowserActivity");
                intent.setComponent(componentName);

                startActivity(intent);
            }
        });

        //隐式意图跳转到浏览器
        mbutton_invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Skip2BrowserActivityinVisible");
                Intent intent = new Intent();

                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}
