package com.example.administrator.mobileshop01.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;

import com.example.administrator.mobileshop01.R;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

public class ImageLoaderManager {
    private static ImageLoaderManager mInstance;
    public static ImageLoaderManager getInstance(){
        if (mInstance==null){
            synchronized (ImageLoaderManager.class){
                if (mInstance==null)
                    mInstance=new ImageLoaderManager();
            }
        }
        return mInstance;
    }

    /**
     * 调用相关设置
     */
    public ImageLoaderManager(){
        if (mInstance==null){
            //采用自定义配置
            ImageLoader.getInstance().init(customImageLoaderConfig(MyApplication.getContext()));

            //采用默认配置
            //ImageLoader.getInstance().init(defaultImageLoaderConfig());
        }
    }

    private ImageLoaderConfiguration imageLoaderConfiguration(){
        return ImageLoaderConfiguration.createDefault(MyApplication.getContext());
    }

    private ImageLoaderConfiguration customImageLoaderConfig(Context context){
        File cacheDir= StorageUtils.getCacheDirectory(context);//缓存文件夹路径
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480,800)//内存文件的最大长度
                .memoryCacheSize(2*1024*1024)//内存缓存的最大值
                .memoryCacheSizePercentage(13)
                .diskCacheSize(50*1024*1024)//设置SDK存储大小
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .threadPoolSize(3)//线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY-2)//设置当前线程的优先级
                .denyCacheImageMultipleSizesInMemory()
                .imageDownloader(new BaseImageDownloader(context))
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple().createSimple())
                .build();
        return config;
    }


    public static DisplayImageOptions product_options=new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loading)//设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.image_empty)//设置图片url为空或者错误时的显示图片
            .showImageOnFail(R.drawable.image_error)//设置图片加载或解码过程中出错的图片
            .resetViewBeforeLoading(false)//设置图片在加载前是否重置，复位
            .delayBeforeLoading(1000)//下载的延迟时间
            .cacheInMemory(false)//设置下载图片是否缓存到内存
            .cacheOnDisk(false)//设置下载图片是否缓存到SD卡
            .considerExifParams(false)//启用EXIF和JPEG图像格式
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//设置图片的编码格式
            .bitmapConfig(Bitmap.Config.ARGB_8888)//设置图片的解码类型
            .displayer(new SimpleBitmapDisplayer())//设置图片的圆角还是默认格式 new RoundedBitmapDisplayer(20)设置圆角
            .handler(new Handler())
            .build();


    public static DisplayImageOptions user_options=new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loading)//设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.image_empty)//设置图片url为空或者错误时的显示图片
            .showImageOnFail(R.drawable.image_error)//设置图片加载或解码过程中出错的图片
            .resetViewBeforeLoading(false)//设置图片在加载前是否重置，复位
            .delayBeforeLoading(1000)//下载的延迟时间
            .cacheInMemory(false)//设置下载图片是否缓存到内存
            .cacheOnDisk(false)//设置下载图片是否缓存到SD卡
            .considerExifParams(false)//启用EXIF和JPEG图像格式
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//设置图片的编码格式
            .bitmapConfig(Bitmap.Config.ARGB_8888)//设置图片的解码类型
            .displayer(new SimpleBitmapDisplayer())//设置图片的圆角还是默认格式 new RoundedBitmapDisplayer(20)设置圆角
            .handler(new Handler())
            .build();

    /**
     * 清理内存缓存
     */
    public void onClearMemoryClick(View view){
        ImageLoader.getInstance().clearDiskCache();
    }

    /**
     * 清理本地缓存
     */
    public void onClearDiskClick(View view){
        ImageLoader.getInstance().clearMemoryCache();
    }

}
