create database fblog default charset = utf8;
use fblog;


create table user(
id int(11) primary key auto_increment not null,
username varchar(30) not null,
password varchar(30) not null,
nickname varchar(50) not null,
last_login datetime default null,
post_id int(11) not null,
birthday date not null,
level varchar(20) not null
);


 CREATE TABLE post_ (
  `id` int(11) primary key auto_increment not null,
  `title` varchar(200) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_time` varchar(50) NOT NULL,
  `root_id` int(11) NOT NULL,
foreign key (user_id) references user(id)
);