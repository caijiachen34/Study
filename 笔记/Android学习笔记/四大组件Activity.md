# 四大组件-Activity

### 一.AndroidManifest.xml初探

```
allowBackup:允许系统备份
icon:应用图标
label:应用名称
roundIcon:圆形图标android 8.0开始支持
supportsRtl:从左到右布局
theme:主题
```

设定程序的入口

```
<intent-filter>
   <action android:name="android.intent.action.MAIN" />

   <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```



![image-20200806165952360](四大组件Activity.assets/image-20200806165952360.png)



### 二.通过显式意图来控制界面跳转

1.创建一个SecondActivity文件，继承Activity，并创建activity_second.xml

2.在AndroidManifest.xml中注册SecondActivity

3.在activity_main.xml中添加登录界面相关组件（账号，账号输入框，密码，密码输入框）

4.在MainActivity中初始化部件,设置监听,创建意图内并往显式意图内put账号密码信息

```java
/**
 * 目标：
* 实现页面的跳转并且把数据传回另一个界面
*/
public class MainActivity extends AppCompatActivity {

    private EditText mAccount ;
    private EditText mPassword;
    private Button mLogin   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        mAccount = findViewById(R.id.account);
        mPassword = findViewById(R.id.password);
        mLogin   = findViewById(R.id.login);
    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerLogin();
            }
        });
    }

    private void handlerLogin() {
        String account = mAccount.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        //账号空判断
        if (TextUtils.isEmpty(account)) {
           Toast.makeText(this,"输入的账号为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //密码空判断
        if (TextUtils.isEmpty(password)) {
           Toast.makeText(this,"输入的密码为空",Toast.LENGTH_SHORT).show();
            return;
        }

        //创建一个意图，用来跳转到SecondActivity界面!!!重要
        Intent intent = new Intent(this,SecondActivity.class);
        //通过putExtra传输数据!!!重要
        intent.putExtra("account",account);
        intent.putExtra("password",password);
        startActivity(intent);

    }

}
```

5.在activity_second.xml中添加相关部件来显示账号密码信息

6.在SecondActivity中编写获取和显示账号密码的代码

```java
public class SecondActivity extends Activity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView info = findViewById(R.id.info);

        //获得传过来的意图
        Intent intent = getIntent();
        //获取账号密码
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");
        Log.d(TAG, "账号===>>>>" + account);
        Log.d(TAG, "密码====>>>>" + password);
        //账号密码显示
        info.setText("账号:" + account + "密码:" + password);
    }
}
```





### 三.通过隐式意图来控制界面跳转

1.创建一个ThirdActivity文件，继承Activity，并创建activity_third.xml

2.在AndroidManifest.xml中注册ThirdActivity,并添加意图过滤器intent-filter

```xml
<activity android:name=".ThirdActivity">
            <intent-filter>
                <action android:name="com.cjc.LOGIN_INFO"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="android.intent.category.HOME"/>
            </intent-filter>
</activity>
```

3.在activity_main.xml中添加登录界面相关组件（账号，账号输入框，密码，密码输入框）

4.在MainActivity中初始化部件,设置监听,创建意图内并往隐式意图内put账号密码信息

```java
public class MainActivity extends AppCompatActivity {

    private EditText mAccount ;
    private EditText mPassword;
    private Button mLogin   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        mAccount = findViewById(R.id.account);
        mPassword = findViewById(R.id.password);
        mLogin   = findViewById(R.id.login);
    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerLogin();
            }
        });
    }

    private void handlerLogin() {
        String account = mAccount.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        //账号空判断
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this,"输入的账号为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //密码空判断
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,"输入的密码为空",Toast.LENGTH_SHORT).show();
            return;
        }

        //创建一个意图，用来跳转到SecondActivity界面!!!重要
        //通过putExtra传输数据
        //使用隐式意图!!!重要
        Intent intent = new Intent();
        intent.setAction("com.cjc.LOGIN_INFO");
        //intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("account",account);
        intent.putExtra("password",password);
        startActivity(intent);

    }

}
```

5.在activity_third.xml中添加相关部件来显示账号密码信息(同上)



### Q:什么时候使用显式意图，什么时候使用隐式意图

显式意图一般用于应用内组件跳转，隐式意图一般用于应用之间的跳转



### 四.显式意图跳转到第三方应用（浏览器）

1.创建一个Skip2BrowserActivity文件，继承Activity，并创建activity_skip2browser.xml

2.在AndroidManifest.xml中注册Skip2BrowserActivity

3.在activity_skip2browser.xml中添加相关组件（跳转按钮）

4.在Skip2BrowserActivity中初始化部件,设置监听,创建意图内并往显式意图内添加跳转信息

```
adb shell "logcat | grep cmp" //获取应用Activity
```

```java
public class Skip2BrowserActivity extends Activity {

    private static final String TAG = "Skip2BrowserActivity";
    private Button mbutton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip2browser);
        initView();
        initListener();
    }

    private void initView() {
        mbutton = findViewById(R.id.button_skip2browser);
    }


    // cmp=org.chromium.webview_shell/.WebViewBrowserActivity
    private void initListener() {
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Skip2BrowserActivity");
                Intent intent = new Intent();
                //第一种写法
                //intent.setClassName("org.chromium.webview_shell","org.chromium.webview_shell.WebViewBrowserActivity");

                //第二种写法
ComponentName componentName = new ComponentName("org.chromium.webview_shell","org.chromium.webview_shell.WebViewBrowserActivity");
                intent.setComponent(componentName);

                startActivity(intent);
            }
        });
    }
}
```





### 四.隐式意图跳转到第三方应用（浏览器）

1.创建一个Skip2BrowserActivity文件，继承Activity，并创建activity_skip2browser.xml

2.在AndroidManifest.xml中注册Skip2BrowserActivity

3.在activity_skip2browser.xml中添加相关组件（跳转按钮）

4.在Skip2BrowserActivity中初始化部件,设置监听,创建意图内并往显式意图内添加跳转信息

```java
public class Skip2BrowserActivity extends Activity {

    private static final String TAG = "Skip2BrowserActivity";
    private Button mbutton_visible;
    private Button mbutton_invisible;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip2browser);
        initView();
        initListener();
    }

    private void initView() {
        mbutton_visible = findViewById(R.id.button_skip2browser_visible);
        mbutton_invisible = findViewById(R.id.button_skip2browser_invisible);
    }


    // cmp=org.chromium.webview_shell/.WebViewBrowserActivity
    private void initListener() {
        //显式意图跳转到浏览器
        mbutton_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Skip2BrowserActivityVisible");
                Intent intent = new Intent();
                //第一种写法
                //intent.setClassName("org.chromium.webview_shell","org.chromium.webview_shell.WebViewBrowserActivity");

                //第二种写法
                ComponentName componentName = new ComponentName("org.chromium.webview_shell","org.chromium.webview_shell.WebViewBrowserActivity");
                intent.setComponent(componentName);

                startActivity(intent);
            }
        });

        //隐式意图跳转到浏览器
        mbutton_invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Skip2BrowserActivityinVisible");
                Intent intent = new Intent();

                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}
```

