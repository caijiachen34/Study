package com.example.administrator.mobileshop01.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.administrator.mobileshop01.R;


public class NavigationFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout tabItemHome;
    private LinearLayout tabItemCategory;
    private LinearLayout tabItemCart;
    private LinearLayout tabItemPerson;

    private ImageButton tabItemHomeBtn;
    private ImageButton tabItemCategoryBtn;
    private ImageButton tabItemCartBtn;
    private ImageButton tabItemPersonBtn;

    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private CartFragment cartFragment;
    private PersonFragment personFragment;

    private FragmentManager fragmentManager;
    public int currentId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        //调用初始化和tab选中状态
        initViews(view);
        setTabSelection(R.id.tab_item_home);//默认进程先选中首页
        return view;

    }

    //初始化视图
    private void initViews(View view) {
        tabItemHome = view.findViewById(R.id.tab_item_home);
        tabItemHome.setOnClickListener(this);

        tabItemCart = view.findViewById(R.id.tab_item_cart);
        tabItemCart.setOnClickListener(this);

        tabItemCategory = view.findViewById(R.id.tab_item_category);
        tabItemCategory.setOnClickListener(this);

        tabItemPerson = view.findViewById(R.id.tab_item_personal);
        tabItemPerson.setOnClickListener(this);

        tabItemHomeBtn = view.findViewById(R.id.tab_item_home_btn);
        tabItemCategoryBtn = view.findViewById(R.id.tab_item_category_btn);
        tabItemCartBtn = view.findViewById(R.id.tab_item_cart_btn);
        tabItemPersonBtn = view.findViewById(R.id.tab_item_personal_btn);
        fragmentManager = getFragmentManager();

    }

    public void setTabSelection(int id) {
        tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_focus);
        tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_focus);
        tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_focus);
        tabItemPersonBtn.setImageResource(R.drawable.tab_item_personal_focus);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (homeFragment != null)
            fragmentTransaction.hide(homeFragment);
        if (categoryFragment != null)
            fragmentTransaction.hide(categoryFragment);
        if (cartFragment != null)
            fragmentTransaction.hide(cartFragment);
        if (personFragment != null)
            fragmentTransaction.hide(personFragment);
        switch (id) {
            case R.id.tab_item_home:
                tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_normal);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.tab_item_category:
                tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_normal);
                if (categoryFragment == null) {
                    categoryFragment = new CategoryFragment();
                    fragmentTransaction.add(R.id.content, categoryFragment);
                } else {
                    fragmentTransaction.show(categoryFragment);
                }
                break;
            case R.id.tab_item_cart:
                tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_normal);
                if (cartFragment == null) {
                    cartFragment = new CartFragment();
                    fragmentTransaction.add(R.id.content, cartFragment);
                } else {
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.tab_item_personal:
                tabItemPersonBtn.setImageResource(R.drawable.tab_item_personal_normal);
                if (personFragment == null) {
                    personFragment = new PersonFragment();
                    fragmentTransaction.add(R.id.content, personFragment);
                } else {
                    fragmentTransaction.show(personFragment);
                }
                break;
        }
        fragmentTransaction.commit();
        currentId = id;

    }


    @Override
    public void onClick(View v) {
        setTabSelection(v.getId());
    }
}
