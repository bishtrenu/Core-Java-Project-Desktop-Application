-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.18-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema precursor
--

CREATE DATABASE IF NOT EXISTS precursor;
USE precursor;

--
-- Definition of table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `Userid` varchar(45) NOT NULL,
  `Userpass` varchar(45) NOT NULL,
  `Usertype` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`Userid`,`Userpass`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`Userid`,`Userpass`,`Usertype`) VALUES 
 ('Neeraj','neeraj123','Counseller'),
 ('pankaj','singh04','Trainer'),
 ('prakash','bishtprakash','Counseller'),
 ('renu','renubisht1824','admin'),
 ('shiva','shiva666','Counseller'),
 ('shivanshu','shiv@123','Academichead'),
 ('shriya','9090','Trainer');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


--
-- Definition of table `assignproject`
--

DROP TABLE IF EXISTS `assignproject`;
CREATE TABLE `assignproject` (
  `Assignid` int(10) unsigned NOT NULL auto_increment,
  `Projectid` varchar(20) NOT NULL,
  `Studentid` varchar(20) NOT NULL,
  `Dateassigned` datetime NOT NULL,
  PRIMARY KEY  (`Assignid`),
  KEY `FK_assignproject_1` (`Projectid`),
  KEY `FK_assignproject_2` (`Studentid`),
  CONSTRAINT `FK_assignproject_1` FOREIGN KEY (`Projectid`) REFERENCES `project` (`Projectid`),
  CONSTRAINT `FK_assignproject_2` FOREIGN KEY (`Studentid`) REFERENCES `student` (`Studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assignproject`
--

/*!40000 ALTER TABLE `assignproject` DISABLE KEYS */;
INSERT INTO `assignproject` (`Assignid`,`Projectid`,`Studentid`,`Dateassigned`) VALUES 
 (1,'PIS101','SID101','2017-07-26 00:00:00'),
 (2,'PIS102','SID102','2017-07-27 00:00:00'),
 (3,'PIS103','SID103','2017-07-27 00:00:00'),
 (4,'PIS104','SID105','2017-07-28 00:00:00'),
 (5,'PIS103','SID106','2017-07-29 00:00:00');
/*!40000 ALTER TABLE `assignproject` ENABLE KEYS */;


--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cid` varchar(20) NOT NULL,
  `Coursename` varchar(45) NOT NULL,
  `Fee` int(10) unsigned zerofill NOT NULL,
  `Duration` varchar(45) NOT NULL,
  PRIMARY KEY  (`Cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`Cid`,`Coursename`,`Fee`,`Duration`) VALUES 
 ('aJava','Advance Java',0000006000,'2 month'),
 ('asp.net','Asp.net',0000006000,'2 Month'),
 ('cJava','Core Java',0000005500,'1month ,10days'),
 ('php','PHP',0000004000,'1month');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `Studentname` varchar(45) NOT NULL,
  `Feedback` varchar(60) NOT NULL,
  `Studentid` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` (`id`,`Studentname`,`Feedback`,`Studentid`) VALUES 
 (1,'Renu Bisht','Very Good Coaching','SMS101'),
 (2,'pankaj','Ma\'am youare awsome teacher','SID104'),
 (3,'swasti','excellent','SID101');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


--
-- Definition of table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `Projectid` varchar(20) NOT NULL,
  `Projectname` varchar(45) NOT NULL,
  `Categoryid` varchar(20) NOT NULL,
  `Details` varchar(100) NOT NULL,
  PRIMARY KEY  (`Projectid`),
  KEY `FK_project_1` (`Categoryid`),
  CONSTRAINT `FK_project_1` FOREIGN KEY (`Categoryid`) REFERENCES `projectcategory` (`Categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`Projectid`,`Projectname`,`Categoryid`,`Details`) VALUES 
 ('PIS101','Smart Project Scheduling System','PC101','admin  will create account of Trainer,academichead,\ncounsellor.'),
 ('PIS102','Sports Club Management System','PC102','To manage sports club registration details '),
 ('PIS103','Court Hearing','PC101','make a project contain all details of court hearing '),
 ('PIS104','Digital Club','PC102','All the details related to booking of club and etc.'),
 ('PIS105','Slambook','PC101','Make a slam book where your friends and student\n feed Details'),
 ('PSI104','SPSS','PC102','shxdbasjjjjjj');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;


--
-- Definition of table `projectcategory`
--

DROP TABLE IF EXISTS `projectcategory`;
CREATE TABLE `projectcategory` (
  `Categoryid` varchar(20) NOT NULL,
  `Categoryname` varchar(45) NOT NULL,
  PRIMARY KEY  (`Categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projectcategory`
--

/*!40000 ALTER TABLE `projectcategory` DISABLE KEYS */;
INSERT INTO `projectcategory` (`Categoryid`,`Categoryname`) VALUES 
 ('PC101','Summer Training'),
 ('PC102','winterTraining');
/*!40000 ALTER TABLE `projectcategory` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Studentid` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Phno` bigint(20) unsigned NOT NULL,
  `Emailid` varchar(45) NOT NULL,
  `Cid` varchar(20) NOT NULL,
  `Pid` varchar(20) default NULL,
  `Submitted` varchar(45) NOT NULL default 'notsubmitted',
  PRIMARY KEY  (`Studentid`),
  KEY `FK_student_1` (`Cid`),
  CONSTRAINT `FK_student_1` FOREIGN KEY (`Cid`) REFERENCES `course` (`Cid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`Studentid`,`Name`,`Address`,`Phno`,`Emailid`,`Cid`,`Pid`,`Submitted`) VALUES 
 ('SID101','Renu Bisht','90/1 kalaynpur lko',7408139092,'bishtrenu243@gmail.com','cJava','PIS101','Project Submitted'),
 ('SID102','Shivanshu','56 vikash nagar,Lucknow.',7839402758,'shivanshu2409@gmail.com','cJava','PIS102','Project Submitted'),
 ('SID103','Shiva','24/09 Mahanagar Lucknow',9140174634,'shiva123@gmail.com','aJava','PIS103','notsubmitted'),
 ('SID105','Anubhav','sector-14,indranagar lucknow',9049872345,'anusinger@gmail.com','php','PIS104','notsubmitted'),
 ('SID106','Ritu Rawat','Vikas nagar lucknow',7589010101,'rawatji@gmail.com','aJava','PIS103','Project Submitted'),
 ('SID110','gauranshi','abcd',12345677898,'abcdef','aJava',NULL,'notsubmitted');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
