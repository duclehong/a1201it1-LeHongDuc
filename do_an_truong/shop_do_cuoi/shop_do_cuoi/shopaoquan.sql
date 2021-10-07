-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 29, 2020 lúc 04:42 PM
-- Phiên bản máy phục vụ: 10.4.8-MariaDB
-- Phiên bản PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shopaoquan`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `admin`
--

CREATE TABLE `admin` (
  `id` int(100) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `admin`
--

INSERT INTO `admin` (`id`, `username`, `pass`) VALUES
(1, 'admin', '123456');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment`
--

CREATE TABLE `comment` (
  `id` int(10) NOT NULL,
  `id_product` int(10) NOT NULL,
  `id_user` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `time` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `comment`
--

INSERT INTO `comment` (`id`, `id_product`, `id_user`, `content`, `date`, `time`) VALUES
(1, 1, '1', 'xịn', '2018-11-23', ''),
(2, 2, '3', 'hehee', '0000-00-00', '00:00:00'),
(3, 1, '2', 'zxcxzczxczxc', '2020-11-04', '22:30:12'),
(4, 10, '2', 'hello', '0000-00-00', '00:00:00'),
(5, 10, '2', 'đá', '0000-00-00', '00:00:00'),
(6, 2, '2', 'sđsd', '0000-00-00', '00:00:00'),
(7, 1, '2', 'đep quá', '2018-11-20', ''),
(8, 1, '2', 'hello', '2018-11-20', '05:29:18'),
(9, 1, '2', 'zxczxc', '2020-11-18', '05:30:39'),
(10, 2, '2', 'đẹp quá\r\n', '2020-11-18', '05:31:22'),
(11, 1, '2', 'hàng đẹp quá\r\n', '2020-11-19', '09:52:49'),
(12, 10, '5', 'đẹp thật', '2020-11-19', '11:14:08'),
(13, 2, '5', 'hàng đẹp quá\r\n', '2020-11-19', '01:40:52'),
(14, 3, '1', 'hiihi\r\n', '2020-11-19', '02:36:35'),
(15, 9, '2', 'đẹp vailon', '2020-11-23', '09:05:38'),
(16, 9, '9', 'hehe', '2020-11-23', '09:06:27'),
(17, 9, '10', 'hihi', '2020-11-23', '09:07:23'),
(18, 9, '10', 'quá đẹp luôn\r\n\r\n', '2020-11-23', '09:09:33'),
(19, 4, '10', 'hehe', '2020-11-23', '09:14:10'),
(20, 10, '10', 'dsf', '2020-11-23', '09:29:43');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(100) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `brand` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_category` int(10) NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` float NOT NULL,
  `sale` int(100) NOT NULL,
  `dac_biet` int(1) NOT NULL,
  `danh_gia` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `name`, `brand`, `id_category`, `image`, `price`, `sale`, `dac_biet`, `danh_gia`) VALUES
(1, 'áo khoác', 'supreme', 1, 'aokhoacsup.jpg', 999.99, 20, 1, 12312),
(2, 'quần dài', 'supreme', 2, 'quandaisup.jpg', 34.95, 15, 0, 0),
(3, 'áo khoác', 'gucci', 1, 'aokhoacgucci.jpg', 19.95, 15, 0, 0),
(4, 'hoodie', 'supreme', 1, 'hoodiesup.jpeg', 19.32, 30, 0, 0),
(5, 'Áo hoodie ', 'supreme', 1, 'hoodiesup1.jpeg', 12.23, 10, 0, 0),
(6, 'Áo LEN', 'gucci', 2, 'aolengucci.jpeg', 12.23, 10, 0, 0),
(7, 'Áo hoodie tay dài ', 'supreme', 1, 'sdsdds.jpeg', 34.95, 10, 1, 1),
(9, 'Áo sơ mi thanh lịch', 'gucci', 1, 'qfg.png', 69.96, 0, 1, 123),
(10, 'combo áo vàng quần rách limit', 'gucci', 2, 'sdsd.png', 34.95, 0, 1, 100);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `DiaChi`, `phone`, `name`, `age`) VALUES
(1, 'user1', '123456', 'huỳnh văn nghệ', '0905817942', 'nguyễn quốc cường', 20),
(2, 'user2', '321321', 'đông hà ', '0905445646', 'nguyễn văn boong', 19),
(4, '123323', '123', '123123', '123123', '123', 123123),
(5, '234234', '234', '324234', '23423423', '234234', 4234234),
(6, 'boongdangcap', '123123', 'châu', '0854667234', 'boong', 20),
(7, 'user5', '123456', 'nguyễn minh châu', '921177007', 'Nguyễn Quốc Cường', 12),
(8, 'user6', '123456', 'nguyễn minh châu', '921177007', 'bông', 1),
(9, 'user7', '123456', 'nguyễn minh châu', '921177007', 'Nguyễn Quốc Cường', 12),
(10, 'duck', '123', 'nguyễn minh châu', '921177007', 'Lê Hông Duck', 12);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
