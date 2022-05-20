package com.happystore.www.utils;

import java.util.ArrayList;
import java.util.List;

public class ListBuilderUtils<T> {

    private ArrayList<T> innerList;

    public static <T> ListBuilderUtils<T> build(Class<T> clazz) {
        return new ListBuilderUtils<T>();
    }

    public ListBuilderUtils<T> add(T t) {
        if (null == innerList) {
            innerList = new ArrayList<>();
        }
        innerList.add(t);
        return this;
    }

    public ArrayList<T> get() {
        return innerList;
    }
}
