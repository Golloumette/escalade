-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : mar. 15 déc. 2020 à 12:29
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `escalade`
--

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text DEFAULT NULL,
  `dt_comment` datetime DEFAULT NULL,
  `utilisateur_id` int(11) NOT NULL,
  `site_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`utilisateur_id`,`site_id`),
  KEY `fk_commentaire_utilisateur1_idx` (`utilisateur_id`),
  KEY `fk_commentaire_site1_idx` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `text`, `dt_comment`, `utilisateur_id`, `site_id`) VALUES
(1, 'très beau site', '2020-12-08 20:33:50', 2, 1),
(2, 'parfait pour les débutants', '2020-12-08 20:29:47', 1, 1),
(3, 'comment1.3', '2020-11-20 15:07:04', 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `longueur`
--

DROP TABLE IF EXISTS `longueur`;
CREATE TABLE IF NOT EXISTS `longueur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spit` tinytext DEFAULT NULL,
  `cotation` varchar(45) DEFAULT NULL,
  `subdivision` varchar(5) NOT NULL,
  `voie_id` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  PRIMARY KEY (`id`,`voie_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_longueur_voie1_idx` (`voie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `longueur`
--

INSERT INTO `longueur` (`id`, `spit`, `cotation`, `subdivision`, `voie_id`, `nom`) VALUES
(1, 'spit1.1', '3', 'a', 1, 'longueur1.1'),
(2, 'spit2', '4', 'b', 1, 'longueur1.2'),
(3, 'spit1.3', '9', '+', 1, 'longueur1.3'),
(5, 'spit2', '5', 'b', 6, 'long2.1'),
(6, 'spit1', '3', 'a', 6, 'long2.2');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `utilisateur_id` int(11) NOT NULL,
  `topo_id` int(11) NOT NULL,
  `dt_reservation` datetime DEFAULT NULL,
  `valider` tinyint(5) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_utilisateur_has_topo_topo1_idx` (`topo_id`),
  KEY `fk_utilisateur_has_topo_utilisateur1_idx` (`utilisateur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`utilisateur_id`, `topo_id`, `dt_reservation`, `valider`, `id`) VALUES
(2, 2, '2020-11-21 09:18:13', 1, 1),
(2, 4, '2020-11-29 12:28:49', 1, 2),
(1, 5, '2020-11-29 12:55:37', 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `secteur`
--

DROP TABLE IF EXISTS `secteur`;
CREATE TABLE IF NOT EXISTS `secteur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `descriptif` varchar(500) DEFAULT NULL,
  `acces` varchar(200) DEFAULT NULL,
  `site_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`site_id`),
  KEY `fk_secteur_site1_idx` (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `secteur`
--

INSERT INTO `secteur` (`id`, `nom`, `descriptif`, `acces`, `site_id`) VALUES
(1, 'secteur1.1', 'description1.1', 'acces1.1', 1),
(2, 'secteur1.2', 'descriptif1.2', 'acces1.2', 1),
(3, 'secteur1.3', 'descriptif1.3', 'acces1.3', 1),
(4, 'secteur1.4', 'descriptif1.4', 'acces1.4', 1),
(7, 'sect2', 'd2', 'a2', 2),
(8, 'sect2.2', 'd2.2', 'a2.2', 2),
(9, 'sect2.3', 'd2.3', 'a2.3', 2),
(10, 'secteur1.5', 'des1.5', 'acces1.5', 1),
(11, 'secteur1.6', 'des1.6', 'acces1.6', 1),
(12, 'ABLON 1.1', 'DESC1.1', 'ACCES ABLON 1.1', 6),
(13, 'ABLON 1.2', 'DES1.2', 'ACCES ABLON 1.2', 6),
(14, 'ABLON 1.3', 'DESC 1.3', 'ACCES ABLON 1.3', 6),
(15, 'ABLON1.4 ', 'DESC1.4', 'ACCES ABLON 1.4', 6),
(16, 'ABLON1.5', 'DESC1.5', 'ACCES ABLON 1.5', 6),
(17, 'ABLON1.6', 'DESC1.6', 'ACCES ABLON 1.6', 6),
(18, 'ABLON1.7', 'DESC1.7', 'ACCES ABLON 1.7', 6),
(19, 'ABLON1.8', 'DESC1.8', 'ACCES ABLON 1.8', 6),
(20, 'ABLON1.9', 'DESC1.9', 'ACCES ABLON1.9', 6),
(21, 'ABLON1.10', 'DESC1.10', 'ACCES ABLON 1.10', 6),
(22, 'ABLON 1.11', 'DESC1.11', 'ACCES ABLON 1.11', 6),
(23, 'Castillon 1.1', 'desc1.1', 'Acces Castillon', 7),
(24, 'orlu 1.1', 'desc1.1', 'acces 1.1', 9);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `lieu` varchar(45) DEFAULT NULL,
  `officiel` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`id`, `nom`, `lieu`, `officiel`) VALUES
(1, 'site1', 'lieu11', 0),
(2, 'site2', 'lieu2', 0),
(3, 'site3', 'lieu3', 1),
(6, 'Ablon', 'Ablon', 1),
(7, 'Castillon', 'Alpes Maritimes', 1),
(8, 'Le Fournel', 'Hautes Alpes', 1),
(9, 'Orlu', 'Arriège', 1),
(10, 'Orpierre', 'Hautes Alpes', 1),
(11, 'Tousaus', 'Hautes Pyrénées', 1);

-- --------------------------------------------------------

--
-- Structure de la table `topo`
--

DROP TABLE IF EXISTS `topo`;
CREATE TABLE IF NOT EXISTS `topo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `description` varchar(250) NOT NULL,
  `lieu` varchar(45) NOT NULL,
  `dt_parution` datetime DEFAULT NULL,
  `disponible` tinyint(1) NOT NULL,
  `utilisateur_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`utilisateur_id`),
  KEY `fk_topo_utilisateur1_idx` (`utilisateur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `topo`
--

INSERT INTO `topo` (`id`, `nom`, `description`, `lieu`, `dt_parution`, `disponible`, `utilisateur_id`) VALUES
(2, 'topoadmin2', 'topodesc2', 'topolieu2', '2019-03-11 23:00:00', 0, 1),
(3, 'topoadmin', 'topodescription2', 'topoadmin', '2018-09-04 22:00:00', 0, 1),
(4, 'TOPO ABLON', 'Très jolie avec des secteurs variés', 'ABLON', '2020-05-12 22:00:00', 2, 3),
(5, 'topo mine', 'terril ', 'noeux les mines', '2019-08-12 22:00:00', 2, 2),
(6, 'topoadmin2', 'terril', 'noeux les mines', '2020-11-30 23:00:00', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `pseudo` varchar(45) NOT NULL,
  `mdp` varchar(45) DEFAULT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `postal` varchar(45) DEFAULT NULL,
  `ville` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `role` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pseudo_UNIQUE` (`pseudo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `pseudo`, `mdp`, `adresse`, `postal`, `ville`, `mail`, `tel`, `role`) VALUES
(1, 'Admin', 'Fred', 'admin', 'admin', '8 bis grand place', '59200', 'tourcoing', 'admin.fred@gmail.com', '0320000000', 2),
(2, 'Admin2', 'Caroline', 'admin1', 'd033e22ae348aeb5660fc2140aec35850c4da997', '8 bis grand place', '59200', 'tourcoing', 'admin@gmail.com', '0600000000', 2),
(3, 'BOUCAU', 'CAROLINE', 'BOUCAU', 'ADMIN', 'RUE JULES GUESDE', '59510', 'HEM', 'caroline.boucau59@gmail.com', '0645534611', 1),
(4, 'BOUCAU', 'SYLVAIN', 'BLACK', 'user', '231 rue jules guesde', '59510', 'hem', 'sboucau@gmail.com', '060700000000', 1);

-- --------------------------------------------------------

--
-- Structure de la table `voie`
--

DROP TABLE IF EXISTS `voie`;
CREATE TABLE IF NOT EXISTS `voie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cotation` varchar(45) DEFAULT NULL,
  `secteur_id` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `subdivision` varchar(10) NOT NULL,
  `equipe` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`,`secteur_id`),
  KEY `fk_voie_secteur1_idx` (`secteur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `voie`
--

INSERT INTO `voie` (`id`, `cotation`, `secteur_id`, `nom`, `subdivision`, `equipe`) VALUES
(1, '3', 1, 'voie1.1', 'a', 1),
(2, '4', 1, 'voie1.2', 'b', 0),
(3, '5', 1, 'voie1.3', 'c', 1),
(4, '6', 1, 'voie1.4', '+', 0),
(6, '6', 7, 'voie2.1', 'c', 1),
(7, '5', 7, 'voie2.2', 'a', 1),
(9, '9', 12, 'ABLON VOIE 9', 'a', 1),
(10, '8', 23, 'Castillon Voie 8', 'a', 1),
(11, '5', 24, 'orlu voie 5', 'a', 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_commentaire_site1` FOREIGN KEY (`site_id`) REFERENCES `site` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_commentaire_utilisateur1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `longueur`
--
ALTER TABLE `longueur`
  ADD CONSTRAINT `fk_longueur_voie1` FOREIGN KEY (`voie_id`) REFERENCES `voie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_utilisateur_has_topo_topo1` FOREIGN KEY (`topo_id`) REFERENCES `topo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_utilisateur_has_topo_utilisateur1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `secteur`
--
ALTER TABLE `secteur`
  ADD CONSTRAINT `fk_secteur_site1` FOREIGN KEY (`site_id`) REFERENCES `site` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `topo`
--
ALTER TABLE `topo`
  ADD CONSTRAINT `fk_topo_utilisateur1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `voie`
--
ALTER TABLE `voie`
  ADD CONSTRAINT `fk_voie_secteur1` FOREIGN KEY (`secteur_id`) REFERENCES `secteur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
