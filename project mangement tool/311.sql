-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 20, 2015 at 02:27 PM
-- Server version: 5.6.12
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `311`
--
CREATE DATABASE IF NOT EXISTS `311` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `311`;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` int(11) NOT NULL,
  `taskID` varchar(15) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `commentDate` datetime DEFAULT NULL,
  `commentDetails` text,
  PRIMARY KEY (`id`),
  KEY `comment_fkey` (`taskID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `projectID`, `taskID`, `username`, `commentDate`, `commentDetails`) VALUES
(1, 1, '1', 'mymk997', '2015-05-20 00:17:49', 'Why is this task taking so long to complete?'),
(2, 1, '1', 'hd123', '2015-05-20 00:25:10', 'Because I need to prepare lectures for my students. I can''t sit around implementing cement all day!!!!'),
(3, 1, '1', 'kpv', '2015-05-20 00:28:23', 'Chill guys. We need can''t fight over this puny matter. Let''s go to Sydney and chill over the weekend. Sound good?'),
(4, 1, '1', 'ngsw123', '2015-05-20 00:29:13', 'I can drive to Sydney. But you all better chip in for fuel money. >:)'),
(5, 1, '1', 'mymk997', '2015-05-20 09:14:28', 'kk. You''re so bossy Wee.'),
(6, 1, '1', 'mymk997', '2015-05-20 15:43:02', 'this is a comment'),
(7, 1, '2', 'mymk997', '2015-05-20 15:47:02', 'This is a comment'),
(8, 1, '1', 'mymk997', '2015-05-20 16:23:46', 'SCAMMMM');

-- --------------------------------------------------------

--
-- Table structure for table `milestone`
--

CREATE TABLE IF NOT EXISTS `milestone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` int(11) NOT NULL,
  `date` date NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `milestone`
--

INSERT INTO `milestone` (`id`, `projectID`, `date`, `name`) VALUES
(1, 1, '2015-05-31', 'Phase 1 Complete'),
(2, 5, '2015-05-20', 'This is a milestone');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `projectID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `status` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `location` varchar(45) NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `percentcomplete` int(11) NOT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`projectID`, `name`, `status`, `description`, `location`, `startdate`, `enddate`, `percentcomplete`) VALUES
(1, 'Project Management System', 'Active', 'Manages projects.', 'Malaysia', '2015-01-01', '2015-12-31', 0),
(2, 'Diet Management System', 'Complete', 'Manages diet.', 'Australia', '2014-12-14', '2016-05-26', 0),
(3, 'Car Management System', 'Active', 'Manages cars.', 'Germany', '2015-05-01', '2016-11-05', 0),
(4, 'Mac Enrollment System', 'Active', 'MacD', 'Malaysia', '2015-10-31', '2017-08-06', 0),
(5, 'Conference Management System', 'Active', 'This is a new conference management system', 'Malaysia', '2015-05-18', '2015-05-27', 0),
(6, 'Security Management System', 'Active', 'Security Security', 'Tasmania', '2015-10-22', '2018-12-26', 0);

-- --------------------------------------------------------

--
-- Table structure for table `projectmanager`
--

CREATE TABLE IF NOT EXISTS `projectmanager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `projectID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `projectmanager`
--

INSERT INTO `projectmanager` (`id`, `username`, `projectID`) VALUES
(1, 'mymk997', 1),
(2, 'mymk997', 2),
(3, 'mymk997', 3),
(4, 'mymk997', 4),
(5, 'jb123', 5),
(6, 'swn881', 6);

-- --------------------------------------------------------

--
-- Table structure for table `projectroles`
--

CREATE TABLE IF NOT EXISTS `projectroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` int(11) NOT NULL,
  `rolename` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `projectroles`
--

INSERT INTO `projectroles` (`id`, `projectID`, `rolename`) VALUES
(1, 1, 'Magic Maker'),
(2, 1, 'Tractor Driver'),
(3, 1, 'Mouse Clicker'),
(4, 1, 'Screw Driver'),
(5, 1, 'Mind Bomber'),
(6, 1, 'Lead Programmer'),
(7, 1, 'Lead Tester'),
(8, 2, 'Lead Tester'),
(9, -1, 'Programmer'),
(10, -1, 'Tester'),
(11, -1, 'Designer'),
(12, 5, 'Lead Programmer'),
(13, 5, 'Lead Tester'),
(14, 5, 'Lead Designer'),
(15, 5, 'Composer'),
(16, 3, 'Writer'),
(17, 4, 'Technical Writer'),
(18, 4, 'Book Flipper'),
(19, 4, 'Sandal Wearer'),
(20, 4, 'Lightbulb Turner');

-- --------------------------------------------------------

--
-- Table structure for table `projectworkedon`
--

CREATE TABLE IF NOT EXISTS `projectworkedon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `projectID` int(11) NOT NULL,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `projectworkedon`
--

INSERT INTO `projectworkedon` (`id`, `username`, `projectID`, `role`) VALUES
(1, 'hd123', 1, 'Lead Programmer'),
(2, 'jb123', 1, 'Tractor Driver'),
(3, 'mymk997', 1, 'Lead Programmer'),
(4, 'kpv', 1, 'Screw Driver'),
(5, 'ngsw123', 1, 'Magic Maker'),
(6, 'swn881', 5, 'Programmer'),
(7, 'jb123', 5, 'Designer');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` int(11) DEFAULT NULL,
  `taskID` varchar(15) NOT NULL,
  `taskName` varchar(50) DEFAULT NULL,
  `taskStatus` varchar(20) DEFAULT NULL,
  `taskDetails` text,
  `taskPriority` varchar(10) DEFAULT NULL,
  `percentcomplete` int(11) NOT NULL,
  `daysrequired` int(11) NOT NULL,
  `optimisticdays` int(11) NOT NULL,
  `pessimisticdays` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `task_fkey` (`projectID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id`, `projectID`, `taskID`, `taskName`, `taskStatus`, `taskDetails`, `taskPriority`, `percentcomplete`, `daysrequired`, `optimisticdays`, `pessimisticdays`) VALUES
(1, 1, '1', 'Implement cement', 'Active', 'Need cement to fill in the nasty gaps! This is a test', 'High', 62, 30, 25, 38),
(2, 1, '2', 'Write report', 'Active', 'We must write the report~~~', 'High', 20, 10, 7, 14),
(3, 1, '3', 'Feed the cat', 'Unassigned', 'Feed the cat before it starves!', 'High', 8, 4, 3, 5),
(4, 5, '1', 'Monkey', 'Active', 'Monkey', 'Medium', 0, 20, 17, 25),
(5, 5, '2', 'Systems requirement specification', 'Active', 'Requirements!', 'High', 38, 7, 6, 6);

-- --------------------------------------------------------

--
-- Table structure for table `taskdependencies`
--

CREATE TABLE IF NOT EXISTS `taskdependencies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` int(11) NOT NULL,
  `taskID` varchar(15) NOT NULL,
  `precedingTask` varchar(15) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `td_fkey1` (`taskID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `taskdependencies`
--

INSERT INTO `taskdependencies` (`id`, `projectID`, `taskID`, `precedingTask`) VALUES
(1, 1, '3', '1'),
(2, 1, '3', '2'),
(3, 1, '1', '0'),
(4, 1, '2', '1'),
(5, 5, '1', '0'),
(6, 5, '2', '0');

-- --------------------------------------------------------

--
-- Table structure for table `taskworkedon`
--

CREATE TABLE IF NOT EXISTS `taskworkedon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` int(11) NOT NULL,
  `taskID` varchar(15) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `taskworkedon`
--

INSERT INTO `taskworkedon` (`id`, `projectID`, `taskID`, `username`) VALUES
(1, 1, '1', 'mymk997'),
(2, 1, '1', 'jb123'),
(3, 1, '1', 'ngsw123'),
(4, 1, '1', 'jb123'),
(5, 5, '2', 'swn881'),
(6, 5, '1', 'swn881');

-- --------------------------------------------------------

--
-- Table structure for table `userexpertise`
--

CREATE TABLE IF NOT EXISTS `userexpertise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `expertise` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `userexpertise`
--

INSERT INTO `userexpertise` (`id`, `username`, `expertise`) VALUES
(1, 'mymk997', 'C++ Programmer'),
(2, 'mymk997', 'JavaScript Programmer'),
(3, 'kpv', 'Car Salesman'),
(4, 'hd123', 'Software Engineering Consultant'),
(5, 'jb123', 'C++ Programmer'),
(6, 'kpv', 'C++ Programmer'),
(7, 'mymk997', 'PHP Programmer'),
(8, 'mymk997', 'Java Programmer'),
(9, 'swn881', 'Programmer'),
(10, 'swn881', 'Designer'),
(11, 'swn881', 'Composer');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE IF NOT EXISTS `userinfo` (
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `staffID` varchar(30) NOT NULL,
  `password` blob NOT NULL,
  `email` varchar(30) NOT NULL,
  `userrole` varchar(30) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `staffID` (`staffID`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`fname`, `lname`, `username`, `staffID`, `password`, `email`, `userrole`) VALUES
('Hoa', 'Dam', 'hd123', '123', 0x6438353738656466383435386365303666626335626237366135386335636134, 'hd123@uow.edu.au', 'Project Manager'),
('Jon', 'Baird', 'jb123', 'qwerty', 0x6438353738656466383435386365303666626335626237366135386335636134, 'jb123@qwerty.com', 'Project Manager'),
('Jicheng', 'Li', 'jl123', '657558483', 0x6438353738656466383435386365303666626335626237366135386335636134, 'jl123@uow.au', 'Project Member'),
('Kapil', 'Vigneswaren', 'kpv', 'kpv123', 0x6438353738656466383435386365303666626335626237366135386335636134, 'kpv@qwe.com', 'Project Manager'),
('Michael', 'Kong', 'mymk997', '123456', 0x6438353738656466383435386365303666626335626237366135386335636134, 'mymk997@uowmail.edu.au', 'Administrator'),
('Shien Wee', 'Ng', 'ngsw123', '456789', 0x6438353738656466383435386365303666626335626237366135386335636134, 'ngsw123@qwerty.com', 'Project Member'),
('Samuel', 'Mills', 'sm123', 'sam123', 0x6438353738656466383435386365303666626335626237366135386335636134, 'sm123@qwe.com', 'Project Member'),
('wee', 'h wee', 'swn881', '12345', 0x3230326362393632616335393037356239363462303731353264323334623730, 'swn881@uowmail.edu.au', 'Project Member');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
