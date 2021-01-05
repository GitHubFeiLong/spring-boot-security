# 新建用户和角色关系，用户1有角色1，用户2有角色2
insert into `t_user_role`(`user_id`,`role_id`,`create_time`,`creator`) values
('1','1',NULL,NULL),('2','2', NULL, NULL);