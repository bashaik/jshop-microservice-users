--add create schema script
DROP SCHEMA IF EXISTS testtenant_products;
CREATE SCHEMA testtenant_products;
USE testtenant_products;

--create table if not exists 111
CREATE TABLE IF NOT EXISTS product
(
  oid binary(16) NOT NULL,
  id  int NOT NULL,
  name varchar(64) NOT NULL,
  price varchar(12) DEFAULT NULL,
  modified_by varchar(50) NOT NULL,
  modified_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY pk_product (oid),
  Unique KEY unidx_product_name (name)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_bin;

--Insert data
INSERT INTO `product` VALUES 
('1001',1001,'CPU','$300.00','john','2017-09-12 17:10:00'),
('1002',1002,'RAM','$250.00','tim','2017-09-12 17:10:00'),
('1003',1003,'iPhone','$650.00','david','2017-09-12 17:10:00'),
('1004',1004,'iPad','$700.00','chris','2017-09-12 17:10:00');