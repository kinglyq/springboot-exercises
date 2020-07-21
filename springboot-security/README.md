# Spring security, 使用JWT

使用内置h2作为数据库，由于重点在于security，所以表的设计尽可能简单，能拿到数据就行

## 值得注意的几个地方

### 对于接口赋予角色的两个方法

1. hasRole()/hasAnyRole()

2. hasAuthority()/hasAnyAuthority()

第一个方法会在角色字符串中插入字符串 *ROLE_*，如果数据库中存储的角色名没有以 *ROLE_* 开头的话，也就是两者不一致，会一直显示403没有权限，所以采用第二种方式更好一点

### 密码加密

| 加密方式 | 算法                          |
| :------- | :---------------------------- |
| noop     | 明文                          |
| bcrypt   | 单向Hash                      |
| pbkdf2   | 将salted hash进行多次重复计算 |
| scrypt   | 内存依赖型的POW算法           |
| sha256   | 散列                          |

基于从数据库查出来的密码，Spring Security使用格式 "*{上述加密方式}password*"，无论是把这个加密方式前缀存到数据库还是使用 *CONCAT*函数拼接，反正是得有的，否则就是
```java
java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
```

### 几个问题

- [ ] 关闭浏览器让token失效

- [ ] 改密码让token失效

### 疑问: :question:
1. 方法/接口级别的管控是不是每一个接口都有一个唯一的名字/id（写到```@PreAuthorize("hasAuthority('xxx')")```这种），根据用户角色拥有接口名字来进行访问控制

# 参考
1. [Spring Security 无法登陆，报错：There is no PasswordEncoder mapped for the id “null”](https://blog.csdn.net/canon_in_d_major/article/details/79675033)
2. [SpringBoot集成Spring Security，用JWT令牌实现登录和鉴权](https://zhuanlan.zhihu.com/p/142090453)
3. [干货|一个案例学会Spring Security 中使用 JWT](https://zhuanlan.zhihu.com/p/61735642)
