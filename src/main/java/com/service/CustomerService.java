package com.service;

import com.entity.Customer;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerService {

    private static Logger LOGGER = Logger.getLogger(CustomerService.class.getSimpleName());

    public void save(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
            LOGGER.log(Level.INFO, String.format("Save student success with rollnumber %s", customer.getId()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, String.format("Save student error, stack trace"), e);
        }
    }

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            customers = session.createQuery("from Customer", Customer.class).list();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Can not findAll student, stack trace"), e);
        }
        return customers;
    }

    public Customer findById(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, String.format("Can not findById %s student, stack trace", id), e);
            return null;
        }
    }

    public void delete(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            if (customer != null) {
                session.delete(customer);
                LOGGER.log(Level.INFO, String.format("Delete student success with rollnumber %s", id));
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, String.format("Can not delete student with rollnumber %s, stack trace", id), e);
        }
    }
}
