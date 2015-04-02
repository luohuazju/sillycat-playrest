
create table PERSON (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    NAME varchar(100) not null,
    PRIMARY KEY (ID)
);

create table TASK (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    NAME varchar(100) not null,
    DESN varchar(255),
    START_DATE datetime,
    END_DATE datetime,
    PRIMARY KEY (ID)
);
