-- MySQL dump 10.16  Distrib 10.1.22-MariaDB, for Linux (x86_64)
-- ------------------------------------------------------
-- Server version	5.5.46-log

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text,
  `email` text,
  `data` text,
  `data2` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `resumes`;

CREATE TABLE `resumes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resume` text,
  `users_id` int(11) DEFAULT NULL,
  `data` text,
  `data2` text,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `jobs`;

CREATE TABLE `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job` text,
  `users_id` int(11) DEFAULT NULL,
  `data` text,
  `data2` text,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;





