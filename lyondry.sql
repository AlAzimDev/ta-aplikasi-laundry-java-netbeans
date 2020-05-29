-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Bulan Mei 2020 pada 11.07
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lyondry`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_laundry`
--

CREATE TABLE `jenis_laundry` (
  `id_jenislaundry` int(11) NOT NULL,
  `barang` varchar(45) NOT NULL,
  `harga_perkg` varchar(12) DEFAULT NULL,
  `harga_peritem` varchar(12) DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `laporan_user`
--

CREATE TABLE `laporan_user` (
  `id_laporanuser` int(11) NOT NULL,
  `deskripsi_laporan` text NOT NULL,
  `id_laundry` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `laundry`
--

CREATE TABLE `laundry` (
  `id_laundry` int(11) NOT NULL,
  `alamat` text NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_penyedia` int(11) DEFAULT NULL,
  `id_jenislaundry` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `total_pembayaran` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rating`
--

CREATE TABLE `rating` (
  `id_rating` int(11) NOT NULL,
  `rating` enum('1','2','3','4','5') NOT NULL,
  `id_penyedia` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_laundry` int(11) NOT NULL,
  `metode_pembayaran` enum('dana','ovo','gopay') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `handphone` varchar(20) NOT NULL,
  `password` text NOT NULL,
  `alamat` text NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jenis_laundry`
--
ALTER TABLE `jenis_laundry`
  ADD PRIMARY KEY (`id_jenislaundry`);

--
-- Indeks untuk tabel `laporan_user`
--
ALTER TABLE `laporan_user`
  ADD PRIMARY KEY (`id_laporanuser`),
  ADD UNIQUE KEY `id_laundry` (`id_laundry`);

--
-- Indeks untuk tabel `laundry`
--
ALTER TABLE `laundry`
  ADD PRIMARY KEY (`id_laundry`),
  ADD UNIQUE KEY `id_user` (`id_user`);

--
-- Indeks untuk tabel `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id_rating`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD UNIQUE KEY `id_laundry` (`id_laundry`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `handphone` (`handphone`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jenis_laundry`
--
ALTER TABLE `jenis_laundry`
  MODIFY `id_jenislaundry` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `laporan_user`
--
ALTER TABLE `laporan_user`
  MODIFY `id_laporanuser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `laundry`
--
ALTER TABLE `laundry`
  MODIFY `id_laundry` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT untuk tabel `rating`
--
ALTER TABLE `rating`
  MODIFY `id_rating` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
