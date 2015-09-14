drop table if exists product;
create table product
(
  ID character(10) not null,
  NAME character varying(100),
  DESCRIPTION character varying(100),
  PRICE float,
  constraint productPK primary key (ID)
);