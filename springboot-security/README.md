# Spring security, 融合了JWT

## 值得注意的几个地方

### 对于接口赋予角色的两个方法

1. hasRole()/hasAnyRole()

2. hasAuthority()/hasAnyAuthority()

第一个方法会在角色字符串中插入字符串 *ROLE_*，所以如果数据库中存储的角色名没有以 *ROLE_* 开头的话，假如说某个用户角色是 **admin**，某个接口赋予的角色也是**admin**即hasRole("admin")，你会发现角色名命名都一样但响应却一直是*403 Forbidden*， 所以。

### 几个问题

- [ ] 关闭浏览器让token失效

- [ ] 改密码让token失效

### 疑问: :question:
1. 方法/接口级别的管控是不是每一个接口都有一个唯一的名字/id（写到```@PreAuthorize("hasAuthority('xxx')")```这种），根据用户角色拥有接口名字来进行访问控制


# 参考
1. [Spring Security 无法登陆，报错：There is no PasswordEncoder mapped for the id “null”](https://blog.csdn.net/canon_in_d_major/article/details/79675033)
2. [SpringBoot集成Spring Security，用JWT令牌实现登录和鉴权](https://zhuanlan.zhihu.com/p/142090453)
3. [干货|一个案例学会Spring Security 中使用 JWT](https://zhuanlan.zhihu.com/p/61735642)
