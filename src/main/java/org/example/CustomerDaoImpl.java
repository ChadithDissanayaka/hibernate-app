package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDaoImpl {
    public static void save(Customer customer) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        //update, delete, find by id, load all Home-work
    }
}
