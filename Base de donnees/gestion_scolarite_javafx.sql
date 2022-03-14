-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 17 fév. 2022 à 11:04
-- Version du serveur : 8.0.27
-- Version de PHP : 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_scolarite_javafx`
--

-- --------------------------------------------------------

--
-- Structure de la table `agentdescolarite`
--

DROP TABLE IF EXISTS `agentdescolarite`;
CREATE TABLE IF NOT EXISTS `agentdescolarite` (
  `id_agent` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `maill` varchar(50) NOT NULL,
  `pseudo` varchar(50) NOT NULL,
  `mot_passe` varchar(50) NOT NULL,
  `matricule` varchar(50) NOT NULL,
  PRIMARY KEY (`id_agent`),
  KEY `AgentDeScolarite_Directeur_FK` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `directeur`
--

DROP TABLE IF EXISTS `directeur`;
CREATE TABLE IF NOT EXISTS `directeur` (
  `matricule` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `pseudo` varchar(50) NOT NULL,
  `mot_passe` varchar(50) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `matricule` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  `mail` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `id_filiere` int NOT NULL,
  `id_niveau` int NOT NULL,
  PRIMARY KEY (`matricule`),
  KEY `Etudiant_Filiere_FK` (`id_filiere`),
  KEY `Etudiant_Niveau0_FK` (`id_niveau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

DROP TABLE IF EXISTS `filiere`;
CREATE TABLE IF NOT EXISTS `filiere` (
  `id_filiere` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`id_filiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id_niveau` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  `montant_scolarite` double NOT NULL,
  PRIMARY KEY (`id_niveau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `versement`
--

DROP TABLE IF EXISTS `versement`;
CREATE TABLE IF NOT EXISTS `versement` (
  `id_agent` int NOT NULL,
  `matricule` varchar(50) NOT NULL,
  `date_versement` date NOT NULL,
  `montant` double NOT NULL,
  PRIMARY KEY (`id_agent`,`matricule`),
  KEY `versement_Etudiant0_FK` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `agentdescolarite`
--
ALTER TABLE `agentdescolarite`
  ADD CONSTRAINT `AgentDeScolarite_Directeur_FK` FOREIGN KEY (`matricule`) REFERENCES `directeur` (`matricule`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `Etudiant_Filiere_FK` FOREIGN KEY (`id_filiere`) REFERENCES `filiere` (`id_filiere`),
  ADD CONSTRAINT `Etudiant_Niveau0_FK` FOREIGN KEY (`id_niveau`) REFERENCES `niveau` (`id_niveau`);

--
-- Contraintes pour la table `versement`
--
ALTER TABLE `versement`
  ADD CONSTRAINT `versement_AgentDeScolarite_FK` FOREIGN KEY (`id_agent`) REFERENCES `agentdescolarite` (`id_agent`),
  ADD CONSTRAINT `versement_Etudiant0_FK` FOREIGN KEY (`matricule`) REFERENCES `etudiant` (`matricule`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
