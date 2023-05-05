import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/test/cookie")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name="name";
        String value="mirror";

        //创建cookie对象 只有有参构造方法
        Cookie cookie=new Cookie(name,value);

        //设置cookie在一小时后失效 (保存在硬盘文件中)
//        cookie.setMaxAge(60*60);

        //设置cookie age为0 是删除同名cookie
//        cookie.setMaxAge(0);

        //负数相当于不设置时长 cookie存储在运行内存中
//        cookie.setMaxAge(-1);


        cookie.setMaxAge(-1);

        //在不设置path情况下 默认的cookie提交path是什么
        cookie.setPath(req.getContextPath());


        //将cookie响应到浏览器
        resp.addCookie(cookie);

    }
}
