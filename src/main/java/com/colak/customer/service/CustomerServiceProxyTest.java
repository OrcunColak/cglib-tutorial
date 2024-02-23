package com.colak.customer.service;

import com.colak.customer.dao.CustomerDao;
import com.colak.customer.model.Customer;
import net.sf.cglib.proxy.Enhancer;

// VM argument should be "--add-opens java.base/java.lang=ALL-UNNAMED"
public class CustomerServiceProxyTest {

    public static void main(String[] args) {

        // 1. Creating and Enhancer:
        // We need to create an instance of Enhancer which is a class provided by CGLib for enhancing (creating proxies for) classes.
        Enhancer enhancer = new Enhancer();

        // 2. Setting the superclass: We need to specify the superclass (target class) for which we need to create a proxy.
        // In this case CustomerService.class
        enhancer.setSuperclass(CustomerService.class);

        // 3. Setting the callback: A callback by providing an instance of the implementation of MethodInterceptor.
        // In our case it is ProxyMethodInterceptor.
        enhancer.setCallback(new ProxyMethodInterceptor());

        // 4. Creating the proxy: Create the proxy using enhancer.create method.
        // This method allows to specify constructor arguments for target class. In our case CustomerDao.class
        Class<?>[] argumentTypes = {CustomerDao.class};
        Object[] arguments = {new CustomerDao()};
        CustomerService customerService = (CustomerService) enhancer.create(argumentTypes, arguments);

        Customer customer = new Customer();
        customerService.createCustomer(customer);
    }
}
