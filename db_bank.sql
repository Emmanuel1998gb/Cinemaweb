-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 20 mai 2022 à 10:51
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_bank`
--

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE `banque` (
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `banque`
--

INSERT INTO `banque` (`id`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `dtype` varchar(31) NOT NULL,
  `code` int(11) NOT NULL,
  `interet_due` double DEFAULT NULL,
  `solde` double NOT NULL,
  `decouvert` double DEFAULT NULL,
  `taux` float DEFAULT NULL,
  `banque_id` int(11) DEFAULT NULL,
  `proprietaire_id_pro` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`dtype`, `code`, `interet_due`, `solde`, `decouvert`, `taux`, `banque_id`, `proprietaire_id_pro`) VALUES
('CompteCourant', 1, NULL, 4, 50, NULL, 1, 1),
('CompteCourant', 2, NULL, 5910, 50, NULL, NULL, 11),
('CompteEpargne', 3, NULL, 160, NULL, 1, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `dtype` varchar(31) NOT NULL,
  `numero` int(11) NOT NULL,
  `dateoperation` datetime DEFAULT current_timestamp(),
  `montant` double NOT NULL,
  `interet_due` double DEFAULT NULL,
  `compte_code` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id_pro` varchar(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `noms` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id_pro`, `adresse`, `noms`) VALUES
('7679M', 'Goma', 'Francine Adakumi'),
('7679F', 'Butembo', 'Lysa Ndemesi'),
('887N', 'Jonathan Kalumuna', 'Goma');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `comptes` int(11) NOT NULL,
  `depot` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `retrait` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `comptes`, `depot`, `email`, `fname`, `lname`, `mname`, `password`, `retrait`, `username`) VALUES
(0, 1, 0, 'irjiresse@gmail.com', 'jr', 'ms', 'km', '1234', 0, 'jiresse');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `banque`
--
ALTER TABLE `banque`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FKs5iy504jylpbkam6j96ll2ik` (`banque_id`),
  ADD KEY `FK31ibcrd21kqsrt4m5k9w2668r` (`proprietaire_id_pro`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FK80sn813761rbfkon6xcnqei7q` (`compte_code`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id_pro`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
