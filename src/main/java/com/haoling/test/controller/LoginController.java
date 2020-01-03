package com.haoling.test.controller;

import com.haoling.test.pojo.User;
import com.haoling.test.service.UserService;
import com.haoling.test.util.Msg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(){
        System.out.print("正在登录");
        return "login";
    }


    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(User user){
        Msg msg = new Msg();
        if (user != null) {
            String userName = user.getUserName();
            String passWord = user.getPassWord();
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord);
            try {
                subject.login(token);
                msg.setCode(200);
                msg.setMsg("登录成功");
            } catch (Exception e) {
                e.printStackTrace();
                msg.setCode(100);
                msg.setMsg("登录失败");
            }
        }
        return msg;
    }
}
