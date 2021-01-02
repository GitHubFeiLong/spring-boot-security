# 创建t_user表
CREATE TABLE `t_user` (
                          `id` bigint(20) NOT NULL COMMENT '用户id',
                          `username` varchar(64) NOT NULL,
                          `password` varchar(64) NOT NULL,
                          `fullname` varchar(255) NOT NULL COMMENT '用户姓名',
                          `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

# 添加数据
insert into t_user values (1,'zhangsan', '$2a$10$RcmqzTRlsKJR28zzdtkUj.bqtz9/eAmDUsFbN2RP/mKNAu.tIJa8S', '张三', '12345678901'),(2,'lisi', '$2a$10$BkTJwD02D55N.6gpg/.Mg.osYC1om.kTmCJNt8HotxXp6nXAL0ZRK', '李四', '12345678901');

