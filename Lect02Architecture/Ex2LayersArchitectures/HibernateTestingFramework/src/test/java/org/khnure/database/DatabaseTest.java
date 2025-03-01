package org.khnure.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hibernate.Session;
import org.khnure.models.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private DatabaseManager dbManager;

    @BeforeEach
    public void setUp() {
        dbManager = new DatabaseManager();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @AfterEach
    public void tearDown() {
        HibernateUtil.getSessionFactory().close();
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        dbManager.createUser(user);

        User savedUser = dbManager.getUserById(user.getId());
        assertEquals("John Doe", savedUser.getName());
        assertEquals("john@example.com", savedUser.getEmail());
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User();
        user1.setName("John Doe");
        user1.setEmail("john@example.com");

        User user2 = new User();
        user2.setName("Jane Doe");
        user2.setEmail("jane@example.com");

        dbManager.createUser(user1);
        dbManager.createUser(user2);

        List<User> users = dbManager.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        dbManager.createUser(user);

        dbManager.deleteUser(user);

        User deletedUser = dbManager.getUserById(user.getId());
        assertNull(deletedUser);
    }
}
