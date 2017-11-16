package com.jitu.shop.interfaces;

import com.jitu.shop.callback.JsonCallBack;
import com.lzy.okgo.model.Response;

import java.util.Objects;

/**
 * Created by jacky on 2017/8/30.
 */
public interface MyCallBack<T>  {

    //链接失败执行的方法
    void onResponse( Response<T> object);//方法参数根据个人需求写，可以是字符串，也可以是输入流

    //链接成功执行的方法
    void onFailure(int code);//方法参数用int数据类型，相当于是一个标识

}
