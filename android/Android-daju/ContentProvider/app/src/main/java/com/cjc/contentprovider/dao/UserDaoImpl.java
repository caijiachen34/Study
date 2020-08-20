package com.cjc.contentprovider.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cjc.contentprovider.db.UserDatabaseHelper;
import com.cjc.contentprovider.pojo.User;
import com.cjc.contentprovider.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CC
 **/
public class UserDaoImpl implements IUserDao {

    private final UserDatabaseHelper mUserDatabaseHelper;

    public UserDaoImpl(Context context){
        mUserDatabaseHelper = new UserDatabaseHelper(context);
    }

    @Override
    public long addUser(User user) {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("password",user.getPassword());
        values.put("sex",user.getSex());
        values.put("age",user.getAge());

        long result = db.insert(Constants.TABLE_NAME, null, values);
        db.close();
        return result;
    }

    @Override
    public int delUserById(int id) {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();
        int result = db.delete(Constants.TABLE_NAME, "_id =?", new String[]{id + ""});
        db.close();
        return result;
    }

    @Override
    public int updateUser(User user) {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("password",user.getPassword());
        values.put("sex",user.getSex());
        values.put("age",user.getAge());

        int result = db.update(Constants.TABLE_NAME, values, "_id", new String[]{user.get_id() + ""});
        db.close();
        return result;
    }

    @Override
    public User getUserById(int id) {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();

        String sql = "select * from " + Constants.TABLE_NAME + " where " + "_id = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{id + ""});
        User user = null;
        if (cursor.moveToNext()){
            user = new User();

            int userId = cursor.getInt(cursor.getColumnIndex("_id"));
            user.set_id(userId);

            String userName = cursor.getString(cursor.getColumnIndex("userName"));
            user.setUserName(userName);
            String password = cursor.getString(cursor.getColumnIndex("password"));
            user.setPassword(password);
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            user.setSex(sex);
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            user.setAge(age);
        }
        db.close();
        return user;
    }

    @Override
    public List<User> listAllUser() {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, null, null, null, null, null, null);
        List<User> userList = new ArrayList<>();
        while (cursor.moveToNext()){
            User user = cursor2User(cursor);
            userList.add(user);
        }
        db.close();
        return userList;
    }

    private User cursor2User(Cursor cursor) {
        User user = new User();

        int userId = cursor.getInt(cursor.getColumnIndex("_id"));
        user.set_id(userId);

        String userName = cursor.getString(cursor.getColumnIndex("userName"));
        user.setUserName(userName);
        String password = cursor.getString(cursor.getColumnIndex("password"));
        user.setPassword(password);
        String sex = cursor.getString(cursor.getColumnIndex("sex"));
        user.setSex(sex);
        int age = cursor.getInt(cursor.getColumnIndex("age"));
        user.setAge(age);

        return user;
    }
}
