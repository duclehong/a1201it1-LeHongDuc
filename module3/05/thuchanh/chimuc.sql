SELECT * FROM customers WHERE customerNumber = 175; 
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;
ALTER TABLE customers ADD INDEX idx_customerNumber(customerNumber);
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;