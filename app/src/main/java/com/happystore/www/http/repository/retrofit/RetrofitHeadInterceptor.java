package com.happystore.www.http.repository.retrofit;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetrofitHeadInterceptor implements Interceptor {
    // 上下文
    private Context context;
    // 请求头 Token
    private String token = "";
    // 请求头 contentType
    private String contentType = "application/json; charset=UTF-8";
    // 请求头 AcceptEncoding
    private String AcceptEncoding = "*";
    // 请求头 Connection
    private String Connection = "keep-alive";
    // 请求头 Accept
    private String Accept = "*/*";
    // 请求头 AccessControlAllowOrigin
    private String AccessControlAllowOrigin = "*";
    // 请求头 AccessControlAllowHeaders
    private String AccessControlAllowHeaders = "X-Requested-With";
    // 请求头 Vary
    private String Vary = "Accept-Encoding";

    public RetrofitHeadInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
//        if(UserInfoUtils.getUserInfo() != null) {
//            builder.addHeader("user-token", UserInfoUtils.getUserInfo().getToken());
//        }
        builder.addHeader("Content-Type", contentType)
               .addHeader("Accept-Encoding", AcceptEncoding)
               .addHeader("Connection", Connection)
               .addHeader("Accept", Accept)
               .addHeader("Access-Control-Allow-Origin", AccessControlAllowOrigin)
               .addHeader("Access-Control-Allow-Headers", AccessControlAllowHeaders)
               .addHeader("Vary", Vary)
               .addHeader("way", "app");
        Request newRequest = builder.build();
        return chain.proceed(newRequest);
    }
}
