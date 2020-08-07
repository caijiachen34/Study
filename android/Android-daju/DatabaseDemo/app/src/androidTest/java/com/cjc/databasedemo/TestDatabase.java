package com.cjc.databasedemo;


import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by CC
 **/
@RunWith(AndroidJUnit4.class)
public class TestDatabase{

    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

    @Test
    public void testCreate() {

    }

    @Test
    public void testInsert() {
        Dao dao = new Dao(appContext);
        dao.insert();
    }

    @Test
    public void testDelete() {
        Dao dao = new Dao(appContext);
        dao.delete();
    }

    @Test
    public void testUpdate() {
        Dao dao = new Dao(appContext);
        dao.update();
    }

    @Test
    public void testQuery() {
        Dao dao = new Dao(appContext);
        dao.query();
    }
}
