# Springboot Exercises

1. 

关于聚合项目打包报错：

> Non-resolvable parent POM for priv.lyq.springboot-exercises:springboot-security:0.0.1-SNAPSHOT: Could not find artifact priv.lyq:springboot-exercises:pom:1.0 in local ...

先把父pom.xml中的 *\<modules>\</modules>* 注释掉，然后父项目执行```mvn install```就好了