CREATE TABLE converted_user (
  id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  converted_at DATETIME NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
