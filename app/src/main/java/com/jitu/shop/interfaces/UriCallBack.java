package com.jitu.shop.interfaces;

import android.net.Uri;

import com.lzy.okgo.model.Response;

/**
 * Created by jacky on 2017/8/30.
 */
public interface UriCallBack<T> {

    //链接失败执行的方法
    void onResponse(Uri uri);//方法参数根据个人需求写，可以是字符串，也可以是输入流

}
