package cn.linguo.action;

import cn.linguo.entity.Account;
import cn.linguo.service.AccountService2020;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 作者：高俊欣
 * 日期：2020/1/6
 * 微信：15000952623
 **/

@Controller
@RequestMapping("/account")
public class AccountAction extends BaseAction {


    @Resource
    private AccountService2020 accountService2020;



    //登陆，验证用户名和密码
    @RequestMapping("/login.do")
    public String login(Account account, Model model, HttpSession session, ServletRequest request){


        System.out.println("AccountAction 用户登陆，验证用户密码！"+account);

        Account user = accountService2020.login(account);

        if (user!=null){

            session.setAttribute("user",user);

        }else {

           request.setAttribute("errMsg","用户或密码错误！");

           return "forward:/login.jsp";
        }


        return "forward:/WEB-INF/jsp/main.jsp";
    }












}
