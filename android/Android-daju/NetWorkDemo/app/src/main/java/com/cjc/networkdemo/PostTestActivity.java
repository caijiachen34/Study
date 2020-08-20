package com.cjc.networkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cjc.networkdemo.domain.CommentItem;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static java.net.HttpURLConnection.HTTP_OK;

public class PostTestActivity extends AppCompatActivity {

    private static final String TAG = "PostTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_test);
    }

    public void postRequest(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OutputStream outputStream = null;
                InputStream inputStream = null;
                try {
                    URL url = new URL("http://192.168.2.143:9102/post/comment");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
                    httpURLConnection.setRequestProperty("Accept", "application/json, text/plain, */*");

                    CommentItem commentItem = new CommentItem("234134123", "66666！");
                    Gson gson = new Gson();
                    String jsonStr = gson.toJson(commentItem);
                    byte[] bytes = jsonStr.getBytes("UTF-8");
                    Log.d(TAG, "jsonStr length ===>>> " + bytes.length);
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                    //连接
                    httpURLConnection.connect();
                    //把数据给服务器
                    outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    //拿结果
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == HTTP_OK) {
                        inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        Log.d(TAG, "bufferedReader: " + bufferedReader.readLine());
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }


    //带参数的post请求
    public void getWithParams(View view) {
        Map<String, String> params = new HashMap<>();
        params.put("page", "12");
        params.put("keyword", "关键字");
        params.put("order", "0");
        startRequest(params, "GET", "/get/param");

    }

    private void startRequest(final Map<String, String> params, final String method, final String api) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader bufferedReader = null;
                try {
                    StringBuilder sb = new StringBuilder();
                    //组装参数
                    Log.d(TAG, "run: 组装参数");
                    if (params != null && params.size() > 0) {
                        sb.append("?");
                        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
                        while (iterator.hasNext()) {
                            Map.Entry<String, String> next = iterator.next();
                            sb.append(next.getKey());
                            sb.append("=");
                            sb.append(next.getValue());
                            if (iterator.hasNext()) {
                                sb.append("&");
                            }
                        }
                        Log.d(TAG, "sb result ===>>> " + sb.toString());
                    }

                    String params = sb.toString();
                    URL url;
                    if (params != null && params.length() > 0) {
                        url = new URL("http://192.168.2.143:9102" + api + params);
                    }else {
                        url = new URL("http://192.168.2.143:9102" + api);
                    }

                    Log.d(TAG, "url ===>>> " + url.toString());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod(method);
                    httpURLConnection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
                    httpURLConnection.setRequestProperty("Accept-Encoding","gzip,deflate");
                    httpURLConnection.setRequestProperty("Accept","*/*");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == RESULT_OK) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String json = bufferedReader.readLine();
                        Log.d(TAG, "result ===>>> " + json);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}