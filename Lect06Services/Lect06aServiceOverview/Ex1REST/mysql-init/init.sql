-- Создание таблицы users, если она еще не существует
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

-- Вставка начальных данных
INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');
INSERT INTO users (name, email) VALUES ('Jane Doe', 'jane@example.com');

-- Создание дополнительного пользователя с правами только на чтение
CREATE USER IF NOT EXISTS 'readonly_user'@'%' IDENTIFIED BY 'readonly_password';
GRANT SELECT ON userdb.* TO 'readonly_user'@'%';

-- Создание пользователя с полными правами (кроме удаления базы данных)
CREATE USER IF NOT EXISTS 'admin_user'@'%' IDENTIFIED BY 'admin_password';
GRANT ALL PRIVILEGES ON userdb.* TO 'admin_user'@'%';

-- Применение изменений
FLUSH PRIVILEGES;