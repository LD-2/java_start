package com.mirror.demo02;

/**
 *<T>泛型标识 类型形参
 * 创建对象的时候显示定义数据类型
 */
public class Generic <T>{
    private T key;

    public Generic() {
    }

    public Generic(T key) {
        this.key = key;
    }
    public T getKey(){
        return key;
    }
}
