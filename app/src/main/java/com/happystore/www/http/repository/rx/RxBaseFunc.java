package com.happystore.www.http.repository.rx;


import com.happystore.www.http.repository.dao.ApiResponse;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class RxBaseFunc<T> implements Function<ApiResponse<T>, Observable<ApiResponse<T>>> {
    @Override
    public Observable<ApiResponse<T>> apply(ApiResponse<T> bean) {
        if (bean.getCode() == 0) {
            return Observable.just(bean);
        } else {
            return Observable.error(new RxApiException(bean.getCode(), bean.getMsg()));
        }
    }
}
