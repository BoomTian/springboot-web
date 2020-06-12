package com.tbw.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author hasee
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){

        if (! StringUtils.isEmpty(username) && password.equals("123456")){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";

        }
        model.addAttribute("msg","用户名或密码错误");
        return "index";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
