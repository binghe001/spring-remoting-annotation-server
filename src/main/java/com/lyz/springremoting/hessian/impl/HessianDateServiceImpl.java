package com.lyz.springremoting.hessian.impl;

import org.springframework.remoting.RemoteService;
import org.springframework.remoting.ServiceType;

import com.lyz.springremoting.hessian.HessianDateService;

import java.util.Date;

@RemoteService(serviceInterface = HessianDateService.class, serviceType = ServiceType.HESSIAN)
public class HessianDateServiceImpl implements HessianDateService {
    @Override
    public Date getDate() {
        return new Date();
    }
}
