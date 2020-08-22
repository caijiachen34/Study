package com.cjc.networkdemo.okhttp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.networkdemo.Constants;
import com.cjc.networkdemo.R;
import com.cjc.networkdemo.okhttp.adapters.GetTextAdapter2;
import com.cjc.networkdemo.domain.CommentItem;
import com.cjc.networkdemo.domain.GetTextItem;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * Created by CC
 **/
public class OkHttpActivity extends Activity {

    private static final String TAG = "OkHttpActivity";
    private GetTextAdapter2 textAdapter2;

    String[] permissions = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    //未授权的权限存储到mPermissionList里
    List<String> mPermissionList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        initView();
        getPermission();
    }

    private void getPermission() {
        mPermissionList.clear();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(OkHttpActivity.this,
                    permissions[i])!= PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);
            }
        }

        if (mPermissionList.size()>0) {
            ActivityCompat.requestPermissions(OkHttpActivity.this,permissions,1);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        boolean hasPermissionDismiss = false;   //有权限没有通过

        if (requestCode == 1) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == -1) {
                    hasPermissionDismiss = true;    //有权限没有通过
                    break;
                }
            }
        }

        if (hasPermissionDismiss) {
            Toast.makeText(this,"请去设置里同意权限",Toast.LENGTH_LONG);
        }else {
            Toast.makeText(this,"权限已同意",Toast.LENGTH_LONG);
        }
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
                .url(Constants.BASE_URL + "/get/text")
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
                if (code == HTTP_OK){
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


    public void postComment(View view){
        //创建客户端
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000,TimeUnit.MICROSECONDS)
                .build();

        //要提交的内容:应该从ui中获取内容，封装成bean类，再转换成json字符串
        CommentItem commentItem = new CommentItem("12121","绝了！");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(commentItem);
        //类型:json
        MediaType mediaType = MediaType.parse("application/json");

        final RequestBody requestBody = RequestBody.create(jsonStr, mediaType);

        Request request = new Request.Builder()
                .post(requestBody)
                .url(Constants.BASE_URL + "/post/comment")
                .build();

        Call task = okHttpClient.newCall(request);
        task.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                int code = response.code();
                Log.d(TAG, "code ===>>> " + code);
                if (code == HTTP_OK) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        Log.d(TAG, "result ===>>> " + body.string());
                    }
                }
            }
        });

    }

    public void postFile(View view){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10000,TimeUnit.MICROSECONDS)
                .build();

        File file = new File("/sdcard/DCIM/Camera/IMG_20200821_062846.jpg");
        //文件类型
        MediaType fileType = MediaType.parse("image/jpeg");

        RequestBody fileBody = RequestBody.create(file,fileType);

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("file",file.getName(),fileBody)
                .build();

        //创建请求
        Request request = new Request.Builder()
                .url(Constants.BASE_URL + "/file/upload")
                .post(requestBody)
                .build();

        //请求发送
        Call task = client.newCall(request);
        //请求加入队列并回调
        task.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure ===>>> " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                int code = response.code();
                Log.d(TAG, "code ===>>> " + code);

                if (code ==HTTP_OK) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        String result = body.string();
                        Log.d(TAG, "result ===>>> " + result);
                    }
                }

            }
        });

    }

    public void postFiles(View view){

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10000,TimeUnit.MICROSECONDS)
                .build();

        File file1 = new File("/sdcard/Download/timg.jpg");
        File file2 = new File("/sdcard/DCIM/Camera/IMG_20200821_062846.jpg");
        MediaType mediaType = MediaType.parse("image/jpeg");
        RequestBody fileBody1 = RequestBody.create(file1,mediaType);
        RequestBody fileBody2 = RequestBody.create(file2,mediaType);

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("files",file1.getName(),fileBody1)
                .addFormDataPart("files",file2.getName(),fileBody2)
                .build();

        Request request = new Request.Builder()
                .url(Constants.BASE_URL + "/files/upload")
                .post(requestBody)
                .build();

        Call task = client.newCall(request);
        task.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                int code = response.code();
                Log.d(TAG, "body: " + code);

                if (code == HTTP_OK) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        String result = body.string();
                        Log.d(TAG, "result" + result);
                    }
                }

            }
        });
    }

    public void downFile(View view){

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MICROSECONDS)
                .build();

        Request request = new Request.Builder()
                .get()
                .url(Constants.BASE_URL + "/download/15")
                .build();

        Call task = client.newCall(request);
        task.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });

    }
}
