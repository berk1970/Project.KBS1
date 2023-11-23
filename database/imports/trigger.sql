CREATE TRIGGER hash_password_trigger
    BEFORE INSERT ON users
    FOR EACH ROW
BEGIN
    SET NEW.password = password(NEW.password);
END;
