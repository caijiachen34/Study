package com.cjc.networkdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cjc.networkdemo.adapters.GetResultListAdapter;
import com.cjc.networkdemo.domain.GetTextItem;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private GetResultListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.result_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = 5;
                outRect.bottom = 5;
            }
        });
        mAdapter = new GetResultListAdapter();
        recyclerView.setAdapter(mAdapter);
    }

    public void loadJson(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //URL url = new URL("http://10.0.2.2:9102/get/text");
                    URL url = new URL("http://192.168.2.143:9102/get/text");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(10000);
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
                    connection.setRequestProperty("Accept-Encoding","gzip,deflate");
                    connection.setRequestProperty("Accept","*/*");
                    connection.connect();
                    //结果码
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200) {
                        Map<String, List<String>> headerFields = connection.getHeaderFields();
                        Set<Map.Entry<String, List<String>>> entries = headerFields.entrySet();
                        for (Map.Entry<String, List<String>> entry : entries) {
                            Log.d(TAG,entry.getKey() + "===" + entry.getValue());
                        }
                        InputStream inputStream = connection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String json = bufferedReader.readLine();
                        Log.d(TAG, "line === " + json);
                        Gson gson = new Gson();
                        GetTextItem getTextItem = gson.fromJson(json, GetTextItem.class);
                        updateUI(getTextItem);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void updateUI(final GetTextItem getTextItem) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.setData(getTextItem);
            }
        });
    }
}