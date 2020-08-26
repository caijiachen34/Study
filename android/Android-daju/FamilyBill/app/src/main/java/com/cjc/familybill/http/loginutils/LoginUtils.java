package com.cjc.familybill.http.loginutils;

import android.util.Log;

import com.cjc.familybill.http.RetrofitManager;
import com.cjc.familybill.http.api.MemberService;
import com.cjc.familybill.http.resultentity.LoginResult;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class LoginUtils {

    private static final String TAG = "LoginUtils";

    public rx.Observable<String> login(final String username, final String password){
        return rx.Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    MemberService api = RetrofitManager.getRetrofit().create(MemberService.class);
                    Call<LoginResult> task = (Call<LoginResult>) api.login(username, password);
                    task.enqueue(new Callback<LoginResult>() {
                        @Override
                        public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                            int code = response.code();
                            Log.d(TAG, "code: " + code);
                            if (code == HttpURLConnection.HTTP_OK) {
                                Log.d(TAG, "onResponse: " + response.body());
                            }


                        }

                        @Override
                        public void onFailure(Call<LoginResult> call, Throwable t) {
                            Log.d(TAG, "onFailure: " + call.toString());
                            Log.d(TAG, "onFailure: " + t.toString());
                        }
                    });

                }

            }
        });
    }


}
