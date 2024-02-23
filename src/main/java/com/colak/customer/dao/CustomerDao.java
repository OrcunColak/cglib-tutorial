package com.colak.customer.dao;

import com.colak.customer.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDao {

    private static final Logger log = LoggerFactory.getLogger(CustomerDao.class);
    public void createCustomer(Customer customer) {
        log.info("DAO: START: create customer");

        log.info("DAO: END: create customer");
    }

    public void deleteCustomer(Customer customer) {
        log.info("DAO: START: delete customer");

        log.info("DAO: END: delete customer");
    }
}
