package com.cjc.networkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.networkdemo.adapters.GetTextAdapter2;
import com.cjc.networkdemo.domain.GetTextItem;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by CC
 **/
public class OkHttpActivity extends Activity {

    public static final String BASE_URL = "http://192.168.2.143:9102";
    private static final String TAG = "OkHttpActivity";
    private GetTextAdapter2 textAdapter2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        initView();
    }

    private void initView() {
        textAdapter2 = new GetTextAdapter2();
        RecyclerView recyclerView = findViewById(R.id.result_list_okhttp);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(textAdapter2);
    }

    public void getRequest(View view){
        //客户端
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build();

        //创建连接(请求内容)
        final Request request = new Request.Builder()
                .get()
                .url(BASE_URL + "/get/text")
                .build();

        //用Client创建请求任务
        Call task = okHttpClient.newCall(request);
        //异步请求
        task.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure ===>>> " + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                int code = response.code();
                Log.d(TAG, "code ===>>> " + code);
                if (code == HttpURLConnection.HTTP_OK){
                    ResponseBody body = response.body();
                }

                String string = response.body().string();
                Gson gson = new Gson();
                final GetTextItem getTextItem = gson.fromJson(string, GetTextItem.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textAdapter2.setData(getTextItem);
                    }
                });


            }
        });

    }
}
