create table TASK
(
    ID int auto_increment primary key,
    TASK_NAME varchar(64),
    STATUS int,
    CHECK_ID varchar(64) null
);

create table WORK_HISTORY
(
    ID int auto_increment primary key,
    TASK_ID int
);