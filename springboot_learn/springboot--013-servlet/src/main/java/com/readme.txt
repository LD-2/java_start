如何在springboot中使用servlet

创建 Servlet

ServletRegistrationBean 用来做在 servlet 3.0+容器中注册 servlet 的功能，但更具有SpringBean 友好性。

ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(),"/myservlet");

//    注册servlet对象

第一种
//public ServletRegistrationBean(T servlet, String... urlMappings)
//有两个参数 一个是servlet对象  一个是url地址

第二种
用无参构造 调用方法
ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>();
bean.setServlet(new MyServlet());
bean.addUrlMappings("/myservlet");



