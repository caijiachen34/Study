package com.cjc.ouxun;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_main_search)
    EditText etMainSearch;
    @BindView(R.id.recycler_view_main)
    RecyclerView recyclerViewMain;
    @BindView(R.id.btn_new_box)
    Button btnNewBox;
    @BindView(R.id.btn_search_box)
    Button btnSearchBox;

    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplication());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewMain.setLayoutManager(layoutManager);
        int[] imageID = {R.mipmap.box0,R.mipmap.box1,R.mipmap.box2,R.mipmap.box3,R.mipmap.box4};
        String[] boxState = {"未确认","已确认","已入库","已借出","已摧毁"};
        mainAdapter = new MainAdapter(getApplicationContext(),imageID,boxState);
        recyclerViewMain.setAdapter(mainAdapter);


    }
}