create table goods (goods_id bigint not null auto_increment, created_date datetime, modified_date datetime,
goods_price integer, goods_publisher varchar(50), goods_status varchar(50), goods_title varchar(100),
goods_writer varchar(50), GOODS_ISBN VARCHAR(50), primary key (goods_id)) engine=InnoDB;

create table image_file (image_id bigint not null auto_increment, created_date datetime,
modified_date datetime, file_name varchar(50), file_type varchar(40), reg_id varchar(20),
goods_id bigint not null, primary key (image_id),
FOREIGN KEY (goods_id) REFERENCES goods (goods_id)) engine=InnoDB;

insert into goods (goods_title, goods_writer, goods_publisher, goods_price, goods_status, GOODS_ISBN,
created_date, modified_date) values ('무작정 따라가기 홍콩 마카오','김수정, 김승남','인포북스',30000, 'bestseller',
'121212', now(), now());

insert into goods (goods_title, goods_writer, goods_publisher, goods_price, goods_status, GOODS_ISBN,
created_date, modified_date) values ('모두의 파이썬','이승찬','길벗',12000, 'bestseller',
'9791186978894', now(), now());

insert into goods (goods_title, goods_writer, goods_publisher, goods_price, goods_status, GOODS_ISBN,
created_date, modified_date) values ('리액트를 다루는 기술','김민준','길벗',32000, 'bestseller',
'9791160505238', now(), now());

insert into image_file (GOODS_ID,file_name,REG_ID,file_type,created_date, modified_date) values
((SELECT GOODS_ID from goods WHERE GOODS_ISBN='121212'), '무작정 따라가기 홍콩 마카오.jpg',
'admin','main_image', now(), now());

insert into image_file (GOODS_ID,file_name,REG_ID,file_type,created_date, modified_date) values
((SELECT GOODS_ID from goods WHERE GOODS_ISBN='9791186978894'), 'image2.jpg',
'admin','main_image', now(), now());

insert into image_file (GOODS_ID,file_name,REG_ID,file_type,created_date, modified_date) values
((SELECT GOODS_ID from goods WHERE GOODS_ISBN='9791160505238'), 'main_react.jpg',
'admin','main_image', now(), now());
