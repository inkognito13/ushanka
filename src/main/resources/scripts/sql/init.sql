CREATE TABLE ITEM (
  id           BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name         VARCHAR(100) NOT NULL,
  description  VARCHAR(255),
  stock        INT          NOT NULL,
  price        FLOAT        NOT NULL,
  manufacturer VARCHAR(100),
  INDEX (id)
);

CREATE TABLE USER (
  id       BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email    VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  INDEX (id)
);

CREATE TABLE PAYMENT_INFO (
  id            BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  card_number   VARCHAR(16)  NOT NULL,
  cvv           VARCHAR(3)   NOT NULL,
  first_name    VARCHAR(50)  NOT NULL,
  last_name     VARCHAR(50)  NOT NULL,
  phone_number  VARCHAR(20)  NOT NULL,
  first_string  VARCHAR(100) NOT NULL,
  second_string VARCHAR(100),
  city          VARCHAR(50) NOT NULL,
  user_id       BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES USER (id),
  INDEX (id)
);

CREATE TABLE SHIPPING_INFO (
  id            BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name    VARCHAR(50)  NOT NULL,
  last_name     VARCHAR(50)  NOT NULL,
  phone_number  VARCHAR(20)  NOT NULL,
  postal_code   VARCHAR(15),
  first_string  VARCHAR(100) NOT NULL,
  second_string VARCHAR(100),
  city          VARCHAR(50) NOT NULL,
  user_id       BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES USER (id),
  INDEX (id)
);

CREATE TABLE CART (
  id      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES USER (id),
  INDEX (id)
);

CREATE TABLE ITEM_TO_CART (
  cart_id BIGINT NOT NULL,
  item_id BIGINT NOT NULL,
  PRIMARY KEY (cart_id, item_id),
  FOREIGN KEY (cart_id) REFERENCES CART (id),
  FOREIGN KEY (item_id) REFERENCES ITEM (id)
);

CREATE TABLE ORDER_ (
  id               BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  total            FLOAT  NOT NULL,
  date             DATETIME,
  user_id          BIGINT NOT NULL,
  payment_info_id  BIGINT NOT NULL,
  shipping_info_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES USER (id),
  FOREIGN KEY (payment_info_id) REFERENCES PAYMENT_INFO (id),
  FOREIGN KEY (shipping_info_id) REFERENCES SHIPPING_INFO (id),
  INDEX (id)
);

CREATE TABLE ORDER_TO_ITEM (
  order_id BIGINT,
  item_id  BIGINT,
  PRIMARY KEY (order_id, item_id),
  FOREIGN KEY (order_id) REFERENCES ORDER_ (id),
  FOREIGN KEY (item_id) REFERENCES ITEM (id)
);