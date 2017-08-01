package com.evolveback.springdemo.dao;

import com.evolveback.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mithun on 8/1/17.
 */

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query ... sort by last name
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by lastName",
                                               Customer.class);

        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        //return the results
        return customers;
    }

    public void saveCustomer(Customer theCustomer) {

        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save/update the customer
        currentSession.saveOrUpdate(theCustomer);
    }

    public Customer getCustomer(int theId) {

        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //now retrieve / read from database using the primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    public void deleteCustomer(int theId) {

        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //delete the customer from database using the primary key
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();
    }
}
