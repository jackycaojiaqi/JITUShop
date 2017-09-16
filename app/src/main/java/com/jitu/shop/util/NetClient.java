package com.jitu.shop.util;

import android.content.Context;
import android.content.Intent;

import com.jitu.shop.AppConstant;
import com.jitu.shop.callback.JsonCallBack;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.ui.LoginActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

import java.util.List;
import java.util.Map;


/**
 * Created by jacky on 2017/8/30.
 */
public class NetClient<T> {
    private Class<T> clazz;
    private static NetClient netClient;

    public NetClient(Class<T> clazz) {
        this.clazz = clazz;
    }

    //不能用单例
    public static <T> NetClient getInstance(Class<T> clazz) {
        netClient = new NetClient(clazz);
        return netClient;
    }

    public void Get(final Context context, String url, Map<String, String> params, final MyCallBack mCallback) {
        OkGo.<T>get(url)
                .tag(this)
                .params(params)
                .execute(new JsonCallBack<T>(clazz) {
                    @Override
                    public void onSuccess(Response<T> response) {
                        try {
                            //无论code是几  都返回给回调，处理等待弹窗
                            mCallback.onResponse(response);
                            BasePaserEntity orderListEntity = (BasePaserEntity) response.body();
                            if (orderListEntity.getErrorCode() == 0) {

                            } else if (orderListEntity.getErrorCode() == 101) {//token失效
                                Intent intent = new Intent(context, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                context.startActivity(intent);
                                ToastUtil.show(context, "token失效，请重新登录");
                            } else if (orderListEntity.getErrorCode() == 1) {//token失效
                                ToastUtil.show(context, "手机号码或密码错误");
                            } else if (orderListEntity.getErrorCode() == 2) {//token失效
                                ToastUtil.show(context, "传入参数异常");
                            } else if (orderListEntity.getErrorCode() == 3) {//token失效
                                ToastUtil.show(context, "两次密码不同");
                            } else if (orderListEntity.getErrorCode() == 4) {//token失效
                                ToastUtil.show(context, "不存在此数据");
                            } else if (orderListEntity.getErrorCode() == 400) {//token失效
                                ToastUtil.show(context, "数据库异常");
                            }

                            //当返回token不为空，则本地更新token值
                            if (!StringUtil.isEmptyandnull(orderListEntity.getToken())) {
                                SPUtil.put(context, AppConstant.TOKEN, orderListEntity.getToken());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Response<T> response) {
                        super.onError(response);
                        mCallback.onFailure(-1);
                    }
                });
    }
    public void Get(final Context context, String url, HttpParams params, final MyCallBack mCallback) {
        OkGo.<T>get(url)
                .tag(this)
                .params(params)
                .execute(new JsonCallBack<T>(clazz) {
                    @Override
                    public void onSuccess(Response<T> response) {
                        try {
                            //无论code是几  都返回给回调，处理等待弹窗
                            mCallback.onResponse(response);
                            BasePaserEntity orderListEntity = (BasePaserEntity) response.body();
                            if (orderListEntity.getErrorCode() == 0) {

                            } else if (orderListEntity.getErrorCode() == 101) {//token失效
                                Intent intent = new Intent(context, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                context.startActivity(intent);
                                ToastUtil.show(context, "token失效，请重新登录");
                            } else if (orderListEntity.getErrorCode() == 1) {//token失效
                                ToastUtil.show(context, "手机号码或密码错误");
                            } else if (orderListEntity.getErrorCode() == 2) {//token失效
                                ToastUtil.show(context, "传入参数异常");
                            } else if (orderListEntity.getErrorCode() == 3) {//token失效
                                ToastUtil.show(context, "两次密码不同");
                            } else if (orderListEntity.getErrorCode() == 4) {//token失效
                                ToastUtil.show(context, "不存在此数据");
                            } else if (orderListEntity.getErrorCode() == 400) {//token失效
                                ToastUtil.show(context, "数据库异常");
                            }

                            //当返回token不为空，则本地更新token值
                            if (!StringUtil.isEmptyandnull(orderListEntity.getToken())) {
                                SPUtil.put(context, AppConstant.TOKEN, orderListEntity.getToken());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Response<T> response) {
                        super.onError(response);
                        mCallback.onFailure(-1);
                    }
                });
    }
    public void Post(final Context context, String url, Map<String, String> params, final MyCallBack mCallback) {
        HttpParams httpParams = new HttpParams();
        OkGo.<T>post(url)
                .tag(this)
                .params(params)

                .execute(new JsonCallBack<T>(clazz) {
                    @Override
                    public void onSuccess(Response<T> response) {

                        try {
                            BasePaserEntity orderListEntity = (BasePaserEntity) response.body();
                            if (orderListEntity.getErrorCode() == 0) {
                                mCallback.onResponse(response);
                            } else if (orderListEntity.getErrorCode() == 101) {//token失效
                                Intent intent = new Intent(context, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                context.startActivity(intent);
                                ToastUtil.show(context, "token失效，请重新登录");
                            } else if (orderListEntity.getErrorCode() == 1) {//token失效
                                ToastUtil.show(context, "手机号码或密码错误");
                            } else if (orderListEntity.getErrorCode() == 2) {//token失效
                                ToastUtil.show(context, "传入参数异常");
                            } else if (orderListEntity.getErrorCode() == 3) {//token失效
                                ToastUtil.show(context, "两次密码不同");
                            } else if (orderListEntity.getErrorCode() == 4) {//token失效
                                ToastUtil.show(context, "不存在此数据");
                            } else if (orderListEntity.getErrorCode() == 400) {//token失效
                                ToastUtil.show(context, "数据库异常");
                            }
                            if (!StringUtil.isEmptyandnull(orderListEntity.getToken())) {
                                SPUtil.put(context, AppConstant.TOKEN, orderListEntity.getToken());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Response<T> response) {
                        super.onError(response);
                        mCallback.onFailure(-1);
                    }
                });

    }

    public void Post(final Context context, String url, Map<String, String> params, HttpParams httpParams, final MyCallBack mCallback) {
        OkGo.<T>post(url)
                .tag(this)
                .params(params)
                .params(httpParams)
                .execute(new JsonCallBack<T>(clazz) {
                    @Override
                    public void onSuccess(Response<T> response) {

                        try {
                            BasePaserEntity orderListEntity = (BasePaserEntity) response.body();
                            if (orderListEntity.getErrorCode() == 0) {
                                mCallback.onResponse(response);
                            } else if (orderListEntity.getErrorCode() == 101) {//token失效
                                Intent intent = new Intent(context, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                context.startActivity(intent);
                                ToastUtil.show(context, "token失效，请重新登录");
                            } else if (orderListEntity.getErrorCode() == 1) {//token失效
                                ToastUtil.show(context, "手机号码或密码错误");
                            } else if (orderListEntity.getErrorCode() == 2) {//token失效
                                ToastUtil.show(context, "传入参数异常");
                            } else if (orderListEntity.getErrorCode() == 3) {//token失效
                                ToastUtil.show(context, "两次密码不同");
                            } else if (orderListEntity.getErrorCode() == 4) {//token失效
                                ToastUtil.show(context, "不存在此数据");
                            } else if (orderListEntity.getErrorCode() == 400) {//token失效
                                ToastUtil.show(context, "数据库异常");
                            }
                            if (!StringUtil.isEmptyandnull(orderListEntity.getToken())) {
                                SPUtil.put(context, AppConstant.TOKEN, orderListEntity.getToken());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<T> response) {
                        super.onError(response);
                        mCallback.onFailure(-1);
                    }
                });

    }

    public void Cancle() {
        OkGo.getInstance().cancelAll();
    }
}
