-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Host: 192.168.178.20:32768
-- Generation Time: May 29, 2023 at 08:23 PM
-- Server version: 10.11.2-MariaDB-1:10.11.2+maria~ubu2204
-- PHP Version: 5.6.24-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `NerdyGadgets`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
`id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `shipment_date` datetime DEFAULT NULL,
  `payed` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `created_at`, `shipment_date`, `payed`) VALUES
(1, 16, '2023-05-01 10:00:00', NULL, 1),
(2, 55, '2023-05-02 11:30:00', '2023-05-05 14:00:00', 0),
(3, 18, '2023-05-03 09:45:00', '2023-05-07 11:30:00', 1),
(4, 61, '2023-05-04 15:20:00', NULL, 0),
(5, 40, '2023-05-05 12:10:00', '2023-05-08 16:45:00', 1),
(6, 55, '2023-05-06 08:30:00', '2023-05-09 09:15:00', 1),
(7, 40, '2023-05-07 17:00:00', NULL, 0),
(8, 22, '2023-05-08 14:40:00', '2023-05-10 10:20:00', 0),
(9, 27, '2023-05-09 13:15:00', '2023-05-11 16:30:00', 1),
(10, 59, '2023-05-10 09:00:00', '2023-05-13 11:45:00', 1),
(11, 52, '2023-05-11 18:30:00', NULL, 0),
(12, 21, '2023-05-12 15:20:00', '2023-05-15 16:00:00', 1),
(13, 37, '2023-05-13 11:10:00', '2023-05-16 14:30:00', 0),
(14, 56, '2023-05-14 07:45:00', NULL, 1),
(15, 60, '2023-05-15 16:30:00', '2023-05-18 18:15:00', 1),
(16, 17, '2023-05-16 14:15:00', '2023-05-19 17:40:00', 0),
(17, 43, '2023-05-17 19:00:00', NULL, 0),
(18, 52, '2023-05-18 17:40:00', '2023-05-21 10:30:00', 1),
(19, 20, '2023-05-19 12:30:00', '2023-05-23 14:50:00', 1),
(20, 29, '2023-05-20 08:50:00', '2023-05-25 09:30:00', 0),
(21, 63, '2023-05-21 11:00:00', NULL, 1),
(22, 64, '2023-05-22 12:30:00', '2023-05-25 15:00:00', 0),
(23, 65, '2023-05-23 10:45:00', '2023-05-27 12:30:00', 1),
(24, 66, '2023-05-24 16:20:00', NULL, 0),
(25, 67, '2023-05-25 13:10:00', '2023-05-28 17:45:00', 1),
(26, 68, '2023-05-26 09:30:00', '2023-05-29 10:15:00', 1),
(27, 69, '2023-05-27 18:00:00', NULL, 0),
(28, 70, '2023-05-28 15:40:00', '2023-05-30 11:20:00', 0),
(29, 71, '2023-05-29 14:15:00', '2023-05-31 17:30:00', 1),
(30, 72, '2023-05-30 10:00:00', '2023-06-02 12:45:00', 1),
(31, 73, '2023-05-31 19:30:00', NULL, 0),
(32, 74, '2023-06-01 16:20:00', '2023-06-04 17:00:00', 1),
(33, 75, '2023-06-02 12:10:00', '2023-06-05 16:45:00', 1),
(34, 76, '2023-06-03 08:30:00', NULL, 0),
(35, 77, '2023-06-04 17:00:00', '2023-06-07 09:15:00', 1),
(36, 78, '2023-06-05 14:40:00', '2023-06-08 10:20:00', 0),
(37, 79, '2023-06-06 13:15:00', '2023-06-09 14:30:00', 1),
(38, 80, '2023-06-07 09:00:00', '2023-06-10 11:45:00', 1),
(39, 81, '2023-06-08 18:30:00', NULL, 0),
(40, 82, '2023-06-09 15:20:00', '2023-06-12 16:00:00', 1),
(41, 83, '2023-06-10 11:10:00', '2023-06-13 14:30:00', 0),
(42, 84, '2023-06-11 07:45:00', NULL, 1),
(43, 85, '2023-06-12 16:30:00', '2023-06-15 18:15:00', 1),
(44, 86, '2023-06-13 14:15:00', '2023-06-16 17:40:00', 0),
(45, 87, '2023-06-14 19:00:00', NULL, 0),
(46, 88, '2023-06-15 17:40:00', '2023-06-18 10:30:00', 1),
(47, 89, '2023-06-16 12:30:00', '2023-06-20 14:50:00', 1),
(48, 90, '2023-06-17 08:50:00', '2023-06-22 09:30:00', 0),
(49, 91, '2023-06-18 17:20:00', '2023-06-23 18:00:00', 1),
(50, 92, '2023-06-19 14:10:00', NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
 ADD PRIMARY KEY (`id`), ADD KEY `orders_users_id_fk` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
ADD CONSTRAINT `orders_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
