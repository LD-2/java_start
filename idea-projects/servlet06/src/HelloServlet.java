import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    //通过无参构造方法创建对象
    //执行init方法初始化对象 执行的是爷类GenericServlet的init方法 当然也可以重写
    //执行service方法这里会执行父类HttpServlet类的service方法
    //这里的service方法属于模板方法 你可以选择重写service方法 也可以选择实现模板方法中要重写的具体方法 选择后者一般
    //如果直接重写service方法可能会无法报405错误
    //这里的带http的service是一个模板类方法 重写的话 重写这个模板类方法中的具体实现


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = resp.getWriter();
//        writer.print("<h1>get请求的响应</h1>");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>post请求的响应</h1>");
    }
}
