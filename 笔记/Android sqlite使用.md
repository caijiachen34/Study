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



