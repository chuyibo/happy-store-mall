package com.happystore.www.http.repository.dao;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private T       data;
    private int     code;
    private String   msg;
}
