-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2024 at 04:45 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_crud`
--

-- --------------------------------------------------------

--
-- Table structure for table `log_aktifitas`
--

CREATE TABLE `log_aktifitas` (
  `id` bigint(18) NOT NULL,
  `waktu` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_user` varchar(50) DEFAULT NULL,
  `aktifitas` varchar(50) DEFAULT NULL,
  `keterangan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log_aktifitas`
--

INSERT INTO `log_aktifitas` (`id`, `waktu`, `id_user`, `aktifitas`, `keterangan`) VALUES
(1, '2024-01-17 15:33:49', 'admin', 'LUAS BENTUK', 'Luas Persegi Panjang = 55.0 * 5.0 = 275.0\nLuas Jajar Genjang = 55.0 * 5.0 = 275.0\nLuas Segitiga = 1/2 * 55.0 * 5.0 = 137.5\nLuas Layang-Layang =  1/2 * 55.0 * 5.0 = 137.5\nLuas Belah Ketupat = 1/2 * 55.0 * 5.0 = 137.5\n'),
(2, '2024-01-17 15:38:18', 'admin', 'LUAS BENTUK', 'Luas Persegi Panjang = 111.0 * 51.0 = 5661.0\nLuas Jajar Genjang = 111.0 * 51.0 = 5661.0\nLuas Segitiga = 1/2 * 111.0 * 51.0 = 2830.5\nLuas Layang-Layang =  1/2 * 111.0 * 51.0 = 2830.5\nLuas Belah Ketupat = 1/2 * 111.0 * 51.0 = 2830.5\n'),
(3, '2024-01-17 15:39:33', 'admin', 'LUAS BENTUK', 'Luas Persegi Panjang = 5.0 * 1.0 = 5.0\nLuas Jajar Genjang = 5.0 * 1.0 = 5.0\nLuas Segitiga = 1/2 * 5.0 * 1.0 = 2.5\nLuas Layang-Layang =  1/2 * 5.0 * 1.0 = 2.5\nLuas Belah Ketupat = 1/2 * 5.0 * 1.0 = 2.5\n');

-- --------------------------------------------------------

--
-- Table structure for table `log_login`
--

CREATE TABLE `log_login` (
  `id` int(11) NOT NULL,
  `id_user` varchar(64) DEFAULT NULL,
  `waktu_login` timestamp NOT NULL DEFAULT current_timestamp(),
  `waktu_logout` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log_login`
--

INSERT INTO `log_login` (`id`, `id_user`, `waktu_login`, `waktu_logout`) VALUES
(7, 'admin', '2023-12-03 10:42:19', '2023-12-03 18:42:22'),
(8, 'admin', '2023-12-03 10:42:27', '2023-12-03 18:42:30'),
(9, 'admin', '2023-12-03 10:43:03', '2023-12-03 18:44:45'),
(30, 'admin', '2024-01-17 15:33:39', '2024-01-17 23:39:16');


-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`id`, `nama`, `alamat`) VALUES
('2243057', 'William', 'bayur'),
('2243058', 'Fabian', 'Bengkuring'),
('2243110', 'dapid', 'samarinda');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(64) NOT NULL,
  `password` char(32) DEFAULT NULL,
  `nama` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `password`, `nama`) VALUES
('admin', 'e0616e71954e8480f853f184256515ca', 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `log_aktifitas`
--
ALTER TABLE `log_aktifitas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `log_login`
--
ALTER TABLE `log_login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `log_aktifitas`
--
ALTER TABLE `log_aktifitas`
  MODIFY `id` bigint(18) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `log_login`
--
ALTER TABLE `log_login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
