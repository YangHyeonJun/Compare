create table mainboard 
(
	mbNumber int primary key auto_increment,
    mbName varchar(50),
    mbChipset varchar(20),
    mbDDR varchar(10),
    mbNVMe boolean,
    mbSize varchar(10)
);
create table cpu
(
    cpuNumber int primary key auto_increment,
    cpuName varchar(50),
    cpuChipset varchar(10)
);
create table ram
(
    ramNumber int primary key auto_increment,
    ramName varchar(50),
    ramDDR varchar(16)
);
create table ssd
(
    ssdNumber int primary key auto_increment,
    ssdName varchar(50),
    ssdNVMe boolean
);
create table cases
(
    casesNumber int primary key auto_increment,
    casesName varchar(60),
    casesSize varchar(60),
    casesWidth int
);
create table vga
(
    vgaNumber int primary key auto_increment,
    vgaName varchar(60),
    vgaWidth int
);

drop table mainboard; 
drop table cpu; 
drop table ram; 
drop table ssd;
drop table cases;
drop table vga;