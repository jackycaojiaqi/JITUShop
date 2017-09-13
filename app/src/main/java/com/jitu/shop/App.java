package com.jitu.shop;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.jitu.shop.ui.MainActivity;
import com.jitu.shop.util.LiteOrmDBUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.MemoryCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.vondear.rxtools.RxUtils;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;

/**
 * Created by jacky on 2017/8/28.
 */
public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化 okgo
        initOkGo();
        //初始化工具类
        RxUtils.init(this);
        Beta.autoCheckUpgrade = false;
        Beta.initDelay = 2 * 1000;
        Beta.showInterruptedStrategy = false;
        Beta.canShowUpgradeActs.add(MainActivity.class);
        Bugly.init(getApplicationContext(), "4ab93d8a42", true);
        JPushInterface.init(getApplicationContext());//初始化极光推送
        JPushInterface.setDebugMode(true);
//        JPushInterface.initCrashHandler(getApplicationContext());
        LiteOrmDBUtil.createDb(getApplicationContext(), "jitushop");
    }

    private void initOkGo() {
        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
//        HttpHeaders headers = new HttpHeaders();
//        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文
//        headers.put("commonHeaderKey2", "commonHeaderValue2");
//        HttpParams params = new HttpParams();//公共token参数
        //-----------------------------------------------------------------------------------//

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        //全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //使用内存保持cookie，app退出后，cookie消失
        builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));

        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        //-------------------------------------------------------------------------------------//
        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(builder.build())               //必须设置OkHttpClient
                .setRetryCount(3);                          //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
    }
}
