-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Gen 12, 2015 alle 13:02
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

--
-- Dump dei dati per la tabella `addetti_scaffali`
--

INSERT INTO `addetti_scaffali` (`ID_Addetto_Scaffali`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struttura della tabella `addetti_vendite`
--

CREATE TABLE IF NOT EXISTS `addetti_vendite` (
  `ID_Addetto_Vendite` int(11) NOT NULL,
  PRIMARY KEY (`ID_Addetto_Vendite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `addetti_vendite`
--

INSERT INTO `addetti_vendite` (`ID_Addetto_Vendite`) VALUES
(2);

-- --------------------------------------------------------

--
-- Struttura della tabella `autori`
--

CREATE TABLE IF NOT EXISTS `autori` (
  `Nome` varchar(25) NOT NULL,
  `Codice_Autore` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Codice_Autore`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dump dei dati per la tabella `autori`
--

INSERT INTO `autori` (`Nome`, `Codice_Autore`) VALUES
('George Orwell', 1),
('John Niven', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `case_editrici`
--

CREATE TABLE IF NOT EXISTS `case_editrici` (
  `Nome` varchar(45) NOT NULL,
  `ID_Casa_Editrice` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_Casa_Editrice`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `case_editrici`
--

INSERT INTO `case_editrici` (`Nome`, `ID_Casa_Editrice`) VALUES
('Mondadori', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `ID_Cliente` int(11) NOT NULL,
  PRIMARY KEY (`ID_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`ID_Cliente`) VALUES
(3),
(4),
(6),
(8),
(9),
(11),
(12);

-- --------------------------------------------------------

--
-- Struttura della tabella `generi`
--

CREATE TABLE IF NOT EXISTS `generi` (
  `Nome` varchar(45) NOT NULL,
  `Codice_Genere` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Codice_Genere`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `generi`
--

INSERT INTO `generi` (`Nome`, `Codice_Genere`) VALUES
('Romanzo', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `libri`
--

CREATE TABLE IF NOT EXISTS `libri` (
  `Titolo` varchar(40) NOT NULL,
  `Prezzo` double NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` char(13) NOT NULL,
  `Case_Editrici_ID_Casa_Editrice` int(11) NOT NULL,
  `Generi_Codice_Genere` int(11) NOT NULL,
  `Autori_Codice_Autore` int(11) NOT NULL,
  `CopieDisponibili` int(11) NOT NULL,
  `Scaffali_ID_Scaffale` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`ISBN`),
  KEY `fk_Libri_Case_Editrici1_idx` (`Case_Editrici_ID_Casa_Editrice`),
  KEY `fk_Libri_Generi1_idx` (`Generi_Codice_Genere`),
  KEY `fk_Libri_Autori1_idx` (`Autori_Codice_Autore`),
  KEY `fk_Libri_Scaffali1_idx` (`Scaffali_ID_Scaffale`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dump dei dati per la tabella `libri`
--

INSERT INTO `libri` (`Titolo`, `Prezzo`, `ID`, `ISBN`, `Case_Editrici_ID_Casa_Editrice`, `Generi_Codice_Genere`, `Autori_Codice_Autore`, `CopieDisponibili`, `Scaffali_ID_Scaffale`) VALUES
('1984', 10, 1, '1234567890123', 1, 1, 1, 10, 1),
('A volte ritorno', 12, 2, '1467798389', 1, 1, 1, 23, 1);

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
  `Data_Consegna` date DEFAULT NULL,
  `Libri_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID_Ordinazione`,`Libri_ID`),
  KEY `fk_Ordinazioni_Cliente1_idx` (`Cliente_Utente_ID_Utente`),
  KEY `fk_Ordinazioni_Libri2_idx` (`Libri_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `ordinazioni`
--

INSERT INTO `ordinazioni` (`ID_Ordinazione`, `Stato`, `Data_Inserimento`, `Cliente_Utente_ID_Utente`, `Data_Completato`, `Data_Consegna`, `Libri_ID`) VALUES
(1, 0, '2015-01-11', 3, NULL, NULL, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `scaffali`
--

INSERT INTO `scaffali` (`Settore`, `NumeroScaffale`, `ID_Scaffale`, `NumeroLibreria`) VALUES
('Romanzi', 1, 1, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`Username`, `Password`, `Nome`, `Cognome`, `ID_Utente`, `CodiceFiscale`) VALUES
('Scaffale', 'Scaffale', 'Marco', 'Cervellera', 1, 'CRVMRC1234567890'),
('Vendita', 'Vendita', 'Stefano', 'Palma', 2, 'STFPLM1234567890'),
('Cliente', 'Cliente', 'Mario', 'Rossi', 3, 'MRRSS1234567890'),
('NoUser', 'NoUser', 'NoUser', 'NoUser', 4, 'NoUser1234567890'),
('2', '2', '2', '2', 5, 'qwertyuioplkj'),
('1,', '1', ',1,', '1', 6, ' 1231231231234'),
('3,', '3', ',3,', '3', 7, ' GIUEUG1234567'),
('3,', '3', ',3,', '3', 8, ' 1234567890qwe'),
('3,', '3', ',3,', '3', 9, ' 12345678901234'),
('5,', '5', ',5,', '5', 11, ' 12321312'),
('0,', '0', ',0,', '0', 12, ' 5324312');

-- --------------------------------------------------------

--
-- Struttura della tabella `vendite`
--

CREATE TABLE IF NOT EXISTS `vendite` (
  `Vendite_Codice_Vendita` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Cliente` int(11) DEFAULT NULL,
  `Data` date NOT NULL,
  `Quantità` int(11) NOT NULL,
  `Libri_ID` int(11) NOT NULL,
  PRIMARY KEY (`Vendite_Codice_Vendita`,`Libri_ID`),
  KEY `fk_Libri_has_Vendite_Cliente1_idx` (`ID_Cliente`),
  KEY `fk_Vendite_Libri1_idx` (`Libri_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Dump dei dati per la tabella `vendite`
--

INSERT INTO `vendite` (`Vendite_Codice_Vendita`, `ID_Cliente`, `Data`, `Quantità`, `Libri_ID`) VALUES
(4, 3, '2015-01-01', 4, 1),
(5, NULL, '2015-01-07', 3, 1),
(7, 4, '2015-00-07', 11, 1),
(8, 3, '2015-01-07', 22, 1),
(9, 3, '2015-01-08', 1, 2),
(10, 4, '2015-01-08', 1, 1),
(11, 4, '2015-01-08', 1, 1),
(12, 4, '2015-01-08', 3, 2),
(13, 3, '2015-01-08', 2, 2),
(14, 3, '2015-01-08', 3, 1),
(15, 3, '2015-01-08', 1, 1),
(16, 4, '2015-01-08', 1, 1),
(17, NULL, '2015-01-12', 10, 1);

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
  ADD CONSTRAINT `fk_Libri_Autori1` FOREIGN KEY (`Autori_Codice_Autore`) REFERENCES `autori` (`Codice_Autore`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Libri_Case_Editrici1` FOREIGN KEY (`Case_Editrici_ID_Casa_Editrice`) REFERENCES `case_editrici` (`ID_Casa_Editrice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Libri_Generi1` FOREIGN KEY (`Generi_Codice_Genere`) REFERENCES `generi` (`Codice_Genere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Libri_Scaffali1` FOREIGN KEY (`Scaffali_ID_Scaffale`) REFERENCES `scaffali` (`ID_Scaffale`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `ordinazioni`
--
ALTER TABLE `ordinazioni`
  ADD CONSTRAINT `fk_Ordinazioni_Cliente1` FOREIGN KEY (`Cliente_Utente_ID_Utente`) REFERENCES `cliente` (`ID_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Ordinazioni_Libri2` FOREIGN KEY (`Libri_ID`) REFERENCES `libri` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `vendite`
--
ALTER TABLE `vendite`
  ADD CONSTRAINT `fk_Libri_has_Vendite_Cliente1` FOREIGN KEY (`ID_Cliente`) REFERENCES `cliente` (`ID_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vendite_Libri1` FOREIGN KEY (`Libri_ID`) REFERENCES `libri` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
