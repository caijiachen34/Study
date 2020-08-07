package com.example.administrator.mobileshop01.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Entity不能漏
 */
@Entity
public class Category implements Serializable{

    private static final long serialVersionUID = 1378678068240153436L;

    @Override
    public String toString() {
        return "Category{" +
                "cat_id=" + cat_id +
                ", name='" + name + '\'' +
                ", cat_path='" + cat_path + '\'' +
                ", parent_id=" + parent_id +
                ", good_count=" + good_count +
                ", sort=" + sort +
                ", type_id=" + type_id +
                ", list_show=" + list_show +
                ", image='" + image + '\'' +
                '}';
    }

    //使用Greendao注释，表示设置该数据为自增id
    @Id
    private Long cat_id;
    private String name;
    private String cat_path;
    private int parent_id;
    private int good_count;
    private int sort;
    private int type_id;
    private int list_show;
    private String image;
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getList_show() {
        return this.list_show;
    }
    public void setList_show(int list_show) {
        this.list_show = list_show;
    }
    public int getType_id() {
        return this.type_id;
    }
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    public int getSort() {
        return this.sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
    public int getGood_count() {
        return this.good_count;
    }
    public void setGood_count(int good_count) {
        this.good_count = good_count;
    }
    public int getParent_id() {
        return this.parent_id;
    }
    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }
    public String getCat_path() {
        return this.cat_path;
    }
    public void setCat_path(String cat_path) {
        this.cat_path = cat_path;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getCat_id() {
        return this.cat_id;
    }
    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }
    @Generated(hash = 325045016)
    public Category(Long cat_id, String name, String cat_path, int parent_id,
            int good_count, int sort, int type_id, int list_show, String image) {
        this.cat_id = cat_id;
        this.name = name;
        this.cat_path = cat_path;
        this.parent_id = parent_id;
        this.good_count = good_count;
        this.sort = sort;
        this.type_id = type_id;
        this.list_show = list_show;
        this.image = image;
    }
    @Generated(hash = 1150634039)
    public Category() {
    }
}
