DROP TABLE IF EXISTS `sys_user1`;
CREATE TABLE `sys_user1` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user2`;
CREATE TABLE `sys_user2` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user3`;
CREATE TABLE `sys_user3` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user4`;
CREATE TABLE `sys_user4` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user5`;
CREATE TABLE `sys_user5` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user6`;
CREATE TABLE `sys_user6` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user7`;
CREATE TABLE `sys_user7` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user8`;
CREATE TABLE `sys_user8` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user9`;
CREATE TABLE `sys_user9` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user10`;
CREATE TABLE `sys_user10` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user11`;
CREATE TABLE `sys_user11` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user12`;
CREATE TABLE `sys_user12` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user13`;
CREATE TABLE `sys_user13` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user14`;
CREATE TABLE `sys_user14` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user15`;
CREATE TABLE `sys_user15` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user16`;
CREATE TABLE `sys_user16` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(20) DEFAULT NULL COMMENT '盐',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` VARCHAR(100) DEFAULT NULL COMMENT '手机号',
  `status` TINYINT DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';
