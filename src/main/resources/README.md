# Readme
使用spring boot 集成spring security 简单版，包含数据表结构和数据。
# 项目结构

## 文件夹
### com.cfl.springsecurity.config
MvcConfig： springMVC配置

WebSecurityConfig： spring security 配置

### com.cfl.springsecurity.controller
LoginController: 资源

PageController： 访问登录页

### com.cfl.springsecurity.dao
UserDao： 提供从数据库中查询用户和权限的方法

### com.cfl.springsecurity.model
PermissionDto ：权限实体类

UserDto ： 用户实体类

### com.cfl.springsecurity.service
SpringDataUserDetailService ： implements UserDetailsService 重写 loadUserByUsername 方法 

### db.migration
存放数据库脚本