package com.example.administrator.mobileshop01.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentTransaction;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.common.Constants;
import com.example.administrator.mobileshop01.entity.MemberEntity;
import com.example.administrator.mobileshop01.fragment.NavigationFragment;
import com.example.administrator.mobileshop01.http.ProgressDialogSubscriber;
import com.example.administrator.mobileshop01.http.presenter.MemberPresenter;
import com.example.administrator.mobileshop01.http.server.GoodsService;
import com.example.administrator.mobileshop01.utils.JsonResult;
import com.example.administrator.mobileshop01.utils.JsonResultGet;
import com.example.administrator.mobileshop01.utils.JsonResultPost;
import com.example.administrator.mobileshop01.utils.Person;
import com.example.administrator.mobileshop01.utils.PostWithUrl;
import com.example.administrator.mobileshop01.utils.Tools;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;


public class MainActivity extends BaseActivity {
    private NavigationFragment navigationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        navigationFragment=new NavigationFragment();
        transaction.add(R.id.main_fragment,navigationFragment);
        transaction.commit();

        /**
         * 调用get请求测试方法
         */
        //testGet40http();
        //testPost40khttp();

        /**
         * Gson的简单使用
         */
//        testJson(Tools.getAssetsFile(this,"testjson1.txt"));
//        testJsonArr(Tools.getAssetsFile(this,"testjson2.txt"));
//        testJsonOneData(Tools.getAssetsFile(this,"testjson1.txt"));
//
//        DbUtils db=new DbUtils(this);
//        db.add();
//        db.selectAllData();
//
//        testRetrofitGet1();
//        testRetrofitGet2();
//        testRetrofitPost1();
//        testRetrofitPost2();
//        testRetrofitPost3();

        /**
         * 使用公共封装类
         */
        MemberPresenter.register(new Subscriber< MemberEntity >() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MemberEntity memberEntity) {

            }
        },"cjc","cjc89684550","caijiachen34@1126.com");

        /**
         * 使用带加载动画的订阅者
         */
        MemberPresenter.login(new ProgressDialogSubscriber< MemberEntity >(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
            Log.i("=====","success===="+memberEntity.toString());
            }
        },"cjc","cjc89684550");

    }




    public void changeTab(int tab){
        switch (tab){
            case 1:
                this.navigationFragment.setTabSelection(R.id.tab_item_home);
                break;
            case 2:
                this.navigationFragment.setTabSelection(R.id.tab_item_category);
                break;
            case 3:
                this.navigationFragment.setTabSelection(R.id.tab_item_cart);
                break;
            case 4:
                this.navigationFragment.setTabSelection(R.id.tab_item_personal);
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String action = intent.getStringExtra("action");
        if ("toIndex".equals(action)) {
            changeTab(1);
        }
    }

    @Override
    public void onBackPressed() {
        if (navigationFragment.currentId!=R.id.tab_item_home){
            changeTab(1);
            return;
        }
    }

    /**
     *商城App，需要图片，优化图片加载，需要图片加载框架UIL
     * 1.加入UIL依赖
     * 2.添加外部存储设备读取权限
     * 3.添加图片加载管理类
     * 4。完成管理类并初始化
     */



    /**
     *Retrofit rxjava联合封装
     * 1.依赖引入
     * 2.添加MemberService接口
     * 3.实现公共封装类
     * 4。实现对应的业务类（实际方法）
     * 5.使用公共方法
     * 6.封装一个带有加载进度的订阅者
     */



    /**
     * GreemDao数据库框架的学习使用
     * 1.添加的实体类后，添加依赖，GreenDao在添加依赖时细节比其他库多一点
     * 2.依赖添加正确之后添加数据库实体类
     * 3.自动生成GreenDao所需文件，下面是全局配置
     * 4.添加一个测试类，测试数据库是否正常
     */


    /**
     * Retrofit网路框架的学习，基于Okhttp用于请求TRESTful风格接口的HTTP的请求框架
     * 1.引入依赖
     * 2.添加商品数据实体类
     * 3.创建对应网络接口
     * 4.测试框架的功能
     */
    //Retrofit可能与okhttp冲突，先注释okttp
    public void testRetrofitGet1(){
        //创建客户端
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) //设置访问地址
                .addConverterFactory(GsonConverterFactory.create()) //设置解析方式为Gson
                .build();
        GoodsService goodsService =retrofit.create(GoodsService.class);
        Call<JsonResult>task= goodsService.getJson("keji","f3c68b23dc99865f20120175607e2adc");

        task.enqueue(new Callback<JsonResult>() {
            @Override
            public void onResponse(Call<JsonResult> call, Response<JsonResult> response) {
                Log.d("====","get1===="+response.code());
                Log.d("====","get1====="+response.body());
            }

            @Override
            public void onFailure(Call<JsonResult> call, Throwable t) {
                Log.i("===========","get===========请求失败");
            }
        });
    }




    //Retrofit可能与okhttp冲突，先注释okttp
    public void testRetrofitGet2(){
        //创建客户端
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) //设置访问地址
                .addConverterFactory(GsonConverterFactory.create()) //设置解析方式为Gson
                .build();
        GoodsService goodsService =retrofit.create(GoodsService.class);
        Map<String,String>params=new HashMap<>();
        params.put("type","keji");
        params.put("key","f3c68b23dc99865f20120175607e2adc");
        Call<JsonResultGet>task= goodsService.getJson2(params);
        //Call<JsonResult>task =api.getJson("keji","f3c68b23dc99865f20120175607e2adc");

        task.enqueue(new Callback<JsonResultGet>() {
            @Override
            public void onResponse(Call<JsonResultGet> call, Response<JsonResultGet> response) {


                //JsonResult<JsonResult> body = response.body();
                Log.d("====","get2===="+response.code());
                Log.d("====","get2====="+response.body());
                //List<JsonResult>list=response.body();
//                if(list!=null&&list.size()>0){
//                    String title=list.get(0).toString();
//                    Log.i("===========","===========请求成功"+title);
//                }else {
//                    Log.i("===========","===========数据为空");
//                }

            }

            @Override
            public void onFailure(Call<JsonResultGet> call, Throwable t) {
                Log.i("===========","get===========请求失败");
            }
        });
    }


    private void testRetrofitPost1() {
        //String url="/toutiao/index?type=shishang&key=f3c68b23dc99865f20120175607e2adc";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) //设置访问地址
                .addConverterFactory(GsonConverterFactory.create()) //设置解析方式为Gson
                .build();
        GoodsService goodsService =retrofit.create(GoodsService.class);
        Map<String,String>params=new HashMap<>();
        params.put("type","shishang");
        params.put("key","f3c68b23dc99865f20120175607e2adc");
        Call<JsonResultPost>task= goodsService.postJson(params);
        task.enqueue(new Callback<JsonResultPost>() {
            @Override
            public void onResponse(Call<JsonResultPost> call, Response<JsonResultPost> response) {
                Log.d("====","post===="+response.code());
                Log.d("====","post====="+response.body());
            }

            @Override
            public void onFailure(Call<JsonResultPost> call, Throwable t) {
                Log.i("===========","post===========请求失败");
            }
        });
    }


    private void testRetrofitPost2() {//url post
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) //设置访问地址
                .addConverterFactory(GsonConverterFactory.create()) //设置解析方式为Gson
                .build();
        GoodsService goodsService =retrofit.create(GoodsService.class);
        String url="/toutiao/index?type=shishang&key=f3c68b23dc99865f20120175607e2adc";
        Call<PostWithUrl>task= goodsService.PostWithUrl(url);
        task.enqueue(new Callback<PostWithUrl>() {
            @Override
            public void onResponse(Call<PostWithUrl> call, Response<PostWithUrl> response) {
                Log.d("====","post2===="+response.code());
                Log.d("====","post2====="+response.body());
            }

            @Override
            public void onFailure(Call<PostWithUrl> call, Throwable t) {
                Log.i("===========","post2===========请求失败");
            }
        });
    }




    private void testRetrofitPost3() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) //设置访问地址
                .addConverterFactory(GsonConverterFactory.create()) //设置解析方式为Gson
                .build();
        GoodsService goodsService =retrofit.create(GoodsService.class);
        Map<String,String>params=new HashMap<>();
        params.put("type","shishang");
        params.put("key","f3c68b23dc99865f20120175607e2adc");
        Call<JsonResultPost>task= goodsService.postJson(params);
        task.enqueue(new Callback<JsonResultPost>() {
            @Override
            public void onResponse(Call<JsonResultPost> call, Response<JsonResultPost> response) {
                Log.d("====","post3===="+response.code());
                Log.d("====","post3====="+response.body());
            }

            @Override
            public void onFailure(Call<JsonResultPost> call, Throwable t) {
                Log.i("===========","post===========请求失败");
            }
        });
    }




    /**
     * Gson解析数据方法
     * 要使用Gson我们还需添加依赖
     * 添加Person实体类和对应的解析方法
     *
     */


    /**
     * 将json数据转化为对象
     * @param jsonString
     */
    public void testJson(String jsonString){
        JsonObject jsonObject=new JsonParser().parse(jsonString).getAsJsonObject();
        Gson gson=new Gson();
        Person p=gson.fromJson(jsonObject.get("data"),Person.class);
        Log.i("===对象","===="+p.toString());
        Log.i("===对象","===="+Tools.getAssetsFile(this,"testjson1.txt"));


    }

    /**
     * 将数据转化成List
     */
    public void testJsonArr(String jsonstr){
        JsonObject jsonObject=new JsonParser().parse(jsonstr).getAsJsonObject();
        Gson gson=new Gson();
        List<Person> personList=gson.fromJson(jsonObject.getAsJsonArray("data"),new TypeToken<List<Person>>(){}.getType());
        /**
         * 测试是否转换正确
         */
        for(int i=0;i<personList.size();i++){
            Log.i("====哈哈哈哈哈哈哈哈哈哈哈哈哈",i+"===="+personList.get(i).toString());
        }
    }

    /**
     * 如果我们只要取出一个JSON数据中的某一个字段
     */

    public void testJsonOneData(String jsonStr){
        JsonObject jsonObject=new JsonParser().parse(jsonStr).getAsJsonObject();
        String name=jsonObject.get("data").getAsJsonObject().get("name").getAsString();
        Log.i("==========","===只输出了name字段的数据==="+name);
    }


    /**
     * OKHttp
     */
//    public void testGet40http(){
//      //创建客户端
//        OkHttpClient okHttpClient=new OkHttpClient();
//      //创建请求内容
//        Request request=new Request.Builder()
//                .url("http://www.baidu.com")
//                .get()
//                .build();

//      //用client创建请求任务
//        Call call=okHttpClient.newCall(request);//将请求给OkhttpClient
//      //异步请求
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                /**
//                 * 请求失败
//                 */
//                Log.i("===========","1====请求失败"+e.getMessage());
//
//
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                /**
//                 * 请求成功
//                 */
//                Log.i("===========","1====请求成功>"+response.body().string());
//            }
//        });
//    }

//    public void testPost40khttp(){
//          //创建客户端
//        OkHttpClient client=new OkHttpClient();
//          //
//        RequestBody requestBody=new FormBody.Builder()
//                .add("id","123")
//                .add("name","lisi")
//                .add("password","jack123456")
//                .build();
//
//          //创建请求内容
//        Request request=new Request.Builder()
//                .url("http://www.baidu.com")
//                .post(requestBody)
//                .build();
//
//      //浏览器创建任务
//        Call call=client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                /**
//                 * 请求失败
//                 */
//                Log.i("===========","2====请求失败"+e.getMessage());
////                e.getMessage();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                /**
//                 * 请求成功
//                 */
//                Log.i("===========","2====请求成功>"+response.body().string());
//            }
//        });
//    }
}
