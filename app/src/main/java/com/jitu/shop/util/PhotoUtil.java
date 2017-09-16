package com.jitu.shop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jitu.shop.interfaces.UriCallBack;
import com.socks.library.KLog;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/**
 * Created by jacky on 2017/9/16.
 */
public class PhotoUtil {
    public static Bitmap getBitmap(String url) {

        Bitmap bm = null;
        try {
            URL iconUrl = new URL("file://" + url);
            URLConnection conn = iconUrl.openConnection();
            HttpURLConnection http = (HttpURLConnection) conn;
            int length = http.getContentLength();
            conn.connect();
            // 获得图像的字符流
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is, length);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();// 关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bm;
    }

    public static Uri uri = null;
    public static Bitmap myBitmap = null;

    public static void getUri(final Context context, final String url, final UriCallBack uriCallBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myBitmap = Glide.with(context)
                            .load(url)
                            .asBitmap() //必须
                            .centerCrop()
                            .into(500, 500)
                            .get();

                    uri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), myBitmap, null, null));
                    uriCallBack.onResponse(uri);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
