package com.colak.customer.service;

import com.colak.customer.dao.CustomerDao;
import com.colak.customer.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void createCustomer(Customer customer) {
        log.info("SERVICE:   START - create customer");
    }

    public void deleteCustomer(Customer customer) {
        log.info("SERVICE: START - delete customer");
    }
}
