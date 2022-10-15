-- MySQL dump 10.16  Distrib 10.1.22-MariaDB, for Linux (x86_64)
-- ------------------------------------------------------
-- Server version	5.5.46-log

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text,
  `email` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;