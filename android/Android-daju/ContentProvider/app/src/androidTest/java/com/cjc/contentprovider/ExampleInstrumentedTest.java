package com.cjc.contentprovider;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.cjc.contentprovider.dao.IUserDao;
import com.cjc.contentprovider.dao.UserDaoImpl;
import com.cjc.contentprovider.pojo.User;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TAG = "ExampleInstrumentedTest";

    @Test
    public void testAddUser(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao = new UserDaoImpl(appContext);
        User user = new User();
        user.setPassword("33");
        user.setSex("男");
        user.setAge(33);
        user.setUserName("33");
        long result = userDao.addUser(user);
        Log.d(TAG, "testAddUser ===>>> " + result);
        assertNotEquals(-1,result);
    }

    @Test
    public void testUpdate(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao = new UserDaoImpl(appContext);
        User user = new User();
        user.set_id(2);
        user.setUserName("22");
        user.setPassword("22");
        user.setAge(22);
        user.setSex("女");
        int result = userDao.updateUser(user);
        Log.d(TAG, "testUpdate ===>>> " + result);
    }

    @Test
    public void testQueryById(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao = new UserDaoImpl(appContext);
        User user = userDao.getUserById(1);
        Log.d(TAG, "testQueryById ===>>> " + user);

    }

    @Test
    public void testQueryAll(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao = new UserDaoImpl(appContext);
        List<User> userList = userDao.listAllUser();
        for (User user : userList) {
            Log.d(TAG, "testQueryAll ===>>> " + user);
        }
    }

    @Test
    public void testDel(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao = new UserDaoImpl(appContext);
        int result = userDao.delUserById(1);
        Log.d(TAG, "testDel ===>>> " + result);
    }



    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.cjc.contentprovider", appContext.getPackageName());
    }
}