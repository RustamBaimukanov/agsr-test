create table sensors
(
    id serial primary key ,
    name varchar(30) not null check (length(trim(name)) >= 3),
    model varchar(15) not null,
    range_from integer not null check (range_from > 0),
    range_to integer not null check (range_to > range_from),
    type varchar not null check(type in ('PRESSURE', 'VOLTAGE', 'TEMPERATURE', 'HUMIDITY')),
    unit varchar check (unit in ('bar', 'voltage', '°C', '%')),
    location varchar(40),
    description varchar(200)
);