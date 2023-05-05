开发中可能会有这样的情景。需要在容器启动后执行一些内容。比如读取配置文件，数
据库连接之类的。SpringBoot 给我们提供了两个接口来帮助我们实现这种需求。这两个接口
分别为 CommandLineRunner 和 ApplicationRunner。他们的执行时机为容器启动完成的时候。
这两个接口中有一个 run 方法，我们只需要实现这个方法即可。这两个接口的不同之处
在于： ApplicationRunner 中 run 方 法 的 参 数 为 ApplicationArguments ， 而
CommandLineRunner
接口中 run 方法的参数为 String 数组


也就是说实现了整个接口
当这个对象执行完容器创建完对象后立即执行这个方法


