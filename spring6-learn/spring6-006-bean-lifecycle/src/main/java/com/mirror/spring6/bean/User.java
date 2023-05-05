package com.mirror.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware , BeanClassLoaderAware , BeanFactoryAware , InitializingBean, DisposableBean {
    private String name;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("-/-/3、此Bean的类加载器: "+classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("-/-/3、此类的Bean工厂: "+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("-/-/3、此Bean的id: "+name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("-/-/9、DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-/-/5.afterPropertiesSet执行");
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
        System.out.println("1、实例化bean对象");
    }

    public void setName(String name) {
        System.out.println("2、给bean对象赋值");
        this.name = name;
    }

    public void initBean(){
        System.out.println("3/4/6、初始化bean对象");
    }

    public void destroyBean(){
        System.out.println("5/7/10、销毁bean对象");
    }

}
