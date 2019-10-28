CREATE DATABASE ServletTest
USE ServletTest
CREATE TABLE UserInfo(
	userId		INT PRIMARY KEY AUTO_INCREMENT,
    userName	VARCHAR(50)		NOT NULL,
    userEmail	VARCHAR(50) 	NOT NULL,
    userPhone	CHAR(9)			NOT NULL,
    userAddress	VARCHAR(100)	NOT NULL,
    userDoB		DATE			NOT NULL
)

CREATE TABLE AdminLogIn(
	adminName		VARCHAR(50)		NOT NULL,
    loginName		VARCHAR(50) 	NOT NULL UNIQUE,
    adminPassword	VARCHAR(50)		NOT NULL UNIQUE,
    PRIMARY KEY PK_Ad (loginName, adminPassword)
)

select * from AdminLogIn

INSERT INTO AdminLogIn values ('Tom', 'user1','123456')
select * from  UserInfo where userId = 3