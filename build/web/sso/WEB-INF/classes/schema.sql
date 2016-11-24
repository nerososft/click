use click;
CREATE TABLE IF NOT EXISTS user(
  id bigint not null auto_increment,
  username varchar(64) not null,
  password varchar(64) not null,
  email varchar(64) not null,
  phone varchar(64) not null,
  token varchar(64) not null,
  ctime DATETIME DEFAULT CURRENT_TIMESTAMP,
  active tinyint DEFAULT 0,
  PRIMARY KEY(id),
  INDEX(token),
  INDEX(email)
);