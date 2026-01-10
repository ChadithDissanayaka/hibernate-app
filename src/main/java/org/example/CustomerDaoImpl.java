package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CustomerDaoImpl {
    //Create
    public static void save(Customer customer) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                ex.printStackTrace();
            }
        }
    }
    // Update
    public static void update(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        }
    }

    // Delete
    public static void delete(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        }
    }

    // FindById
    public static Customer findById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id);
        }
    }

    // GetAll
    public static List<Customer> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Customer", Customer.class).list();
        }
    }
}
