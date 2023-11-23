-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--

-- Gegenereerd op: 11 mei 2023 om 12:43
-- Serverversie: 10.11.2-MariaDB-1:10.11.2+maria~ubu2204
-- PHP-versie: 5.6.24-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `NerdyGadgets`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
`id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `surname_prefix` varchar(20) DEFAULT NULL,
  `surname` varchar(30) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `apartment` varchar(20) DEFAULT NULL COMMENT 'apartment, suite, etc',
  `postal_code` varchar(6) DEFAULT NULL COMMENT 'postal/zip',
  `role` enum('admin','user') NOT NULL DEFAULT 'user'
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `first_name`, `surname_prefix`, `surname`, `address`, `apartment`, `postal_code`, `role`) VALUES
(13, 'john.doe@nerdygadgets.com', 'password123', 'John', 'van', 'Doe', '123 Main St', 'Apt 4B', '12345', 'user'),
(14, 'jane.smith@nerdygadgets.com', 'pass1234', 'Jane', '', 'Smith', '456 Elm St', 'Suite 2', '67890', 'user'),
(15, 'bob.johnson@nerdygadgets.com', 'letmein', 'Bob', '', 'Johnson', '789 Maple Ave', '', '54321', 'user'),
(16, 'samantha.nguyen@nerdygadgets.com', 'P@ssw0rd', 'Samantha', '', 'Nguyen', '321 Oak St', 'Unit 5', '98765', 'user'),
(17, 'michael.lee@nerdygadgets.com', 'qwert123', 'Michael', '', 'Lee', '567 Pine Rd', 'Apt 7C', '24680', 'user'),
(18, 'jennifer.smith@nerdygadgets.com', 'qwertyuiop', 'Jennifer', '', 'Smith', '345 Broadway St', '', '45678', 'user'),
(19, 'mario.rossi@nerdygadgets.com', 'mario123', 'Mario', '', 'Rossi', '567 Venice Ave', 'Apt 3D', '67890', 'user'),
(20, 'claire.lam@nerdygadgets.com', 'ClaireLam1', 'Claire', '', 'Lam', '12A Gloucester Rd', '', '12345', 'user'),
(21, 'peter.parker@nerdygadgets.com', 'spiderman', 'Peter', '', 'Parker', '1 Main St', 'Apt 2B', '54321', 'user'),
(22, 'james.bond@nerdygadgets.com', '007bond', 'James', '', 'Bond', '10 Downing St', '', '24680', 'user'),
(23, 'emma.watson@nerdygadgets.com', 'hermione', 'Emma', '', 'Watson', '34 Baker St', '', '13579', 'user'),
(24, 'jonathan.chu@nerdygadgets.com', 'ChuJonathan', 'Jonathan', '', 'Chu', '789 Wall St', 'Suite 7', '98765', 'user'),
(25, 'sara.johnson@nerdygadgets.com', 'sara123', 'Sara', '', 'Johnson', '56 Park Ave', '', '23456', 'user'),
(26, 'daniel.kim@nerdygadgets.com', 'daniel123', 'Daniel', '', 'Kim', '567 Main St', '', '34567', 'user'),
(27, 'ashley.nguyen@nerdygadgets.com', 'ashley456', 'Ashley', '', 'Nguyen', '123 Market St', 'Apt 1A', '56789', 'user'),
(28, 'david.jones@nerdygadgets.com', 'david123', 'David', '', 'Jones', '789 High St', '', '12345', 'user'),
(29, 'sophie.kim@nerdygadgets.com', 'sophie123', 'Sophie', '', 'Kim', '234 Oak St', '', '67890', 'user'),
(30, 'alexander.nguyen@nerdygadgets.com', 'alex123', 'Alexander', '', 'Nguyen', '345 Pine Ave', 'Unit 4', '54321', 'user'),
(31, 'maria.garcia@nerdygadgets.com', 'maria456', 'Maria', '', 'Garcia', '456 Broadway', '', '98765', 'user'),
(32, 'ryan.smith@nerdygadgets.com', 'ryan789', 'Ryan', '', 'Smith', '789 Main St', 'Apt 5C', '24680', 'user'),
(33, 'julia.wang@nerdygadgets.com', 'julia123', 'Julia', '', 'Wang', '123 Elm St', '', '13579', 'user'),
(34, 'andrew.lee@nerdygadgets.com', 'andrew456', 'Andrew', '', 'Lee', '567 Market St', '', '23456', 'user'),
(35, 'samantha.smith@nerdygadgets.com', 'samantha789', 'Samantha', '', 'Smith', '890 Pine Ave', 'Suite 3', '34567', 'user'),
(36, 'jacob.young@nerdygadgets.com', 'jacob123', 'Jacob', '', 'Young', '456 Oak Rd', 'Unit 2', '56789', 'user'),
(37, 'olivia.li@nerdygadgets.com', 'olivia456', 'Olivia', '', 'Li', '789 Maple St', '', '45678', 'user'),
(38, 'john.doe@nerdygadgets.com', 'password123', 'John', 'van', 'Doe', '123 Main St', 'Apt 4B', '12345', 'user'),
(39, 'jane.smith@nerdygadgets.com', 'pass1234', 'Jane', '', 'Smith', '456 Elm St', 'Suite 2', '67890', 'user'),
(40, 'bob.johnson@nerdygadgets.com', 'letmein', 'Bob', '', 'Johnson', '789 Maple Ave', '', '54321', 'user'),
(41, 'samantha.nguyen@nerdygadgets.com', 'P@ssw0rd', 'Samantha', '', 'Nguyen', '321 Oak St', 'Unit 5', '98765', 'user'),
(42, 'michael.lee@nerdygadgets.com', 'qwert123', 'Michael', '', 'Lee', '567 Pine Rd', 'Apt 7C', '24680', 'user'),
(43, 'jennifer.smith@nerdygadgets.com', 'qwertyuiop', 'Jennifer', '', 'Smith', '345 Broadway St', '', '45678', 'user'),
(44, 'mario.rossi@nerdygadgets.com', 'mario123', 'Mario', '', 'Rossi', '567 Venice Ave', 'Apt 3D', '67890', 'user'),
(45, 'claire.lam@nerdygadgets.com', 'ClaireLam1', 'Claire', '', 'Lam', '12A Gloucester Rd', '', '12345', 'user'),
(46, 'peter.parker@nerdygadgets.com', 'spiderman', 'Peter', '', 'Parker', '1 Main St', 'Apt 2B', '54321', 'user'),
(47, 'james.bond@nerdygadgets.com', '007bond', 'James', '', 'Bond', '10 Downing St', '', '24680', 'user'),
(48, 'emma.watson@nerdygadgets.com', 'hermione', 'Emma', '', 'Watson', '34 Baker St', '', '13579', 'user'),
(49, 'jonathan.chu@nerdygadgets.com', 'ChuJonathan', 'Jonathan', '', 'Chu', '789 Wall St', 'Suite 7', '98765', 'user'),
(50, 'sara.johnson@nerdygadgets.com', 'sara123', 'Sara', '', 'Johnson', '56 Park Ave', '', '23456', 'user'),
(51, 'daniel.kim@nerdygadgets.com', 'daniel123', 'Daniel', '', 'Kim', '567 Main St', '', '34567', 'user'),
(52, 'ashley.nguyen@nerdygadgets.com', 'ashley456', 'Ashley', '', 'Nguyen', '123 Market St', 'Apt 1A', '56789', 'user'),
(53, 'david.jones@nerdygadgets.com', 'david123', 'David', '', 'Jones', '789 High St', '', '12345', 'user'),
(54, 'sophie.kim@nerdygadgets.com', 'sophie123', 'Sophie', '', 'Kim', '234 Oak St', '', '67890', 'user'),
(55, 'alexander.nguyen@nerdygadgets.com', 'alex123', 'Alexander', '', 'Nguyen', '345 Pine Ave', 'Unit 4', '54321', 'user'),
(56, 'maria.garcia@nerdygadgets.com', 'maria456', 'Maria', '', 'Garcia', '456 Broadway', '', '98765', 'user'),
(57, 'ryan.smith@nerdygadgets.com', 'ryan789', 'Ryan', '', 'Smith', '789 Main St', 'Apt 5C', '24680', 'user'),
(58, 'julia.wang@nerdygadgets.com', 'julia123', 'Julia', '', 'Wang', '123 Elm St', '', '13579', 'user'),
(59, 'andrew.lee@nerdygadgets.com', 'andrew456', 'Andrew', '', 'Lee', '567 Market St', '', '23456', 'user'),
(60, 'samantha.smith@nerdygadgets.com', 'samantha789', 'Samantha', '', 'Smith', '890 Pine Ave', 'Suite 3', '34567', 'user'),
(61, 'jacob.young@nerdygadgets.com', 'jacob123', 'Jacob', '', 'Young', '456 Oak Rd', 'Unit 2', '56789', 'user'),
(62, 'olivia.li@nerdygadgets.com', 'olivia456', 'Olivia', '', 'Li', '789 Maple St', '', '45678', 'user'),
(63, 'jane.smith@nerdygadgets.com', 'P@ssw0rd123', 'Jane', 'van', 'Smith', '456 Oak St', 'Apt 7C', '67890', 'user'),
(64, 'michael.wilson@nerdygadgets.com', 'Pass123word', 'Michael', NULL, 'Wilson', '789 Elm St', NULL, '23456', 'user'),
(65, 'sarah.johnson@nerdygadgets.com', 'SecureP@ss', 'Sarah', NULL, 'Johnson', '987 Pine St', 'Apt 2A', '34567', 'user'),
(66, 'robert.thomas@nerdygadgets.com', 'R0bert#P@ss', 'Robert', 'de', 'Thomas', '654 Maple Ave', NULL, '45678', 'user'),
(67, 'jennifer.jackson@nerdygadgets.com', 'Jenn1f3r$P@ss', 'Jennifer', 'van', 'Jackson', '321 Oak St', 'Apt 9B', '56789', 'user'),
(68, 'david.rodriguez@nerdygadgets.com', 'D@v1dP@ssw0rd', 'David', 'van', 'Rodriguez', '12 Elm St', 'Apt 6C', '67890', 'user'),
(69, 'jessica.lee@nerdygadgets.com', 'J3ss!c@P@ss', 'Jessica', NULL, 'Lee', '345 Pine St', NULL, '78901', 'user'),
(70, 'matthew.hall@nerdygadgets.com', 'M@tth3wP@ss', 'Matthew', NULL, 'Hall', '678 Maple Ave', 'Apt 3B', '89012', 'user'),
(71, 'emily.white@nerdygadgets.com', 'Wh1te&Em1ly', 'Emily', 'de', 'White', '901 Oak St', NULL, '90123', 'user'),
(72, 'christopher.martin@nerdygadgets.com', 'Chr1st0ph3r!P@ss', 'Christopher', 'van', 'Martin', '234 Elm St', 'Apt 4B', '01234', 'user'),
(73, 'olivia.davis@nerdygadgets.com', 'Dav1sOl!v!@', 'Olivia', 'de', 'Davis', '567 Pine St', NULL, '12345', 'user'),
(74, 'andrew.garcia@nerdygadgets.com', 'G@rc1@#P@ss', 'Andrew', NULL, 'Garcia', '890 Maple Ave', 'Apt 7C', '23456', 'user'),
(75, 'isabella.martinez@nerdygadgets.com', '1s@b3ll@!P@ss', 'Isabella', 'van', 'Martinez', '123 Oak St', NULL, '34567', 'user'),
(76, 'ethan.robinson@nerdygadgets.com', 'R0b!n$0n#P@ss', 'Ethan', NULL, 'Robinson', '456 Elm St', 'Apt 2A', '45678', 'user'),
(77, 'mia.clark@nerdygadgets.com', 'Cl@rk&M!@', 'Mia', 'van', 'Clark', '789 Pine St', 'Apt 9B', '56789', 'user'),
(78, 'alexander.rodriguez@nerdygadgets.com', 'R0dr!gu3z&A1ex#', 'Alexander', 'de', 'Rodriguez', '321 Maple Ave', NULL, '67890', 'user'),
(79, 'ava.james@nerdygadgets.com', 'J@m3s!#Av@', 'Ava', NULL, 'James', '654 Oak St', NULL, '78901', 'user'),
(80, 'william.sanchez@nerdygadgets.com', 'S@nch3zW!ll!@m', 'William', 'van', 'Sanchez', '987 Elm St', 'Apt 5C', '89012', 'user'),
(81, 'sofia.hall@nerdygadgets.com', 'H@ll&S0ph!@', 'Sofia', NULL, 'Hall', '210 Pine St', NULL, '90123', 'user'),
(82, 'charlotte.gonzalez@nerdygadgets.com', 'G0nz@l3z&C#rl0t', 'Charlotte', 'de', 'Gonzalez', '543 Maple Ave', 'Apt 8C', '01234', 'user'),
(83, 'benjamin.walker@nerdygadgets.com', 'W@lk3r&B3nj@m!n', 'Benjamin', NULL, 'Walker', '876 Oak St', NULL, '12345', 'user'),
(84, 'amelia.hernandez@nerdygadgets.com', 'H3rn@nd3z&Aml!@', 'Amelia', 'van', 'Hernandez', '109 Elm St', 'Apt 3B', '23456', 'user'),
(85, 'henry.nelson@nerdygadgets.com', 'N3ls0n#H3nry', 'Henry', NULL, 'Nelson', '432 Pine St', 'Apt 6C', '34567', 'user'),
(86, 'harper.myers@nerdygadgets.com', 'M.y3rs!H@rp3r', 'Harper', 'de', 'Myers', '765 Maple Ave', NULL, '45678', 'user'),
(87, 'victoria.powell@nerdygadgets.com', 'P0w3ll#V1ct0r!@', 'Victoria', 'van', 'Powell', '998 Oak St', 'Apt 4B', '56789', 'user'),
(88, 'charles.perry@nerdygadgets.com', 'P3rry!&Ch@rl3s', 'Charles', 'van', 'Perry', '143 Elm St', NULL, '67890', 'user'),
(89, 'lillian.long@nerdygadgets.com', 'L0ng!#L1ll!@n', 'Lillian', NULL, 'Long', '376 Pine St', NULL, '78901', 'user'),
(90, 'grace.sullivan@nerdygadgets.com', 'Sull1v@n#Gr@c3', 'Grace', NULL, 'Sullivan', '599 Maple Ave', 'Apt 7C', '89012', 'user');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `users`
--
ALTER TABLE `users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=63;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
