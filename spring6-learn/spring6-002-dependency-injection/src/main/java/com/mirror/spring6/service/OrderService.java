package com.mirror.spring6.service;

import com.mirror.spring6.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    public void save(){
        orderDao.insert();
    }
}
