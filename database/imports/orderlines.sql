-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Host: 192.168.178.20:32768
-- Generation Time: May 29, 2023 at 08:34 PM
-- Server version: 10.11.2-MariaDB-1:10.11.2+maria~ubu2204
-- PHP Version: 5.6.24-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ng_scraped`
--

-- --------------------------------------------------------

--
-- Table structure for table `orderlines`
--

DROP TABLE IF EXISTS `orderlines`;
CREATE TABLE IF NOT EXISTS `orderlines` (
`id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderlines`
--

INSERT INTO `orderlines` (`id`, `order_id`, `product_id`, `quantity`) VALUES
(119, 1, 142, 5),
(120, 2, 151, 3),
(121, 3, 175, 8),
(122, 4, 162, 2),
(123, 5, 159, 6),
(124, 6, 157, 9),
(125, 7, 155, 4),
(126, 8, 141, 7),
(127, 9, 136, 1),
(128, 10, 148, 4),
(129, 11, 158, 3),
(130, 12, 161, 2),
(131, 13, 139, 7),
(132, 14, 173, 5),
(133, 15, 145, 6),
(134, 16, 167, 8),
(135, 17, 183, 2),
(136, 18, 172, 9),
(137, 19, 136, 4),
(138, 20, 155, 7),
(139, 21, 142, 5),
(140, 22, 151, 3),
(141, 23, 175, 8),
(142, 24, 162, 2),
(143, 25, 159, 6),
(144, 26, 157, 9),
(145, 27, 155, 4),
(146, 28, 141, 7),
(147, 29, 136, 1),
(148, 30, 148, 4),
(149, 31, 158, 3),
(150, 32, 161, 2),
(151, 33, 139, 7),
(152, 34, 173, 5),
(153, 35, 145, 6),
(154, 36, 167, 8),
(155, 37, 183, 2),
(156, 38, 172, 9),
(157, 39, 136, 4),
(158, 40, 155, 7),
(159, 41, 137, 3),
(160, 42, 152, 6),
(161, 43, 185, 8),
(162, 44, 156, 2),
(163, 45, 160, 5),
(164, 46, 174, 1),
(165, 47, 138, 4),
(166, 48, 165, 7),
(167, 49, 187, 3),
(168, 50, 170, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orderlines`
--
ALTER TABLE `orderlines`
 ADD PRIMARY KEY (`id`), ADD KEY `orderlines_orders_id_fk` (`order_id`), ADD KEY `orderlines_products_id_fk` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orderlines`
--
ALTER TABLE `orderlines`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=169;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderlines`
--
ALTER TABLE `orderlines`
ADD CONSTRAINT `orderlines_products_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
