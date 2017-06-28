-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-05-11 11:14:43
-- 服务器版本： 5.00.15
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `application`
--

-- --------------------------------------------------------

--
-- 表的结构 `job`
--

CREATE TABLE IF NOT EXISTS `job` (
  `ID` int(11) NOT NULL auto_increment,
  `JNAME` varchar(255) default NULL,
  `PARTMENT` varchar(255) default NULL,
  `WORKTYPE` varchar(255) default NULL,
  `SALARY` varchar(255) default NULL,
  `JEDU` varchar(255) default NULL,
  `PNUM` varchar(255) default NULL,
  `JDATE` varchar(255) default NULL,
  `JPERSON` varchar(255) default NULL,
  `JTEL` varchar(255) default NULL,
  `JMAIL` varchar(255) default NULL,
  `MESSAGE` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `job`
--

INSERT INTO `job` (`ID`, `JNAME`, `PARTMENT`, `WORKTYPE`, `SALARY`, `JEDU`, `PNUM`, `JDATE`, `JPERSON`, `JTEL`, `JMAIL`, `MESSAGE`) VALUES
(1, '578', '6878', '557', '353', '2342', '242', '2017-05-10 12:44:56', '2423', '2423', '4654', '45654');

-- --------------------------------------------------------

--
-- 表的结构 `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `ID` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `SEX` varchar(255) NOT NULL,
  `DATE` datetime NOT NULL,
  `IDCARD` varchar(255) NOT NULL,
  `TEL` varchar(255) NOT NULL,
  `STATUS` varchar(255) NOT NULL,
  `MAIL` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `EDU` varchar(255) NOT NULL,
  `POS` varchar(255) NOT NULL,
  `USER_ID` varchar(255) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK8C768F5576C0BEE2` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `person`
--

INSERT INTO `person` (`ID`, `NAME`, `SEX`, `DATE`, `IDCARD`, `TEL`, `STATUS`, `MAIL`, `ADDRESS`, `EDU`, `POS`, `USER_ID`) VALUES
('4028b8815be8af1c015be8af62300000', '4564', '男', '2017-05-06 00:00:00', '45654', '4645', '4645', '1624949784@qq.com', '45645', '4645', '45645', '4028b8815bc96695015bc9669c6a0000'),
('4028b8815bf1d18b015bf1d1dc150000', '4564', '男', '2017-05-03 00:00:00', '45654', '4645', '4564', '1624949784@qq.com', '456', '6756', '4645', '4028b8815bc969d7015bc969dc100000');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID` varchar(255) NOT NULL,
  `USERNAME` varchar(255) default NULL,
  `USERPASS` varchar(255) default NULL,
  `ROLE` int(11) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`ID`, `USERNAME`, `USERPASS`, `ROLE`) VALUES
('4028b8815bc96695015bc9669c6a0000', '234', '289DFF07669D7A23DE0EF88D2F7129E7', 1),
('4028b8815bc967c8015bc969ac200000', '345', 'D81F9C1BE2E08964BF9F24B15F0E4900', 2),
('4028b8815bc969d7015bc969dc100000', '123', '202CB962AC59075B964B07152D234B70', 1);

--
-- 限制导出的表
--

--
-- 限制表 `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `FK8C768F5576C0BEE2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
