package com.example.administrator.mobileshop01.db;

import android.content.Context;
import android.util.Log;

import com.example.administrator.mobileshop01.gen.CategoryDao;

import java.util.List;

public class DbUtils {

    private Context context;
    private CategoryDao categoryDao;
    public DbUtils(Context context){
        this.context=context;
        categoryDao=GreenDaoManager.getmInstance().getSession().getCategoryDao();
    }

    public void add(){
        Category category;
        for (int i=0;i<10;i++){
            int count=i+1;
            category=new Category(null,"增加商品"+i,"1",1,count,12,112,1,"12334");
            categoryDao.insert(category);
        }
    }

    public List<Category>selectAllData(){
        List<Category>categoryList=categoryDao.loadAll();
        for (Category cate:categoryList){

            Log.i("====","====="+cate.getName()+"====="+cate.toString());
        }
        return categoryList;
    }

    /**
     * 根据自增id来查询
     * @param id
     * @return
     */
    public Category selectByID(Long id){
        return categoryDao.load(id);
    }
    public void deleteDataByID(Long id){
    categoryDao.deleteByKey(id);
    }

    public void update(Category category){
        categoryDao.update(category);
    }

}
