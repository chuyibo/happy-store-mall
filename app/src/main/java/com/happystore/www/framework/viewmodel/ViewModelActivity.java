package com.happystore.www.framework.viewmodel;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import com.happystore.www.framework.base.BaseActivity;

import java.lang.reflect.ParameterizedType;


public abstract class ViewModelActivity<VM extends BaseVM, DB extends ViewDataBinding>
        extends BaseActivity<DB> {

    public ProgressDialog progressDialog;
    public VM vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
        initProgressDialog();
        initProgressDialogListener();
    }

    public void initProgressDialog() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.setCancelable(false);

        progressDialog.setOnKeyListener((d,i,k) -> {
            progressDialog.dismiss();
            if(vm.disposable != null && !vm.disposable.isDisposed()) vm.disposable.dispose();
            return false;
        });
    };

    public void initProgressDialogListener() {
        vm.showProgressDialog.observe(this, value -> {
            if(value) {
                progressDialog.show();
            } else {
                progressDialog.dismiss();
            }
        });
    }

    public void initViewModel() {
        Class<VM> vmClass = (Class<VM>) ((ParameterizedType)this
                        .getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];

        vm = ViewModelProviders.of(this).get(vmClass);
        db.setLifecycleOwner(this);
    };
}
