SET SCHEMA root;

CREATE TABLE messages (
  id INT NOT NULL PRIMARY KEY,
  created TIMESTAMP NOT NULL,
  changed TIMESTAMP,
  header VARCHAR(100),
  text CHARACTER LARGE OBJECT,
  picture BINARY LARGE OBJECT,
  visible BOOLEAN DEFAULT TRUE
);

CREATE SEQUENCE messages_id START WITH 1 INCREMENT BY 1;


CREATE TABLE images (
  id INT NOT NULL PRIMARY KEY,
  created TIMESTAMP NOT NULL,
  description VARCHAR(100),
  picture BINARY LARGE OBJECT
);

CREATE SEQUENCE images_id START WITH 1 INCREMENT BY 1;


INSERT INTO messages VALUES (1, current_timestamp, null, 'header 1', 'test message 1', null);
INSERT INTO messages VALUES (2, current_timestamp, null, 'header 2', 'test message 2', null);
