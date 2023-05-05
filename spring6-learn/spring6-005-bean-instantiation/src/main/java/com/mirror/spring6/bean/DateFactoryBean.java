package com.mirror.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactoryBean implements FactoryBean<Date> {
    private String birth;
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    public DateFactoryBean(String birth) {
        this.birth = birth;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(this.birth);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
