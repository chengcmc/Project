/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.25 : Database - crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `crm`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `limit_id` int(10) DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `realname` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `state` int(10) DEFAULT NULL COMMENT '状态分为：1为正常/2为禁用',
  PRIMARY KEY (`id`),
  KEY `userID` (`id`),
  KEY `limit_user_fk` (`limit_id`),
  CONSTRAINT `limit_user_fk` FOREIGN KEY (`limit_id`) REFERENCES `user_limit` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `customer` */

insert  into `customer`(`limit_id`,`id`,`username`,`realname`,`email`,`phone`,`address`,`state`) values (2,2,'段誉','林志颖','22222222@163.com','22222222222','台湾省台北市',1),(2,4,'慕容复','修庆','44444444@163.com','44444444444','河南',2),(3,5,'语嫣','刘亦菲','55555555@163.com','333333','河南',2),(3,6,'阿紫','陈好','66666666@163.com','5555555','山东省青岛市',1),(4,8,'钟万仇','魏忠万','88888888@163.com','88888888888','上海',1),(4,9,'钟灵','杨蕊','99999999@163.com','99999999999','乌鲁木齐市',1),(4,10,'木婉清','蒋欣','00000000@163.com','10101010101','北京',1),(2,14,'xwj','肖文杰','2516320504@qq.com','17352625661','湖南郴州',3),(3,15,'cmc','陈明诚','16166@qq.com','17352625667','广东广州',2),(2,17,'阿松大','阿松大','16166@qq.com','asdadasd','阿迪斯',1),(4,18,NULL,NULL,NULL,NULL,NULL,NULL),(3,19,'xxx','sdsdf','16166@qq.com','11111111111','dwqdwq',2),(4,20,'小行星','ssad','dcssdc@qq','sadas','sda',2),(3,22,'www','fsffssss','16166@qq.com','afa','asdas',1),(1,23,'dddd','dddd','ddd@qq.com','ddd','dddd',4),(3,24,'admin','sss','sss@qq.com','sss','ss',1),(3,26,'李晓杰','李大锤','123456789@qq.com','00000000000','广州',2);

/*Table structure for table `limitinfo` */

DROP TABLE IF EXISTS `limitinfo`;

CREATE TABLE `limitinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `limitname` varchar(100) DEFAULT NULL COMMENT '权限名字',
  `info` varchar(100) DEFAULT NULL COMMENT '权限说明',
  `limitstatus` int(10) DEFAULT NULL COMMENT '权限状态码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `limitinfo` */

insert  into `limitinfo`(`id`,`limitname`,`info`,`limitstatus`) values (1,'管理员','普通用户管理、客户管理',0),(2,'业务员','对自己负责进行增删改查操作',1),(4,'客户经理','对所有业务员负责的客户进行增删改查操作',2);

/*Table structure for table `user_limit` */

DROP TABLE IF EXISTS `user_limit`;

CREATE TABLE `user_limit` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `limitNum` int(10) NOT NULL COMMENT '权限状态：0为管理员、1为用户',
  `tel` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ID` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user_limit` */

insert  into `user_limit`(`id`,`name`,`password`,`limitNum`,`tel`) values (1,'admin','123',0,'98765785778'),(2,'wyz','222',1,'98765432144'),(3,'tstn','123',1,'32165498701'),(4,'lqs','444',1,'74185296301'),(5,'李经理','123',2,'16689523248'),(6,'tst5','545',0,'545'),(7,'1','1',0,'1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
