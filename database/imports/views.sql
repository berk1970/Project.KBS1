USE `nerdygadgets`;
CREATE  OR REPLACE VIEW `vw_undelivered_orders` AS SELECT orders.id, orders.created_at, cities.city FROM orders
LEFT JOIN users ON orders.user_id = users.id
LEFT JOIN cities ON users.city = cities.id
WHERE shipment_date IS NULL;;
