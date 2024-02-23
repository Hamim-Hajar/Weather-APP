create database weather;
use weather;
create table city(ID int primary key,
                       cityName varchar(30),
                          currentTemperature int,
                           currentHumidity int,
                            currentWindSpeed int);
create table CityHistory(historicalDataId int primary key,
                             cityId int,
                              eventDate date,
                             temperature int,
                            foreign key (cityId) references city(ID)
                            );
	desc CityHistory;
insert into city values(1,'Beni Mellal',30,10,15);
insert into city values(4,'Beni TADLA',30,10,15);

insert into CityHistory values(1,1,'2024-01-01',35);
insert into CityHistory values(4,4,'2023-11-11',22);
select * from CityHistory;

