-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2021 at 06:02 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_infly`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `username_admin` varchar(255) NOT NULL,
  `password_admin` varchar(10) NOT NULL,
  `nama_admin` varchar(255) NOT NULL,
  `tgllahir_admin` date NOT NULL,
  `jenis_kelamin` char(1) NOT NULL,
  `alamat_admin` varchar(255) NOT NULL,
  `no_telepon` varchar(12) NOT NULL,
  `email_admin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username_admin`, `password_admin`, `nama_admin`, `tgllahir_admin`, `jenis_kelamin`, `alamat_admin`, `no_telepon`, `email_admin`) VALUES
(1, 'deatrisya', '123456', 'Deatrisya MH', '2001-12-18', 'P', 'Purwosari', '081330991', 'mirelldee47@gmail.com'),
(2, 'penumpang2', '123456', 'Siti Aisyah', '2001-12-18', 'P', 'Malang', '081330991', 'aisyah@gmail.com'),
(4, 'aisyah11', 'aisyah11', 'Aisyah', '2018-12-21', 'L', 'B', '081330991', 'aisyah@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `kota`
--

CREATE TABLE `kota` (
  `id_kota` int(11) NOT NULL,
  `nama_kota` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kota`
--

INSERT INTO `kota` (`id_kota`, `nama_kota`) VALUES
(2, 'Padang'),
(3, 'Jakarta'),
(4, 'Medan'),
(5, 'Banjarmasin'),
(6, 'Balikpapan'),
(7, 'Surabaya');

-- --------------------------------------------------------

--
-- Table structure for table `maskapai`
--

CREATE TABLE `maskapai` (
  `id_maskapai` int(11) NOT NULL,
  `nama_perusahaan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `maskapai`
--

INSERT INTO `maskapai` (`id_maskapai`, `nama_perusahaan`) VALUES
(2, 'Air Asia'),
(3, 'Sky Aviation');

-- --------------------------------------------------------

--
-- Table structure for table `penerbangan`
--

CREATE TABLE `penerbangan` (
  `id_paket` int(11) NOT NULL,
  `asal_kota` int(11) NOT NULL,
  `tujuan_kota` int(11) NOT NULL,
  `id_pesawat` int(11) NOT NULL,
  `harga_tiket` int(11) NOT NULL,
  `jam_berangkat` time NOT NULL,
  `jam_kedatangan` time NOT NULL,
  `tanggal_berangkat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penerbangan`
--

INSERT INTO `penerbangan` (`id_paket`, `asal_kota`, `tujuan_kota`, `id_pesawat`, `harga_tiket`, `jam_berangkat`, `jam_kedatangan`, `tanggal_berangkat`) VALUES
(1, 4, 3, 3, 350000, '09:12:34', '16:12:34', '2021-12-15'),
(2, 2, 3, 5, 400000, '09:12:34', '09:12:39', '2021-12-08'),
(3, 6, 3, 3, 400000, '09:12:34', '09:12:39', '2021-12-09'),
(5, 3, 2, 2, 410000, '09:12:34', '09:12:39', '2021-12-10'),
(6, 4, 3, 3, 400000, '09:12:34', '09:12:39', '2021-12-11'),
(8, 7, 3, 5, 400000, '09:12:34', '09:12:39', '2021-12-13'),
(9, 4, 7, 3, 400000, '09:12:34', '09:12:39', '2021-12-14'),
(11, 2, 3, 5, 400000, '09:12:34', '09:12:39', '2021-12-08'),
(12, 2, 3, 3, 450000, '09:12:34', '09:12:39', '2021-12-08'),
(14, 2, 3, 5, 400000, '09:12:34', '09:12:39', '2021-12-08'),
(15, 6, 5, 6, 250000, '09:12:36', '12:12:39', '2021-12-08'),
(17, 3, 2, 5, 400000, '09:40:30', '09:12:39', '2021-12-08'),
(18, 2, 3, 3, 400000, '09:12:34', '09:12:39', '2021-12-08'),
(20, 3, 4, 2, 750000, '10:05:00', '13:05:00', '2021-12-19'),
(21, 3, 2, 5, 400000, '09:40:30', '09:12:39', '2021-12-08'),
(22, 2, 5, 3, 400000, '09:12:34', '09:12:39', '2021-12-08');

-- --------------------------------------------------------

--
-- Table structure for table `pesawat`
--

CREATE TABLE `pesawat` (
  `id_pesawat` int(11) NOT NULL,
  `nama_pesawat` varchar(255) NOT NULL,
  `id_maskapai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pesawat`
--

INSERT INTO `pesawat` (`id_pesawat`, `nama_pesawat`, `id_maskapai`) VALUES
(2, 'Boeing 737', 2),
(3, 'Airbus A329', 3),
(5, 'Boeing 738', 2),
(6, 'Airbus A322', 3),
(8, 'Boeing 739', 2),
(9, 'Airbus A320', 3);

-- --------------------------------------------------------

--
-- Table structure for table `reservasi`
--

CREATE TABLE `reservasi` (
  `id_reservasi` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_paket` int(11) NOT NULL,
  `kelas` varchar(255) NOT NULL,
  `harga_tiket` int(11) NOT NULL,
  `nama_pemesan` varchar(255) NOT NULL,
  `tanggal_berangkat` date NOT NULL,
  `tanggal_bayar` date DEFAULT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservasi`
--

INSERT INTO `reservasi` (`id_reservasi`, `id_user`, `id_paket`, `kelas`, `harga_tiket`, `nama_pemesan`, `tanggal_berangkat`, `tanggal_bayar`, `status`) VALUES
(11, 7, 9, 'Bisnis', 400000, 'Deatrisya 4', '2021-12-11', '2021-12-13', 'Lunas'),
(12, 7, 9, 'Bisnis', 400000, 'Deatrisya 2', '2021-12-11', '2021-12-17', 'Pesanan Batal'),
(13, 7, 3, 'Ekonomi', 400000, 'Deatrisya 3', '2021-12-11', '2021-12-17', 'Pesanan Batal'),
(25, 8, 5, 'Utama', 420000, 'Deatrisya 5', '2021-12-08', '2021-12-27', 'Lunas');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username_user` varchar(255) NOT NULL,
  `password_user` varchar(255) NOT NULL,
  `nama_user` varchar(255) NOT NULL,
  `tgllahir_user` date NOT NULL,
  `jenisKelamin` char(1) NOT NULL,
  `alamat_user` varchar(255) NOT NULL,
  `no_telepon` varchar(12) NOT NULL,
  `email_user` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username_user`, `password_user`, `nama_user`, `tgllahir_user`, `jenisKelamin`, `alamat_user`, `no_telepon`, `email_user`) VALUES
(2, 'penumpang2', '123456', 'Aisyah', '2001-12-18', 'P', 'Sukorejo', '081330991', 'aisyah@gmail.com'),
(3, 'penumpang3', 'penumpang', 'Penumpang', '2001-12-18', 'P', 'Sukorejo', '08133099', 'Penumpang@gmail.com'),
(7, 'deatrisya123', '123456', 'Deatrisya 12', '2001-12-19', 'P', 'Purwosari', '08133099188', 'mirelldee47@gmail.com'),
(8, 'deatrisya11', '123456', 'Deatrisya Mirela H', '2001-12-18', 'P', 'Purwosari', '081445667889', 'mirelldee47@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`id_kota`);

--
-- Indexes for table `maskapai`
--
ALTER TABLE `maskapai`
  ADD PRIMARY KEY (`id_maskapai`);

--
-- Indexes for table `penerbangan`
--
ALTER TABLE `penerbangan`
  ADD PRIMARY KEY (`id_paket`),
  ADD KEY `asal_kota` (`asal_kota`),
  ADD KEY `tujuan_kota` (`tujuan_kota`),
  ADD KEY `id_pesawat` (`id_pesawat`);

--
-- Indexes for table `pesawat`
--
ALTER TABLE `pesawat`
  ADD PRIMARY KEY (`id_pesawat`),
  ADD KEY `nama_maskapai` (`id_maskapai`);

--
-- Indexes for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD PRIMARY KEY (`id_reservasi`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kota`
--
ALTER TABLE `kota`
  MODIFY `id_kota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `maskapai`
--
ALTER TABLE `maskapai`
  MODIFY `id_maskapai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `penerbangan`
--
ALTER TABLE `penerbangan`
  MODIFY `id_paket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `pesawat`
--
ALTER TABLE `pesawat`
  MODIFY `id_pesawat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `reservasi`
--
ALTER TABLE `reservasi`
  MODIFY `id_reservasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `penerbangan`
--
ALTER TABLE `penerbangan`
  ADD CONSTRAINT `penerbangan_ibfk_1` FOREIGN KEY (`asal_kota`) REFERENCES `kota` (`id_kota`),
  ADD CONSTRAINT `penerbangan_ibfk_2` FOREIGN KEY (`tujuan_kota`) REFERENCES `kota` (`id_kota`),
  ADD CONSTRAINT `penerbangan_ibfk_3` FOREIGN KEY (`id_pesawat`) REFERENCES `pesawat` (`id_pesawat`);

--
-- Constraints for table `pesawat`
--
ALTER TABLE `pesawat`
  ADD CONSTRAINT `pesawat_ibfk_1` FOREIGN KEY (`id_maskapai`) REFERENCES `maskapai` (`id_maskapai`);

--
-- Constraints for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD CONSTRAINT `reservasi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `reservasi_ibfk_2` FOREIGN KEY (`id_paket`) REFERENCES `penerbangan` (`id_paket`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
