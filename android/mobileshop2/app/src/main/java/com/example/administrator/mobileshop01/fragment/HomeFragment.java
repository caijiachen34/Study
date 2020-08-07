package com.example.administrator.mobileshop01.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.activity.GoodsActivity;
import com.example.administrator.mobileshop01.activity.MainActivity;
import com.example.administrator.mobileshop01.activity.LoginActivity;
import com.example.administrator.mobileshop01.utils.NetworkUtils;
import com.example.administrator.mobileshop01.view.MyWebView;

public class HomeFragment extends BaseFragment{

    public static final String TAG="HomeFragment";
    private MainActivity mainActivity;
    public final int SEARCH_ACTIVITY=1;
    private MyWebView mWebView;
    private SwipeRefreshLayout mswipeRefreshLayout;
    private TextView searchTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home,container,false);
//
//        ImageView imageView=view.findViewById(R.id.testLoadImg);
//        //                          三个参数：图片地址，显示的控件，图片加载设置
//        ImageLoader.getInstance().displayImage("https://w.wallhaven.cc/full/ym/wallhaven-ymoo2x.jpg",
//                imageView,
//                ImageLoaderManager.product_options);
        mainActivity= (MainActivity) getActivity();
        searchTV=view.findViewById(R.id.home_search);
        searchTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"。。。",Toast.LENGTH_SHORT).show();
            }
        });
        
        mWebView=view.findViewById(R.id.webView);
        mswipeRefreshLayout=view.findViewById(R.id.swipe_refresh_layout);
        initMyWebView(view);
        initSwipeRefreshLayout();
        return view;
    }

    @SuppressLint("JavascriptInterface")
    private void initMyWebView(View view) {
        mWebView.setWebViewClient(new JWebViewClient());
        mWebView.addJavascriptInterface(this,"app");
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        WebSettings settings=mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);

        mWebView.setOnCustomScrollChanged(new MyWebView.IWebViewScroll() {
            @Override
            public void toTop() {
                mswipeRefreshLayout.setEnabled(true);
            }

            @Override
            public void notOnTop() {
                mswipeRefreshLayout.setEnabled(true);
            }
        });

        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()== KeyEvent.ACTION_DOWN) {
                    if (keyCode== KeyEvent.KEYCODE_BACK&&mWebView.canGoBack()) {
                        mWebView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                mWebView.loadUrl("file//android_asset/error.html");
                mswipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        mWebView.loadUrl("http://www.apple.com/cn-k12/shop");

    }

    private void initSwipeRefreshLayout(){
        mswipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_green_light,
                android.R.color.holo_orange_light,android.R.color.holo_red_light);
        mswipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (NetworkUtils.isNetworkAvailable(mainActivity)) {
                    mWebView.reload();
                }else{
                    mswipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(mainActivity,"网络不可用",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==SEARCH_ACTIVITY) {

        }
    }

    private class JWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            view.getSettings().setDefaultTextEncodingName("UTF-8");
            super.onReceivedError(view, request, error);
            view.loadDataWithBaseURL("","<div style='padding-top:200px;text-align:center;color:#666;'>未打开无线网络</div>","text/html","UTF-8",null);
        }
    }

    @JavascriptInterface
    public void changeTab(final int index){
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.changeTab(index);
            }
        });
    }

    public void showGoods(final int goodsId){
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.showGoods(goodsId);
            }
        });
    }

    @JavascriptInterface
    public void showGroupbuy(final int goodsId,final int groupbuy_id){
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(mainActivity, GoodsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("goods_id",goodsId);
                intent.putExtra("groupbuy_id",groupbuy_id);
                startActivity(intent);
            }
        });
    }

    @JavascriptInterface
    public void myorder(){
        startActivity(new Intent(mainActivity, LoginActivity.class));
        Toast.makeText(mainActivity,"请先登录后再进行操作！",Toast.LENGTH_SHORT).show();

    }
}
