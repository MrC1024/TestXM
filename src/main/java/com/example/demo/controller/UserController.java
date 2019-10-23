package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.Video;
import com.example.demo.service.VideoService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import javafx.application.Application;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource(name="userService")
    private UserService userService;
    @ResponseBody
    @RequestMapping("/login")
    public String loginUser(@RequestParam("account") String account, @RequestParam("password") String password,HttpServletRequest request) {
        User users=userService.getMessage(account);
        Integer user = userService.Login(account, password);
       /* redisTemplate.opsForValue().set("account",account);*/
       ServletContext application = request.getSession().getServletContext();
       application.setAttribute("users",users);
        return JSON.toJSONString(user);
    }
    @ResponseBody
    @RequestMapping("/getMessage")
    public String getMessage(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
        User user=new User();
        user=(User)application.getAttribute("users");
        user=userService.getMessage(user.getAccount());
        return JSON.toJSONString(user);
    }
    @ResponseBody
    @RequestMapping("/updatePass")
    public String updatePass(HttpServletRequest request,User user){
        String password = request.getParameter("password");
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        user.setPassword(password);
        user.setUser_id(user_id);
        Integer userT = userService.xiugai(user);
        return JSON.toJSONString(userT);
    }

    @ResponseBody
    @RequestMapping("/xiugai")
    public String xiugai(HttpServletRequest request,@RequestParam("userName")String userName){
        ServletContext application = request.getSession().getServletContext();
        User user=new User();
        user=(User)application.getAttribute("users");
        int res= userService.xiugai1(user.getUser_id(),userName);
        return JSON.toJSONString(res);
    }
}
