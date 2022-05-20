package com.happystore.www.framework.viewmodel;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import com.happystore.www.framework.base.BaseFragment;

import java.lang.reflect.ParameterizedType;


public abstract class ViewModelFragment<VM extends BaseVM, DB extends ViewDataBinding>
        extends BaseFragment<DB> {

    public ProgressDialog progressDialog;
    public VM vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if(isInit == 0)initProgressDialog();
        if(isInit == 0)initProgressDialogListener();
        return view;
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
        vm.showProgressDialog.observe(getActivity(), value -> {
            if(value) {
                progressDialog.show();
            } else {
                progressDialog.dismiss();
            }
        });
    }

    public void bindViewModel() {
        Class<VM> vmClass = (Class<VM>) ((ParameterizedType)this
                        .getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];

        vm = ViewModelProviders.of(this).get(vmClass);
    }
}
