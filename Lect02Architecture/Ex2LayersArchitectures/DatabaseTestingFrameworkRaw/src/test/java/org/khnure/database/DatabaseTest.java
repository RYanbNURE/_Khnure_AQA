package org.khnure.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private DatabaseManager dbManager;

    @BeforeEach
    public void setUp() throws SQLException {
        dbManager = new DatabaseManager();
        dbManager.connect();
        dbManager.executeUpdate("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))");
        dbManager.executeUpdate("INSERT INTO users (id, name, email) VALUES (1, 'john', 'john@example.com')");
        dbManager.executeUpdate("INSERT INTO users (id, name, email) VALUES (2, 'jane', 'jane@example.com')");
    }

    @AfterEach
    public void tearDown() throws SQLException {
        dbManager.executeUpdate("DROP TABLE users");
        dbManager.close();
    }

    @Test
    public void testSelectQuery() throws SQLException {
        ResultSet resultSet = dbManager.executeQuery("SELECT * FROM users WHERE id = 1");
        assertTrue(resultSet.next());
        assertEquals(1, resultSet.getInt("id"));
        assertEquals("john", resultSet.getString("name"));
        assertEquals("john@example.com", resultSet.getString("email"));
    }

    @Test
    public void testInsertAndSelectQuery() throws SQLException {
        dbManager.executeUpdate("INSERT INTO users (id, name, email) VALUES (3, 'alice', 'alice@example.com')");
        ResultSet resultSet = dbManager.executeQuery("SELECT * FROM users WHERE id = 3");
        assertTrue(resultSet.next());
        assertEquals(3, resultSet.getInt("id"));
        assertEquals("alice", resultSet.getString("name"));
        assertEquals("alice@example.com", resultSet.getString("email"));
    }
}
