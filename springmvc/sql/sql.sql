CREATE DATABASE test;

USE test;

CREATE TABLE `tbl_department` (
  `departmentId`      INT(11) NOT NULL AUTO_INCREMENT,
  `departmentName`    VARCHAR(32)      DEFAULT NULL,
  `departmentManager` VARCHAR(64)      DEFAULT NULL,
  `projectManager`    VARCHAR(64)      DEFAULT NULL,
  PRIMARY KEY (`departmentId`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE `tbl_employee` (
  `employeeId`   INT(11) NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(32)      DEFAULT NULL,
  `age`          INT(11)          DEFAULT NULL,
  `gender`       VARCHAR(8)       DEFAULT NULL,
  `departmentId` INT(11)          DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  KEY `fk_dep_emp` (`departmentId`),
  CONSTRAINT `fk_dep_emp` FOREIGN KEY (`departmentId`) REFERENCES `tbl_department` (`departmentId`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE `tbl_project` (
  `projectId`      INT(11) NOT NULL,
  `departmentId`   INT(11)     DEFAULT NULL,
  `departmentName` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`projectId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;