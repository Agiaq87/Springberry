create table note(
  id bigint not null primary key,
  name varchar(120) not null,
  date timestamp,
  body varchar(255) not null
);