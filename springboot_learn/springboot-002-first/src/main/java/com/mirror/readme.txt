springboot的特性
创建独立的Spring应用程序
直接嵌入Tomcat、Jetty或Undertow(不需要部署WAR文件)
提供自定义的` starter `依赖来简化你的构建配置
尽可能自动配置Spring和第三方库
提供生产环境可用的特性，如度量、健康检查和外部化配置
绝对没有代码生成，也不需要XML配置

mvn那几个没什么用 是自身没有maven时下载的
static是存放静态资源 html css的
templates存放模板的
application.properties是springboot的配置文件

看pom文件可以知道
<!--    springboot项目的父项目--> 里面有依赖的版本号 和 依赖
spring-boot-starter-web这个依赖 导入了其它的依赖 比如spring 内置tomcat依赖

第二种建立用国内的镜像  https://start.springboot.io
第三种普通maven项目 只不过导入了依赖 手动配置了文件夹





