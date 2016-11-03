

create table user(
 id bigint primary key auto_increment,
 username varchar(32) not null,
 email varchar(64) not null,
 token VARCHAR(64) not null,
 phone VARCHAR (16),
 ctime DATETIME DEFAULT  CURRENT_TIMESTAMP,
 isactive tinyint DEFAULT 0,
 password VARCHAR (32) not null,
 index email
)Engine = InnDB;




create table news(
  id bigint primary key auto_increment not null,
  title varchar(64) not null,
  content text not null,
  isdel tinyint default 0,
  readcount bigint DEFAULT 0,
  ctime DATETIME DEFAULT CURRENT_TIMESTAMP
)Engine=InnoDB;