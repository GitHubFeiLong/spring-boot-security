# 添加数据,两个用户，密码都是 123，这里使用的是 BCrypt
insert into t_user values (1,'zhangsan', '$2a$10$RcmqzTRlsKJR28zzdtkUj.bqtz9/eAmDUsFbN2RP/mKNAu.tIJa8S', '张三', '12345678901'),(2,'lisi', '$2a$10$RcmqzTRlsKJR28zzdtkUj.bqtz9/eAmDUsFbN2RP/mKNAu.tIJa8S', '李四', '12345678901');

