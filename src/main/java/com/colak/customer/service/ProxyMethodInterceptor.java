package com.colak.customer.service;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class ProxyMethodInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ProxyMethodInterceptor.class);

    @Override
    public Object intercept(final Object obj, final Method method, final Object[] args, final MethodProxy proxy) throws Throwable {
        try {
            beginTransaction();
            final Object invoke = proxy.invokeSuper(obj, args);
            commitTransaction();
            return invoke;
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }

    private void beginTransaction() {
        logger.debug("===============BEGIN TRANSACTION===============");
    }

    private void commitTransaction() {
        logger.debug("===============COMMIT TRANSACTION===============");
    }

    private void rollbackTransaction() {
        logger.error("===============ROLLBACK TRANSACTION===============");
    }

}
