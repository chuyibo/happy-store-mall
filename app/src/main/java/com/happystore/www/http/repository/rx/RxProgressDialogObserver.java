package com.happystore.www.http.repository.rx;


import androidx.lifecycle.MutableLiveData;

import com.happystore.www.framework.viewmodel.BaseVM;


public abstract class RxProgressDialogObserver<T> extends RxBaseObserver<T> {

    public MutableLiveData<Boolean> dialogCut;
    public boolean showDialog;

    public long    createTime;
    public long    flag = 500;

    public RxProgressDialogObserver(boolean showDialog, BaseVM vm) {
        super(vm);
        this.dialogCut  =  vm.showProgressDialog;
        this.showDialog = showDialog;

        if(showDialog) {
            createTime = System.currentTimeMillis();
            dialogCut.postValue(true);
        }
    }

    @Override
    public void onError(Throwable e) {
        if(showDialog) {
            try {
                dismissDialog();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        super.onError(e);
    }

    @Override
    public void onNext(T value) {
        if(showDialog) {
            try {
                dismissDialog();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.onNext(value);
    }

    public void dismissDialog() throws InterruptedException {
        long endTime = System.currentTimeMillis();
        if(endTime - createTime < flag) Thread.sleep(flag - (endTime - createTime));

        dialogCut.postValue(false);
    }
}
