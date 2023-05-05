package com.mirror;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {
    private Map<Thread,T> map=new HashMap<Thread,T>();

    public void set(T t){
        map.put(Thread.currentThread(),t);
    }
    public T get(){
        return map.get(Thread.currentThread());
    }
    public void remove(){
        map.remove(Thread.currentThread());
    }
}
