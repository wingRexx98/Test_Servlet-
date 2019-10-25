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