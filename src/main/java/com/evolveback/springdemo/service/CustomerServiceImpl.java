package com.evolveback.springdemo.service;

import com.evolveback.springdemo.dao.CustomerDAO;
import com.evolveback.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mithun on 8/1/17.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    //need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getCustomers() {

    return customerDAO.getCustomers();
    }

    @Transactional
    public void saveCustomer(Customer theCustomer) {

        customerDAO.saveCustomer(theCustomer);

    }

    @Transactional
    public Customer getCustomer(int theId) {

        return customerDAO.getCustomer(theId);
    }

    @Transactional
    public void deleteCustomer(int theId) {

        customerDAO.deleteCustomer(theId);
    }
}
