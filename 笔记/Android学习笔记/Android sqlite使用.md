# Android sqlite使用

### 1.数据库的创建和升级

相关常参类

```java
public class Constants {
    public static final String DATABASE_NAME="cjc.db";
    public static final int VERSION_CODE = 3;
    public static final String TABLE_NAME = "employee";
}
```

创建一个类继承SQLiteOpenHelper类并且实现相关方法

```java
public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TAG = "DatabaseHelper";

    /*
    * @param context 上下文
    * @param name    数据库名称
    * @param factory 游标工厂
    * @param version 版本号
    *
    * */
    public DatabaseHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建时的回调
        Log.d(TAG,"创建数据库");
        //创建字段
        //sql：create table table_name(_id integer,name varchar(50),age Integer,salary Integer);
        String sql = "create table "+Constants.TABLE_NAME+"(_id integer,name varchar(50),age Integer,salary integer)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //升级时的回调
        Log.d(TAG,"升级数据库");

        //sql:alter table_name add phone integer;
        String sql;

        //用户版本的判断
        switch (oldVersion){
            case 1:
                //添加address和这个phone字段
                sql = "alter table " + Constants.TABLE_NAME + " add phone integer,address varchar";
                db.execSQL(sql);
                break;
            case 2:
                //添加address字段
                sql = "alter table " + Constants.TABLE_NAME + " add address varchar";
                break;
            case 3:

                break;
        }
    }
}

```

MainActivity:

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建数据库,调用DatabaseHelper
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getWritableDatabase();
    }
}
```





### 2.编写Dao接口操作类（增删改查）

```java
public class Dao {

    private static final String TAG = "Dao";
    private final DatabaseHelper helper;

    public Dao(Context context){
        //创建数据库
        helper = new DatabaseHelper(context);

    }
    public void insert(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into "+ Constants.TABLE_NAME + "(_id,name,age,salary,phone,address) values (?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{1,"cjc1",3,120,"120","泰州"});
        db.execSQL(sql,new Object[]{2,"cjc2",3,120,"120","泰州"});
        db.close();
    }

    public void delete(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from "+ Constants.TABLE_NAME + " where _id = ?";
        db.execSQL(sql,new Object[]{2});
        db.close();
    }

    public void update(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update "+ Constants.TABLE_NAME + " set salary = 999 where _id = ?";
        db.execSQL(sql,new Object[]{1});
        db.close();
    }

    public void query(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from "+ Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("name");
            String name = cursor.getString(index);
            Log.d(TAG,"name ===>" + name);
        }
        cursor.close();
        db.close();
    }

}
```



### 3.编写测试类

```java
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
```





### 4.使用Android api进行增删改查

```java
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
```



### 5.数据库事务

数据库事务：特点：安全性，高效性

```java
@Test
    public void testInsert(){
        DataBaseHelper helper = new DataBaseHelper(appContext);
        SQLiteDatabase db = helper.getReadableDatabase();
        long start = System.currentTimeMillis();
        ContentValues values = new ContentValues();
        values.put("_id",1);
        values.put("name","cjc1");
        values.put("money",110);

        //开启事务 插入3000条耗时296ms
        //不开启耗时11835ms
        db.beginTransaction();

        for (int i = 0; i < 3000; i++) {
            db.insert("account",null,values);
        }
        //关闭事务
        db.endTransaction();

        Log.d(TAG, "testInsert: useTime==="+(System.currentTimeMillis() - start));

        db.close();
    }

    @Test
    public void testUpdate(){
        DataBaseHelper helper = new DataBaseHelper(appContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        db.beginTransaction();
        try {
            //发生异常
            //int i = 10 / 0;
            ContentValues values = new ContentValues();
            values.put("money",9999);
            db.update("account",values,"_id = ?",new String[]{"2"});
            db.setTransactionSuccessful();
            Log.d(TAG, "testUpdate: =====>>> 事务正常");

        } catch (Exception e){
            //处理异常
            Log.d(TAG, "testUpdate: =====>>> 发生异常");
            Log.d(TAG, "testUpdate: " +e);
        }finally {
            db.endTransaction();
            db.close();
        }

    }
```

