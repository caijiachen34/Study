package com.example.administrator.mobileshop01.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class MyWebView extends WebView {
    private IWebViewScroll mIWebViewScroll;
    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置滚动监听
     * @param l
     * @param t
     * @param oldl
     * @param oldt
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mIWebViewScroll!=null&&t==0){
            mIWebViewScroll.notOnTop();
        }else if (mIWebViewScroll!=null &&t!=0){
            mIWebViewScroll.notOnTop();
        }
    }

    public void setOnCustomScrollChanged(IWebViewScroll listener){
        this.mIWebViewScroll=listener;
    }

    public interface IWebViewScroll{
        void toTop();
        void notOnTop();
    }
}
