DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

MERGE INTO users (name, email)
VALUES ('John Doe', 'john.doe@example.com');

MERGE INTO users (name, email)
VALUES ('Jane Doe', 'jane.doe@example.com');

MERGE INTO users (name, email)
VALUES ('Alice Smith', 'alice.smith@example.com');