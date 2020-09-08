DROP DATABASE IF EXISTS Casino_Millenaire;
CREATE DATABASE Casino_Millenaire;
use Casino_Millenaire;
CREATE TABLE Users
(
    idU int NOT NULL auto_increment,
    username varchar(255) NOT NULL,
    forename varchar(255),
    surname varchar(255),
    password varchar(255) NOT NULL,
    email varchar(255),
    balance double NOT NULL,
    age int,
    role varchar(255) NOT NULL,
    PRIMARY KEY(idU)
);
CREATE TABLE Game
(
    idG int NOT NULL auto_increment,
    gameName varchar(255) NOT NULL,
    PRIMARY KEY(idG)
);

 

create Table Statistics 
(
    idS int Not NULL auto_increment,
    usersID int NOT NULL,
    gameID int NOT NULL,
    bet double NOT NULL,
    results varchar(255) NOT NULL,
    changes double NOT NULL,
    PRIMARY KEY (idS),
    FOREIGN KEY (usersID) REFERENCES Users(idU),
    FOREIGN KEY (gameID) REFERENCES Game(idG)
);

 

INSERT INTO Game (`gameName`) values ('Slots');
INSERT INTO Game (`gameName`) values ('Yatzi');
INSERT INTO Game (`gameName`) values ('Roulette');
INSERT INTO Game (`gameName`) values ('VideoPoker');
INSERT INTO Game (`gameName`) values ('Blackjack');

 


INSERT INTO users (`username`,`password`,`role`, `balance`) values ('administrator', '1234', 'admin', '1000000');

 

/*INSERT INTO users (`username`,`forename`,`surname`,`password`,`email`,`balance`,`age`, `role`) values ('moin','forename','surname','password','email','50','19','player');

 

Select g.gameName, s.bet, s.results, s.changes from statistics s, game g, users u where idG = gameID AND usersID = idU AND username = 'administrator'; */