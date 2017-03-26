
create table if not exists apps(
 id bigint primary key auto_increment,
 appkey varchar(32) not null,
 appsecretkey varchar(64) not null,
 token VARCHAR(64) not null,
 appname VARCHAR (32),
 appavatar VARCHAR(64),
 isactive tinyint DEFAULT 0,
 expir VARCHAR (32) not null,
 ctime timestamp DEFAULT  CURRENT_TIMESTAMP
)Engine = InnoDB;
