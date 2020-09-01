package com.cjc.familybill.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by CC
 **/
public class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public boolean checkIsLogin(){
        SharedPreferences sp = getActivity().getSharedPreferences("loginInfo", MODE_PRIVATE);
        String username = sp.getString("loginUserName", "");
        if (TextUtils.isEmpty(username)) {
            return false;
        }else if (!TextUtils.isEmpty(username)){
            return true;
        }
        return false;
    }
}
