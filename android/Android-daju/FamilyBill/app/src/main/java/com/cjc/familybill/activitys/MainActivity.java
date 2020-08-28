package com.cjc.familybill.activitys;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.cjc.familybill.R;
import com.cjc.familybill.fragment.NavigationFragment;

/**
 * Created by CC
 **/
public class MainActivity extends BaseActivity {
    private NavigationFragment navigationFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        navigationFragment = new NavigationFragment();
        transaction.add(R.id.main_fragment,navigationFragment);
        transaction.commit();

    }
}
