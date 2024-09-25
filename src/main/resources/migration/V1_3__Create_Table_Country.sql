create table Country
(
    Id                 int auto_increment
        primary key,
    Code               varchar(3)           not null,
    Name               varchar(200)         not null
);