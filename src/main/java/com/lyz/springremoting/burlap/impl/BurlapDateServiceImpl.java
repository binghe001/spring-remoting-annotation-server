package com.lyz.springremoting.burlap.impl;

import org.springframework.remoting.RemoteService;
import org.springframework.remoting.ServiceType;

import com.lyz.springremoting.burlap.BurlapDateService;

import java.util.Date;

@RemoteService(serviceInterface = BurlapDateService.class, serviceType = ServiceType.BURLAP)
public class BurlapDateServiceImpl implements BurlapDateService {
    @Override
    public Date getDate() {
        return new Date();
    }
}
