package com.cjc.networkdemo.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cjc.networkdemo.Constants;
import com.cjc.networkdemo.R;
import com.cjc.networkdemo.domain.GetTextItem;
import com.cjc.networkdemo.okhttp.adapters.GetTextAdapter2;
import com.cjc.networkdemo.utils.RetrofitManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitActivity";
    private GetTextAdapter2 mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.result_list_retrofit);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = 5;
                outRect.bottom = 5;
            }
        });
        mAdapter = new GetTextAdapter2();
        recyclerView.setAdapter(mAdapter);
    }

    public void getRequest(View view) {
        //使用Builder模式实例化Retrofit对象
        //得到接口的对象,得到对象就可以使用对象的方法
        API api = RetrofitManager.getRetrofit().create(API.class);
        //使用对象方法获得Call对象
        Call<GetTextItem> task = api.getJson();
        task.enqueue(new Callback<GetTextItem>() {
            @Override
            public void onResponse(Call<GetTextItem> call, Response<GetTextItem> response) {
                Log.d(TAG, "onResponse === " + response.code());
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    GetTextItem body = response.body();
                    updateList(body);
                }

            }

            @Override
            public void onFailure(Call<GetTextItem> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    private void updateList(GetTextItem jsonResult) {
        mAdapter.setData(jsonResult);
    }
}