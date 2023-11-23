CREATE USER 'NerdyGadgets'@'localhost' IDENTIFIED BY 'password';
GRANT INSERT, UPDATE, SELECT ON NerdyGadgets.* TO 'NerdyGadgets'@'localhost';
FLUSH PRIVILEGES;