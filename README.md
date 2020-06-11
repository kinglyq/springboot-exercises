# Springboot 相关练习

关于聚合项目打包报错：

> Non-resolvable parent POM for priv.lyq.springboot-exercises:springboot-security:0.0.1-SNAPSHOT: Could not find artifact priv.lyq:springboot-exercises:pom:1.0 in local ...

先把父pom.xml中的 *\<modules>\</modules>* 注释掉，然后父项目执行```mvn install```就好了

# modules
每个项目都是相互独立的，目前来讲
1. [springboot-security](https://github.com.cnpmjs.org/kinglyq/springboot-exercises/tree/master/springboot-security "springboot-security")
> 关于spring security的项目，融合了JWT

2. [springboot-multiple-datasource](https://github.com.cnpmjs.org/kinglyq/springboot-exercises/tree/master/springboot-multiple-datasource "springboot-multiple-datasource")
> 多数据源的切换，包括了Mybatis

3. [springboot-simpleweb](https://github.com.cnpmjs.org/kinglyq/springboot-exercises/tree/master/springboot-simpleweb "springboot-simpleweb")
> 简单的web练习