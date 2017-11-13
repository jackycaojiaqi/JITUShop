package com.jitu.shop.callback;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.jitu.shop.util.LogUtil;
import com.lzy.okgo.callback.AbsCallback;
import com.socks.library.KLog;

import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by jacky on 2017/6/27.
 */
public abstract class JsonCallBack<T> extends AbsCallback<T> {
    private Type type;
    private Class<T> clazz;

    public JsonCallBack(Type type) {
        this.type = type;
    }

    public JsonCallBack(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T convertResponse(Response response) throws Throwable {
        T date = null;
        try {
            ResponseBody body = response.body();

            if (body == null) return null;
            date = null;
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(body.charStream());
            if (type != null) date = gson.fromJson(jsonReader, type);
            if (clazz != null) date = gson.fromJson(jsonReader, clazz);
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public void onSuccess(com.lzy.okgo.model.Response<T> response) {
        KLog.e("onSuccess");
    }

    @Override
    public void onError(com.lzy.okgo.model.Response<T> response) {
        KLog.e("onError");
    }
}
