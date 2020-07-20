# Springboot 相关练习

关于聚合项目打包报错：

> Non-resolvable parent POM for priv.lyq.springboot-exercises:springboot-security:0.0.1-SNAPSHOT: Could not find artifact priv.lyq:springboot-exercises:pom:1.0 in local ...

先把父pom.xml中的 *\<modules>\</modules>* 注释掉，然后父项目执行```mvn install```就好了

# modules
每个项目都是相互独立的，目前来讲

## [springboot-security](https://github.com.cnpmjs.org/kinglyq/springboot-exercises/tree/master/springboot-security "springboot-security")
> 关于spring security的项目，使用JWT

## [springboot-datasource](https://github.com.cnpmjs.org/kinglyq/springboot-exercises/tree/master/springboot-multiple-datasource "springboot-multiple-datasource")
> 多数据源的切换，包括了Mybatis

## [springboot-web](https://github.com.cnpmjs.org/kinglyq/springboot-exercises/tree/master/springboot-simpleweb "springboot-simpleweb")
> 简单的web练习，可能以后内容会越来越多，web的范围太广了

## springboot-common
> 基础通用代码，例如接口返回什么的