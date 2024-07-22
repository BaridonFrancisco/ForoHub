
alter table users add active tinyint not null;

UPDATE users SET active=true WHERE active=null;