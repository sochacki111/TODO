CREATE DATABASE  IF NOT EXISTS `todo_directory`;
USE `todo_directory`;



DROP TABLE IF EXISTS `todo`;

CREATE TABLE `todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



INSERT INTO `todo` VALUES 
	(1,'Do Homework'),
	(2,'Do Workout'),
	(3,'Make some university things');

