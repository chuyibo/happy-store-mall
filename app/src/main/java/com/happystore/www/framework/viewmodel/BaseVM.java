package com.happystore.www.framework.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.happystore.www.http.Api;
import com.happystore.www.http.repository.retrofit.RetrofitFactory;
import com.rxjava.rxlife.ScopeViewModel;

import io.reactivex.disposables.Disposable;

public class BaseVM extends ScopeViewModel {
    public MutableLiveData<Boolean> showProgressDialog = new MutableLiveData<>();
    public Disposable disposable;

    public final Api request;

    public BaseVM(@NonNull Application application) {
        super(application);
        request = RetrofitFactory.getInstance(application).create(Api.class);
    }
}
