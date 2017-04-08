package org.springframework.remoting;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 自定义RemoteService注解
 * @author liuyazhuang
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RemoteService {

    ServiceType serviceType() default ServiceType.HTTP;

    Class<?> serviceInterface();
}
