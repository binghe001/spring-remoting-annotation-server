package com.lyz.springremoting.rmi.impl;

import org.springframework.remoting.RemoteService;
import org.springframework.remoting.RmiServiceProperty;
import org.springframework.remoting.ServiceType;

import com.lyz.springremoting.rmi.RmiDateService;

import java.util.Date;

@RemoteService(serviceInterface = RmiDateService.class, serviceType = ServiceType.RMI)
@RmiServiceProperty(registryPort = 1099)
public class RmiDateServiceImpl implements RmiDateService{
    @Override
    public Date getDate() {
        return new Date();
    }
}
