create table TASK
(
    ID int auto_increment primary key,
    NAME varchar(64),
    STATUS int,
    WORK_ID varchar(64) null,
    CREATE_TIME DATETIME(3) default (utc_timestamp(3)) not null,
    UPDATE_TIME DATETIME(3) default (utc_timestamp(3)) not null
);

create table TASK_HISTORY
(
    ID int auto_increment primary key,
    TASK_ID int,
    WORK_ID varchar(64) null,
    STATUS int,
    CREATE_TIME DATETIME(3) default (utc_timestamp(3)) not null
);