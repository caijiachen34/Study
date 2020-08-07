package com.cjc.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by CC
 **/
public class Dao {

    private static final String TAG = "Dao";
    private final DatabaseHelper helper;

    public Dao(Context context) {
        //创建数据库
        helper = new DatabaseHelper(context);

    }

    public void insert() {
        SQLiteDatabase db = helper.getWritableDatabase();
        /*String sql = "insert into "+ Constants.TABLE_NAME + "(_id,name,age,salary,phone,address) values (?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{1,"cjc1",3,120,"120","泰州"});
        db.execSQL(sql,new Object[]{2,"cjc2",3,120,"120","泰州"});*/

        ContentValues values = new ContentValues();
        values.put("_id", 2);
        values.put("name", "cjc2");
        values.put("age", 3);
        values.put("salary", 100);
        values.put("phone", "130");
        values.put("address", "江苏");

        // public long insert(String table, String nullColumnHack, ContentValues values)
        // 第一个值为表名，第二个为字段默认值，第三个为要插入的数据ContentValues，手动新建并put键值对
        long insert = db.insert(Constants.TABLE_NAME, null, values);
        Log.d(TAG, "insert: " + insert);
        db.close();
    }

    public void delete() {
        SQLiteDatabase db = helper.getWritableDatabase();
       /* String sql = "delete from " + Constants.TABLE_NAME + " where _id = ?";
        db.execSQL(sql, new Object[]{2});*/
        // 第一个值为表名,第二个值为条件，类型为String，第三个值为第三个值中使用的占位符的值，类型为String[]{}
        int delete = db.delete(Constants.TABLE_NAME, "_id = ?", new String[]{"2"});
        Log.d(TAG, "delete: "+ delete);
        db.close();
    }

    public void update() {
        SQLiteDatabase db = helper.getWritableDatabase();
        /*String sql = "update "+ Constants.TABLE_NAME + " set salary = 999 where _id = ?";
        db.execSQL(sql,new Object[]{1});*/
        ContentValues values = new ContentValues();
        values.put("phone", "114");
        // public int update(String table, ContentValues values, String whereClause, String[] whereArgs)
        // 第一个值为表名，第二个值为ContentValues(修改之后的值)，手动新建并put键值对
        // 第三个值为条件，类型为String，第四个值为第三个值中使用的占位符的值，类型为String[]{}
        int update = db.update(Constants.TABLE_NAME, values, "_id = ?", new String[]{"1"});
        Log.d(TAG, "update: " + update);
        db.close();
    }

    public void query() {
        SQLiteDatabase db = helper.getWritableDatabase();
        /*String sql = "select * from "+ Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("name");
            String name = cursor.getString(index);
            Log.d(TAG,"name ===>" + name);
        }
        cursor.close();*/

        /*table：表名。相当于select语句from关键字后面的部分。如果是多表联合查询，可以用逗号将两个表名分开。
          columns：要查询出来的列名。相当于select语句select关键字后面的部分. * 对应 new String[]{"*"}。
          selection：查询条件子句，相当于select语句where关键字后面的部分，在条件子句允许使用占位符“?”
          selectionArgs：对应于selection语句中占位符的值，值在数组中的位置与占位符在语句中的位置必须一致，否则就会有异常。
          groupBy：相当于select语句group by关键字后面的部分
          having：相当于select语句having关键字后面的部分
          orderBy：相当于select语句order by关键字后面的部分，如：time desc, count asc;
          limit：指定偏移量和获取的记录数，相当于select语句limit关键字后面的部分。*/
        Cursor cursor = db.query(false, Constants.TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            Log.d(TAG, "query: id== " + id + "   name== "+ name);
        }

        cursor.close();
        db.close();
    }

}
