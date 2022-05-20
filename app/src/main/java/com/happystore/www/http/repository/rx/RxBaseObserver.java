package com.happystore.www.http.repository.rx;

import com.google.gson.JsonSyntaxException;
import com.happystore.www.framework.viewmodel.BaseVM;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class RxBaseObserver<T> implements Observer<T> {

    public BaseVM vm;

    public RxBaseObserver(BaseVM vm) {
        this.vm = vm;

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable disposable) {
        vm.disposable = disposable;
    }

    @Override
    public void onNext(T value) {
        success(value);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof TimeoutException || e instanceof SocketTimeoutException || e instanceof ConnectException || e instanceof UnknownHostException) {
            timeOut();
        } else if (e instanceof JsonSyntaxException) {
            error(-1,"Json 解析出错" + e.toString());
        } else if (e instanceof RxApiException) {
            // 网络请求出错
            RxApiException apiException = (RxApiException) e;
            if (apiException.getCode() == 101 || apiException.getCode() == 102 || apiException.getCode() == 103 || apiException.getCode() == 104 || apiException.getCode() == 105 ||
                apiException.getCode() == 106 ||
                apiException.getCode() == 107) {
//                RxBus.get().post(AppConfig.EventType.EVENT_TYPE_TOKEN_OVER_TIME,"null");
                error(apiException.getCode(),apiException.getMsg());
            } else {
                // 网络请求出错
                error(apiException.getCode(),apiException.getMsg());
            }
        } else {
            error(-1,e.getMessage());
        }
    }

    protected void error(int code, String errorMsg) {
    }

    protected abstract void success(T value);
    protected void timeOut() {
        error(-100,"网络链接超时");
    };
}
