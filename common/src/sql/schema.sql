

create table if not exists user(
 id bigint primary key auto_increment,
 username varchar(32) not null,
 email varchar(64) not null,
 token VARCHAR(64) not null,
 phone VARCHAR (16),
 ctime DATETIME DEFAULT  CURRENT_TIMESTAMP,
 isactive tinyint DEFAULT 0,
 password VARCHAR (32) not null,
 index(email)
)Engine = InnoDB;




create table if not exists news(
  id bigint primary key auto_increment not null,
  title varchar(64) not null,
  content text not null,
  isdel tinyint default 0,
  readcount bigint DEFAULT 0,
  ctime DATETIME DEFAULT CURRENT_TIMESTAMP
)Engine=InnoDB;


create table if not exists  header(
  title varchar(64) not null primary key,
  label VARCHAR(64)
)Engine=InnoDB;

create table if not exists footer(
  label VARCHAR(128) PRIMARY KEY
)Engine=InnoDB;

create table if not exists  link(
  id INT(32) NOT NULL PRIMARY  KEY auto_increment,
  name VARCHAR (64) not NULL,
  href_url VARCHAR(128) NOT NULL
)Engine=InnoDB;

create table if not exists logo(
  id INT(32) NOT  NULL PRIMARY KEY auto_increment,
  descrip VARCHAR(64),
  href_url VARCHAR(128),
  img_url VARCHAR(128) NOT NULL
)Engine=InnoDB;

create table if not exists banner(
  id INT(32) not NULL PRIMARY  KEY auto_increment,
  descrip VARCHAR(64),
  href_url VARCHAR(128),
  img_url VARCHAR(128) NOT NULL
)Engine=InnoDB;

