package org.springframework.remoting;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.rmi.registry.Registry;


/**
 * 自定义RmiServiceProperty注解
 * @author liuyazhuang
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RmiServiceProperty {
    int registryPort() default Registry.REGISTRY_PORT;
}
