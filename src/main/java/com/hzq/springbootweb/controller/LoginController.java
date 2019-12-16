package com.hzq.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
/**
 * @author zhiqiang.hu01@hand-china.com
 * @version 1.0
 * @date 2019-12-06 16:17
 **/
@Controller
@RequestMapping("/user")
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        String pwd="123456";
        if (!StringUtils.isEmpty(username)&&pwd.equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名密码错误");
            return "index";
        }
    }
}
