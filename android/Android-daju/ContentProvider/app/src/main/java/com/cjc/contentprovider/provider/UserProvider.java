package com.cjc.contentprovider.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cjc.contentprovider.db.UserDatabaseHelper;
import com.cjc.contentprovider.utils.Constants;

/**
 * Created by CC
 **/

/*
* 步骤：
* 1.编写一个类继承ContentProvider
* 2.去AndroidManifest.xml里注册
*
*
*
* */
public class UserProvider extends ContentProvider {

    private static final String TAG = "UserProvider";
    private UserDatabaseHelper mUserDatabaseHelper = null;

    private static final int USER_MATCH_CODE = 1;

    //定义一个Uri匹配器，UriMatcher.NO_MATCH,不匹配时的返回值
    private static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        //添加规则
        mUriMatcher.addURI("cjc", "user", USER_MATCH_CODE);
        mUriMatcher.addURI("com.cjc.contentprovider", null, USER_MATCH_CODE);
    }

    @Override
    public boolean onCreate() {
        //创建操作数据库
        mUserDatabaseHelper = new UserDatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int result = mUriMatcher.match(uri);
        if (result == USER_MATCH_CODE) {
            //匹配成功
            SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();
            Cursor cursor = db.query(Constants.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
            return cursor;
        } else {
            //匹配失败
            throw new IllegalArgumentException("参数错误");
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        int result = mUriMatcher.match(uri);
        if (result == USER_MATCH_CODE) {
            SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();
            //insert()方法返回值返回的是插入数据的id
            long id = db.insert(Constants.TABLE_NAME, null, values);
            Uri resultUri = Uri.parse("content://cjc/user/" + id);
            Log.d(TAG, "ContentProvider insert ===>>> " + id);
            getContext().getContentResolver().notifyChange(resultUri,null);
            return resultUri;
        }else {
            //匹配失败
            throw new IllegalArgumentException("参数错误");
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
