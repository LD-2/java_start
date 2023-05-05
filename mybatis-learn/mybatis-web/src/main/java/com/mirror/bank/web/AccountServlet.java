package com.mirror.bank.web;

import com.mirror.bank.exceptions.ActNullException;
import com.mirror.bank.exceptions.MoneyNotEnoughException;
import com.mirror.bank.exceptions.TransferException;
import com.mirror.bank.service.AccountService;
import com.mirror.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountServiceImpl=new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String toact = req.getParameter("toact");
        String fromact = req.getParameter("fromact");
        //如果不输入钱
        String money1 = req.getParameter("money");
        Double money=null;
        if(!money1.equals("")){
            money=Double.parseDouble(money1);
        }
        try {
            accountServiceImpl.transfer(toact,fromact,money);
            //可以执行到这里证明没有异常
            //调用界面展示转账成功
//            resp.sendRedirect(req.getContextPath()+"/页面路径");
            //这里就不用重定向了 用ajx局部跟新页面展示 效果
            out.write("<h3>转账成功.</h3>");
        } catch (MoneyNotEnoughException e) {
            //程序执行到这里 表明转出账户余额不足
            out.write("<h3>余额不足.</h3>");
        } catch (TransferException e) {
            //程序执行到这里，表明转账出现未知异常
            out.write("<h3>转账失败出现未知异常.</h3>");
        }catch (ActNullException e){
            out.write("<h3>用户不存在.</h3>");
        }catch (Exception e){
            //捕获其它异常
            out.write("<h3>网络原因失败</h3>");
        }
    }
}
