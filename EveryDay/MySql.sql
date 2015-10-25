CREATE TABLE `Login`
(
	`username`	VARCHAR(32)		NOT NULL,
	`password`	VARCHAR(32)		NOT NULL,
	`role`		VARCHAR(16)		NOT NULL,
	CONSTRAINT Login_PK PRIMARY KEY(`username`)
);

CREATE TABLE `Diary`
(
        `diary_id`                      INTEGER(4)		NOT NULL 	AUTO_INCREMENT,
	`diary_date` 			DATE		NOT NULL,
	`info`                          MEDIUMTEXT             NOT NULL,
        `picy`                          MEDIUMTEXT              NOT NULL,
	`username` 				VARCHAR(32)		NOT NULL,
	CONSTRAINT Dia_PK PRIMARY KEY(`diary_id`),
	
	CONSTRAINT Dia_FK
	FOREIGN KEY (`username`) 
	REFERENCES `Login`(`username`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION
);

