package com.happystore.www.http.repository.retrofit;

import android.content.Context;

import com.safframework.http.interceptor.AndroidLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private volatile static RetrofitFactory instance;
    private Retrofit retrofit;

    private RetrofitFactory(final Context context) {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.elements.top/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new RetrofitHeadInterceptor(context))
                        .addInterceptor(AndroidLoggingInterceptor.build(true,true))
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .build())
                .build();
    }

    public static RetrofitFactory getInstance(Context context) {
        if(instance==null) {
            synchronized (RetrofitFactory.class) {
                if(instance==null) {
                    instance=new RetrofitFactory(context);
                }
            }
        }
        return instance;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
