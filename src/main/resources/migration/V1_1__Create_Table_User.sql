create table User
(
    Id                 int auto_increment
        primary key,
    Name               varchar(200)         not null,
    Username           varchar(60)          not null,
    Password           varchar(200)         not null,
    Email              varchar(100)         not null,
    ErrorLoginAttempts int        default 0 not null,
    Blocked            tinyint(1) default 0 not null,
    Active             tinyint(1) default 1 not null,
    CreatedUserId      int                  null,
    CreatedDate        datetime             not null,
    ModifiedUserId     int                  null,
    ModifiedDate       datetime             null,
    constraint Email
        unique (Email),
    constraint Username
        unique (Username)
);