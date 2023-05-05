package com.mirror.bank.web;



import com.mirror.bank.exceptions.AppException;
import com.mirror.bank.exceptions.MoneyNotEnoughException;
import com.mirror.bank.service.AccountService;
import com.mirror.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * 面向接口编程 降低耦合性
 */

/**
 *
 * ssm里面一般都把dao包起名为mapper，把web包起名为controller
 * 再加上service这个包，记住这三个，以后建立框架天天都要在这三个包上整
 * service里面用了try（）{}，括号里面的对象会自动关闭
 * try(){}语法，括号里面的对象会自动关闭，其实就是底层帮你写了关闭的代码
 */


/**
 * 账户小程序 这里就是 C controller 控制层 司令官 调度其它组件
 *
 * AccountServlet一个AccountController
 *
 *
 *
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private AccountService accountService=new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得前端页面的数据
        String toact = req.getParameter("toact");
        String fromact = req.getParameter("fromact");
        double money = Double.parseDouble(req.getParameter("money"));
        //调取Model模块处理业务
        try {
            accountService.transfer(fromact,toact,money);
            //运行到这里证明程序 证明转装操作成功
            //展示处理结果 （调度view做页面展示）
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
        } catch (MoneyNotEnoughException e) {
            //捕获此异常 说明余额不足 调用view展示前端页面
            //展示处理结果 （调度view做页面展示）
            resp.sendRedirect(req.getContextPath()+"/moneyNotEnough.jsp");
        } catch (AppException e) {
            //捕获此异常 说明App异常 程序异常  调用view展示前端此页面
            //展示处理结果 （调度view做页面展示）
            resp.sendRedirect(req.getContextPath()+"/appException.jsp");
        }catch (Exception e){
            //捕获异常 说明转账失败
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }
}
