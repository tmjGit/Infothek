-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 12. Okt 2017 um 12:03
-- Server-Version: 10.1.26-MariaDB
-- PHP-Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `java2`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `adressen`
--

CREATE TABLE `adressen` (
  `id` int(11) NOT NULL,
  `vorname` varchar(255) NOT NULL,
  `nachname` varchar(255) NOT NULL,
  `plz` varchar(255) NOT NULL,
  `ort` varchar(255) NOT NULL,
  `strasse` varchar(255) NOT NULL,
  `telefon` varchar(255) NOT NULL,
  `mobil` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `adressen`
--

INSERT INTO `adressen` (`id`, `vorname`, `nachname`, `plz`, `ort`, `strasse`, `telefon`, `mobil`, `email`) VALUES
(1, 'Hans', 'Schuster', '12345', 'Berlin', 'Waldweg 5', '031-123456', '0177-789456', 'schuster@web.de'),
(2, 'Ina', 'Müller', '33555', 'Hamburg', 'Parkstr. 5', '020-528741', '0163-236589', 'mueller@gmx.de'),
(3, 'Richard', 'Lömmer', '12345', 'Hannover', 'Hauptstr. 98', '062-568214', '0177-56232114', 'ploemmer@web.de'),
(4, 'Hannelore', 'Schirmer', '65432', 'Lauf', 'Nürnberger Str. 23', '089-6548', '0166-22336655', 'schirmer@gmail.de'),
(6, 'Anton', 'Maier', '23458', 'Dresden', 'Goetheweg 90', '0224-321586', '0133-5698752', '1236@gmail.com'),
(10, 'Alonso', 'Frederick', '12345', 'München', 'Bayern Str. 5', '089-69852', '0145-259', 'frederick@bayern-online.by'),
(13, 'Kain', 'Abel', '123456', 'Berlin', 'Frankfurter Alle 89', '030-65874', '0175-56248', 'fun@t-online.de'),
(14, 'Saul', 'Better', '223355', 'Görlitz', 'Polnischer Weg 9', '0265-369852', '01487-36528', 'bettercallsaul@yahoo.de');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `adressen`
--
ALTER TABLE `adressen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `adressen`
--
ALTER TABLE `adressen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
