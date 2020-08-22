package com.cjc.networkdemo.retrofit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.cjc.networkdemo.Constants;
import com.cjc.networkdemo.R;
import com.cjc.networkdemo.domain.CommentItem;
import com.cjc.networkdemo.domain.GetWithParamsResult;
import com.cjc.networkdemo.domain.PostWithParamsResult;
import com.cjc.networkdemo.utils.RetrofitManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by CC
 **/
public class RequestActivity extends Activity {
    private static final String TAG = "RequestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
    }

    public void getWithParam_retrofit(View view) {
        API api = RetrofitManager.getRetrofit().create(API.class);
        Call<GetWithParamsResult> withParams = api.getWithParams("我是搜索关键字", 10, "0");
        withParams.enqueue(new Callback<GetWithParamsResult>() {
            @Override
            public void onResponse(Call<GetWithParamsResult> call, Response<GetWithParamsResult> response) {
                Log.d(TAG, "onResponse ===>>> " + response.body());
            }

            @Override
            public void onFailure(Call<GetWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });
    }

    public void getWithParamMap_retrofit(View view) {
        API api = RetrofitManager.getRetrofit().create(API.class);
        Map<String, Object> params = new HashMap<>();

        params.put("keyword", "我是关键字");
        params.put("page", "10");
        params.put("order", "0");

        Call<GetWithParamsResult> withParams = api.getWithParams(params);
        withParams.enqueue(new Callback<GetWithParamsResult>() {
            @Override
            public void onResponse(Call<GetWithParamsResult> call, Response<GetWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " + code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<GetWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });

    }

    public void postWithParam_retrofit(View view) {
        API api = RetrofitManager.getRetrofit().create(API.class);

        Call<PostWithParamsResult> postWithParamsResultCall = api.postWithParams("太棒了！");

        postWithParamsResultCall.enqueue(new Callback<PostWithParamsResult>() {
            @Override
            public void onResponse(Call<PostWithParamsResult> call, Response<PostWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " + code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PostWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });

    }


    public void postWithUrl_retrofit(View view) {
        API api = RetrofitManager.getRetrofit().create(API.class);
        String url = Constants.BASE_URL + "/post/string" + "?string=内容测试内容";
        Call<PostWithParamsResult> task = api.postWithUrl(Constants.BASE_URL + "/post/string");
        task.enqueue(new Callback<PostWithParamsResult>() {
            @Override
            public void onResponse(Call<PostWithParamsResult> call, Response<PostWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " + code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PostWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });
    }

    public void postWithBody_retrofit(View view) {
        API api = RetrofitManager.getRetrofit().create(API.class);
        CommentItem commentItem = new CommentItem("1212","呵呵呵");
        Call<PostWithParamsResult> task = api.postWithBody(commentItem);
        task.enqueue(new Callback<PostWithParamsResult>() {
            @Override
            public void onResponse(Call<PostWithParamsResult> call, Response<PostWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " +code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PostWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });

    }

    public void postFile_retrofit(View view){
        API api = RetrofitManager.getRetrofit().create(API.class);
        //创建文件
        File file = new File("/sdcard/Download/timg.jpg");
        //解析这个文件为图片
        RequestBody body = RequestBody.create(MediaType.parse("image/jpeg"),file);
        //createFormData参数: 传入File类的名字，file文件的名字,RequestBody类
        MultipartBody.Part part = MultipartBody.Part.createFormData("file",file.getName(),body);
        Call<PostWithParamsResult> task = api.postFile(part);
        task.enqueue(new Callback<PostWithParamsResult>() {
            @Override
            public void onResponse(Call<PostWithParamsResult> call, Response<PostWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " +code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PostWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });
    }

    public void postFiles_retrofit(View view){
        API api = RetrofitManager.getRetrofit().create(API.class);
        MultipartBody.Part part1 = MultipartBodyMethod("/sdcard/Download/timg.jpg","files");
        MultipartBody.Part part2 = MultipartBodyMethod("/sdcard/DCIM/Camera/IMG_20200809_042923.jpg","files");
        List<MultipartBody.Part> parts = new ArrayList<>();
        parts.add(part1);
        parts.add(part2);

        Call<PostWithParamsResult> task = api.postFiles(parts);
        task.enqueue(new Callback<PostWithParamsResult>() {
            @Override
            public void onResponse(Call<PostWithParamsResult> call, Response<PostWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " +code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PostWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });
    }

    public void postFileWithParams_retrofit(View view){
        API api = RetrofitManager.getRetrofit().create(API.class);
        MultipartBody.Part part1 = MultipartBodyMethod("/sdcard/Download/timg.jpg","file");
        Map<String, String> params = new HashMap<>();
        params.put("description","这是一张图片");
        params.put("isFree","true");
        Call<PostWithParamsResult> task = api.postFileWithParams(part1, params);
        task.enqueue(new Callback<PostWithParamsResult>() {
            @Override
            public void onResponse(Call<PostWithParamsResult> call, Response<PostWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " +code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PostWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });
    }

    public void doLogin_retrofit(View view){
        API api = RetrofitManager.getRetrofit().create(API.class);

        Call<PostWithParamsResult> task = api.dologin("cjc", "123456");
        task.enqueue(new Callback<PostWithParamsResult>() {
            @Override
            public void onResponse(Call<PostWithParamsResult> call, Response<PostWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " +code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PostWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });
    }

    public void doLogin_Map_retrofit(View view){
        API api = RetrofitManager.getRetrofit().create(API.class);
        Map<String,String> params = new HashMap<>();
        params.put("userName","cjc1");
        params.put("password","123");
        Call<PostWithParamsResult> task = api.dologin(params);
        task.enqueue(new Callback<PostWithParamsResult>() {
            @Override
            public void onResponse(Call<PostWithParamsResult> call, Response<PostWithParamsResult> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " +code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse ===>>> " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PostWithParamsResult> call, Throwable t) {
                Log.d(TAG, "onFailure ===>>> " + t.getMessage());
            }
        });
    }

    public void downFile_retrofit(View view){
        API api = RetrofitManager.getRetrofit().create(API.class);
        String url = Constants.BASE_URL + "/download/8";
        Call<ResponseBody> task = api.downFile(url);
        task.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                int code = response.code();
                Log.d(TAG, "code ===>>> " + code);
                if (code == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "thread name ===>>> " + Thread.currentThread().getName());
                    //拿出文件名 ---header里
                    String fileName = "未命名.png";
                    Headers headers = response.headers();
                    String fileNameHeader = headers.get("Content-disposition");
                    if (fileNameHeader != null) {
                        //String fileName = fileNameHeader.replace("attachment; filename=","");
                        Log.d(TAG, "fileName ===>>> " + fileName);
                    }

//                    for (int i = 0; i < headers.size(); i++) {
//                        String value = headers.value(i);
//                        String key = headers.name(i);
//                        Log.d(TAG, "key ===>>> " + key + "/value ===>>> " + value);
//                    }
                    //写文件，这里是ui线程不可写

                    writeString2Disk(response,fileName);

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void writeString2Disk(Response<ResponseBody> response, String fileName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream inputStream = response.body().byteStream();
//                File exPath = Environment.getExternalStorageDirectory();
//                Log.d(TAG, "exPath ===>>> " + exPath);
                File baseOutFile = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                File outFile = new File(baseOutFile,fileName);
                Log.d(TAG, "outFile ===>>> " + outFile);
                try {
                    FileOutputStream fos = new FileOutputStream(outFile);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer))!=-1){
                        fos.write(buffer,0,len);
                    }
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //key为服务器接口中规定的文件列表
    private MultipartBody.Part MultipartBodyMethod(String filePath,String key) {
        File file = new File(filePath);
        RequestBody body = RequestBody.create(MediaType.parse("image/jpeg"),file);
        MultipartBody.Part part = MultipartBody.Part.createFormData(key, file.getName(), body);
        return part;
    }
}
