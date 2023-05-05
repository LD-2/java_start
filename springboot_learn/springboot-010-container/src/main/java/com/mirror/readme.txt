Spring Boot 中使用 ApplicationContext
在 main 方法中 SpringApplication.run()方法获取返回的 Spring 容器对象，再获取业务 bean
进行调用.

通过看SpringApplication.run()方法
可以知道其返回值  ApplicationContext    ConfigurableApplicationContext
是spring容器对象 因此可以 获取 容器中的对象

