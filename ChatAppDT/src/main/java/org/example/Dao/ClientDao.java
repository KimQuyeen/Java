package org.example.Dao;

import org.example.Entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDao {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Initialize Hibernate session factory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Save Client
    public boolean saveClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                // Begin transaction
                transaction = session.beginTransaction();

                // Save client object
                session.save(client);

                // Commit the transaction
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction != null) {
                    // Rollback transaction in case of failure
                    transaction.rollback();
                }
                e.printStackTrace();
                return false;
            }
        }
    }

    // Get All Clients
    public List<Client> getAllClients() {
        try (Session session = sessionFactory.openSession()) {
            // No need for explicit transaction for read operations

            // Retrieve list of clients
            return session.createQuery("from Client", Client.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            // Return empty list or handle the exception as needed
            return null;
        }
    }
}
