package org.khnure.database;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.khnure.models.User;
import java.util.List;


public class DatabaseManager {
    public void createUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
//            session.save(user);
            transaction.commit();
        }
    }

    public User getUserById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    public List<User> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    public void deleteUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
//            session.delete(user);
            transaction.commit();
        }
    }
}
