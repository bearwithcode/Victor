DROP TABLE IF EXISTS `Airport`;
DROP TABLE IF EXISTS `Route`;
DROP TABLE IF EXISTS `Fleet`;
DROP TABLE IF EXISTS `Airplane`;
DROP TABLE IF EXISTS `Customer`;
DROP TABLE IF EXISTS `Schedule`;
DROP TABLE IF EXISTS `Login`;
DROP TABLE IF EXISTS `AgentProfiles`;
DROP TABLE IF EXISTS `ServiceInventory`;
DROP TABLE IF EXISTS `Seat`;
DROP TABLE IF EXISTS `Ticket`;

CREATE TABLE `Airport` (
	`airportID` INTEGER(4)		NOT NULL,
	`name`		VARCHAR(64)		NOT NULL,
	`city`		VARCHAR(32)		NOT NULL,
	`country`	VARCHAR(32)		NOT NULL,
	`IATA` 		VARCHAR(3)		NOT NULL,
	`latitude`	DOUBLE(5,2)		NOT NULL,
	`longitude`	DOUBLE(5,2)		NOT NULL,
	`altitude`	INTEGER(4)		NOT NULL,
	`DST`		VARCHAR(1)		NOT NULL,
	`timeZone`	VARCHAR(32)		NOT NULL,
	CONSTRAINT Airport_PK PRIMARY KEY(`IATA`)
);

CREATE TABLE `Route` (
	`routeID`				INTEGER(4)	NOT NULL	AUTO_INCREMENT,
	`sourceAirport`			VARCHAR(3)	NOT NULL,
	`destinationAirport`	VARCHAR(3)	NOT NULL,
	`codeShare`				VARCHAR(1),
	`stops`					INTEGER(1),
	`InternationalFlight`	BOOLEAN,
	CONSTRAINT Route_PK PRIMARY KEY(`routeID`),
	
	CONSTRAINT Route0_FK
	FOREIGN KEY (`sourceAirport`) 
	REFERENCES `Airport`(`IATA`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION,
	
	CONSTRAINT Route1_FK
	FOREIGN KEY (`destinationAirport`) 
	REFERENCES `Airport`(`IATA`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION
);

CREATE TABLE `Fleet` (
	`fleetID`		INTEGER(4)		NOT NULL	AUTO_INCREMENT,
        `AirportITIA`             VARCHAR(3)              NOT NULL,
	`inService`		INTEGER(2)		NOT NULL,
	CONSTRAINT Fleet_PK PRIMARY KEY(`fleetID`),

        CONSTRAINT Fleet0_FK
	FOREIGN KEY (`AirportITIA`) 
	REFERENCES `Airport`(`IATA`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION
);

CREATE TABLE `Airplane`
(
	`PlaneID`	INTEGER(4)		NOT NULL 	AUTO_INCREMENT,
	`onefleet`	INTEGER(4)		NOT NULL,
	`firstClass`	INTEGER(2)		NOT NULL,
	`businessClass`	INTEGER(2)		NOT NULL,
	`premiumClass`	INTEGER(2)		NOT NULL,
	`economyClass`	INTEGER(3)		NOT NULL,
	`total`			INTEGER(3)		NOT NULL,

	CONSTRAINT Plane_PK PRIMARY KEY(`PlaneID`),

	CONSTRAINT Plane0_FK
	FOREIGN KEY (`onefleet`) 
	REFERENCES `Fleet`(`fleetID`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION
);

CREATE TABLE `Seat`
(
	`seat_id`		INTEGER(4)		NOT NULL	AUTO_INCREMENT,
	`seat_class`	VARCHAR(16) 	NOT NULL,
	`seat_number`	VARCHAR(3)		NOT NULL,
	`occupied`	BOOLEAN			NOT NULL,
	`PlaneID` 	INTEGER(4)		NOT NULL,
	
	CONSTRAINT Seat_PK PRIMARY KEY(`seat_id`),
	
	CONSTRAINT Seat_FK
	FOREIGN KEY (`PlaneID`) 
	REFERENCES `Airplane`(`PlaneID`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION
);

CREATE TABLE `Schedule` 
(
	`scheduleID`	INTEGER(4)	NOT NULL	AUTO_INCREMENT,
	`flightID`		VARCHAR(8)	NOT NULL,
	`planeID`		INTEGER(4)	NOT NULL,
	`routeID`		INTEGER(4)	NOT NULL,
	`departDate`		DATE		NOT NULL,
	`arriveDate`		DATE		NOT NULL,
	`departTime`	TIME 		NOT NULL,
	`arriveTime`	TIME		NOT NULL,
	
	CONSTRAINT Schedule_PK PRIMARY KEY(`scheduleID`),
	CONSTRAINT Flight_ID UNIQUE (`flightID`),
	
	CONSTRAINT Schedule_FK
	FOREIGN KEY (`planeID`) 
	REFERENCES `Airplane`(`planeID`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION,
	
	CONSTRAINT Schedule2_FK
	FOREIGN KEY (`routeID`) 
	REFERENCES `Route`(`routeID`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION
);

CREATE TABLE `Login`
(
	`username`	VARCHAR(32)		NOT NULL,
	`password`	VARCHAR(32)		NOT NULL,
	`role`		VARCHAR(16)		NOT NULL,
	CONSTRAINT Login_PK PRIMARY KEY(`username`)
);

CREATE TABLE `AgentProfiles`
(
	`agent_id`		INTEGER(3)		NOT NULL	AUTO_INCREMENT,
	`travel_agent`	VARCHAR(32)		NOT NULL,
	`phone`			VARCHAR(16)		NOT NULL,
	`email`			VARCHAR(64)		NOT NULL,
	CONSTRAINT Agent_PK PRIMARY KEY(`agent_id`),
	CONSTRAINT unq_agent UNIQUE (`travel_agent`, `phone`, `email`)
);

CREATE TABLE `Customer`
(
	`customer_id` 			INTEGER(4) 		NOT NULL	AUTO_INCREMENT,
	`title`					VARCHAR(16) 	NOT NULL,
	`first_name`			VARCHAR(32)		NOT NULL,
	`last_name`				VARCHAR(32)		NOT NULL,
	`gender`				VARCHAR(8)		NOT NULL,
	`DOB`					DATE			NOT NULL,
	`phone`					VARCHAR(16)		NOT NULL,
	`email`					VARCHAR(64)		NOT NULL,
	`street_address`		VARCHAR(64)		NOT NULL,
	`city`					VARCHAR(32)		NOT NULL,
        `state`					VARCHAR(32)		NOT NULL,
	`country`				VARCHAR(32)		NOT NULL,
	`credit_card_type` 		VARCHAR(32)		NOT NULL,
	`credit_card_num`		VARCHAR(32)		NOT NULL,
	`frequent_flier_pts`	INTEGER(6)		NOT NULL,
	`passport_holder`		BOOLEAN			NOT NULL,
	`flight_status`			VARCHAR(8),
	`travel_agent`			VARCHAR(32),
	`username` 				VARCHAR(32)		NOT NULL,
	CONSTRAINT Cust_PK PRIMARY KEY(`customer_id`),
	CONSTRAINT usr UNIQUE (`username`),
	
	CONSTRAINT Cust_FK
	FOREIGN KEY (`username`) 
	REFERENCES `Login`(`username`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION,
	
	CONSTRAINT Cust_FK2
	FOREIGN KEY (`travel_agent`) 
	REFERENCES `AgentProfiles`(`travel_agent`)
);

CREATE TABLE `ServiceInventory`
(
	`service_id`	INTEGER(2)	NOT NULL	AUTO_INCREMENT,
	`item`			VARCHAR(32)	NOT NULL,
	`cost`			INTEGER(3)	NOT NULL,
	`avaliablity`	VARCHAR(32)	NOT NULL,
	CONSTRAINT Service_PK PRIMARY KEY(`service_id`)
);

CREATE TABLE `Ticket`
(
	`ticketID`				INTEGER(4)	NOT NULL AUTO_INCREMENT,	
	`customer_id` 			INTEGER(4)	NOT NULL,
	`scheduleID`				INTEGER(4)	NOT NULL,
	`seat_id`			INTEGER(4)	NOT NULL,	
	`payed`					BOOLEAN		NOT NULL,
	
	CONSTRAINT Ticket_PK PRIMARY KEY(`ticketID`),
	
	CONSTRAINT Ticket0_FK
	FOREIGN KEY (`customer_id`) 
	REFERENCES `Customer`(`customer_id`)
        ON DELETE CASCADE
	ON UPDATE NO ACTION,
	
	CONSTRAINT Ticket1_FK
	FOREIGN KEY (`scheduleID`) 
	REFERENCES `Schedule`(`scheduleID`)
	ON DELETE CASCADE
	ON UPDATE NO ACTION,
			
	CONSTRAINT Ticket6_FK
	FOREIGN KEY (`seat_id`)
	REFERENCES `Seat`(`seat_id`)
        ON DELETE CASCADE
	ON UPDATE NO ACTION
);


INSERT INTO `login` VALUES ('ironman', 'tonystark', 'admin');



