package com.happystore.www.http.repository.rx;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class RxApiException extends Throwable {

    private int   code;
    private String msg;
}
