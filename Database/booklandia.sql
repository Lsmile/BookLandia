-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dic 09, 2014 alle 09:31
-- Versione del server: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `booklandia`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `addetti_scaffali`
--

CREATE TABLE IF NOT EXISTS `addetti_scaffali` (
  `ID_Addetto_Scaffali` int(11) NOT NULL,
  PRIMARY KEY (`ID_Addetto_Scaffali`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `addetti_vendite`
--

CREATE TABLE IF NOT EXISTS `addetti_vendite` (
  `ID_Addetto_Vendite` int(11) NOT NULL,
  PRIMARY KEY (`ID_Addetto_Vendite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `autori`
--

CREATE TABLE IF NOT EXISTS `autori` (
  `Nome` varchar(25) NOT NULL,
  `Cognome` varchar(25) NOT NULL,
  `Codice_Autore` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Codice_Autore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `case_editrici`
--

CREATE TABLE IF NOT EXISTS `case_editrici` (
  `Nome` varchar(45) NOT NULL,
  `ID_Casa_Editrice` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_Casa_Editrice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `ID_Cliente` int(11) NOT NULL,
  PRIMARY KEY (`ID_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `generi`
--

CREATE TABLE IF NOT EXISTS `generi` (
  `Nome` varchar(45) NOT NULL,
  `Codice_Genere` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Codice_Genere`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dump dei dati per la tabella `generi`
--

INSERT INTO `generi` (`Nome`, `Codice_Genere`) VALUES
('', 1),
('azione', 2),
('Azione', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `libri`
--

CREATE TABLE IF NOT EXISTS `libri` (
  `Titolo` varchar(40) NOT NULL,
  `Prezzo` double NOT NULL,
  `ISBN` char(13) NOT NULL,
  `Case_Editrici_ID_Casa_Editrice` int(11) NOT NULL,
  `Generi_Codice_Genere` int(11) NOT NULL,
  `Autori_Codice_Autore` int(11) NOT NULL,
  `CopieDisponibili` int(11) NOT NULL,
  `Scaffali_ID_Scaffale` int(11) NOT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `fk_Libri_Case_Editrici1_idx` (`Case_Editrici_ID_Casa_Editrice`),
  KEY `fk_Libri_Generi1_idx` (`Generi_Codice_Genere`),
  KEY `fk_Libri_Autori1_idx` (`Autori_Codice_Autore`),
  KEY `fk_Libri_Scaffali1_idx` (`Scaffali_ID_Scaffale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordinazioni`
--

CREATE TABLE IF NOT EXISTS `ordinazioni` (
  `ID_Ordinazione` int(11) NOT NULL AUTO_INCREMENT,
  `Stato` tinyint(1) DEFAULT NULL,
  `Data_Inserimento` date NOT NULL,
  `Cliente_Utente_ID_Utente` int(11) DEFAULT NULL,
  `Data_Completato` date DEFAULT NULL,
  `ISBN` char(13) DEFAULT NULL,
  `Data_Consegna` date DEFAULT NULL,
  PRIMARY KEY (`ID_Ordinazione`),
  KEY `fk_Ordinazioni_Cliente1_idx` (`Cliente_Utente_ID_Utente`),
  KEY `fk_Ordinazioni_Libri1_idx` (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `scaffali`
--

CREATE TABLE IF NOT EXISTS `scaffali` (
  `Settore` varchar(10) NOT NULL,
  `NumeroScaffale` int(11) NOT NULL,
  `ID_Scaffale` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroLibreria` int(11) NOT NULL,
  PRIMARY KEY (`ID_Scaffale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE IF NOT EXISTS `utente` (
  `Username` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Cognome` varchar(25) NOT NULL,
  `ID_Utente` int(11) NOT NULL AUTO_INCREMENT,
  `CodiceFiscale` char(16) NOT NULL,
  PRIMARY KEY (`ID_Utente`,`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `vendite`
--

CREATE TABLE IF NOT EXISTS `vendite` (
  `Vendite_Codice_Vendita` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` char(13) NOT NULL,
  `Cliente_Utente_ID_Utente` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Quantità` int(11) NOT NULL,
  PRIMARY KEY (`Vendite_Codice_Vendita`),
  KEY `fk_Libri_has_Vendite_Libri1_idx` (`ISBN`),
  KEY `fk_Libri_has_Vendite_Cliente1_idx` (`Cliente_Utente_ID_Utente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `addetti_scaffali`
--
ALTER TABLE `addetti_scaffali`
  ADD CONSTRAINT `fk_Addetti_Scaffali_Utente1` FOREIGN KEY (`ID_Addetto_Scaffali`) REFERENCES `utente` (`ID_Utente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `addetti_vendite`
--
ALTER TABLE `addetti_vendite`
  ADD CONSTRAINT `fk_Addetti_Vendite_Utente1` FOREIGN KEY (`ID_Addetto_Vendite`) REFERENCES `utente` (`ID_Utente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_Cliente_Utente1` FOREIGN KEY (`ID_Cliente`) REFERENCES `utente` (`ID_Utente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `libri`
--
ALTER TABLE `libri`
  ADD CONSTRAINT `fk_Libri_Case_Editrici1` FOREIGN KEY (`Case_Editrici_ID_Casa_Editrice`) REFERENCES `case_editrici` (`ID_Casa_Editrice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Libri_Generi1` FOREIGN KEY (`Generi_Codice_Genere`) REFERENCES `generi` (`Codice_Genere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Libri_Autori1` FOREIGN KEY (`Autori_Codice_Autore`) REFERENCES `autori` (`Codice_Autore`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Libri_Scaffali1` FOREIGN KEY (`Scaffali_ID_Scaffale`) REFERENCES `scaffali` (`ID_Scaffale`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `ordinazioni`
--
ALTER TABLE `ordinazioni`
  ADD CONSTRAINT `fk_Ordinazioni_Cliente1` FOREIGN KEY (`Cliente_Utente_ID_Utente`) REFERENCES `cliente` (`ID_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Ordinazioni_Libri1` FOREIGN KEY (`ISBN`) REFERENCES `libri` (`ISBN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `vendite`
--
ALTER TABLE `vendite`
  ADD CONSTRAINT `fk_Libri_has_Vendite_Libri1` FOREIGN KEY (`ISBN`) REFERENCES `libri` (`ISBN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Libri_has_Vendite_Cliente1` FOREIGN KEY (`Cliente_Utente_ID_Utente`) REFERENCES `cliente` (`ID_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
