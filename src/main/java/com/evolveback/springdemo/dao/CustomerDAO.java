package com.evolveback.springdemo.dao;

import com.evolveback.springdemo.entity.Customer;

import java.util.List;

/**
 * Created by mithun on 8/1/17.
 */
public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
