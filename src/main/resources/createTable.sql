--创建数据库
CREATE DATABASE micor_message;
--使用数据库
use micro_message;
--创建商品表
CREATE TABLE message(
ID int NOT NULL AUTO_INCREMENT COMMENT '指令id',
COMMAND varchar(16) NOT NULL COMMENT '指令',
DESCRIPTION varchar(32) NOT NULL COMMENT '指令描述',
CONTENT varchar(1024) NOT NULL COMMENT '指令内容',
PRIMARY KEY(ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='指令表';

--初始化数据
insert into
  message(COMMAND, DESCRIPTION,CONTENT)
values
('列表','列表','列表'),
('500元秒杀iphon6s','2017-06-22 00:00:00','2017-06-23 00:00:00');
