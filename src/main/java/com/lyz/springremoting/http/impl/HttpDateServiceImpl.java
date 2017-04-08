package com.lyz.springremoting.http.impl;

import java.util.Date;

import org.springframework.remoting.RemoteService;
import org.springframework.remoting.ServiceType;

import com.lyz.springremoting.http.HttpDateService;

@RemoteService(serviceInterface = HttpDateService.class, serviceType = ServiceType.HTTP)
public class HttpDateServiceImpl implements HttpDateService {

    @Override
    public Date getDate() {
        return new Date();
    }
}
