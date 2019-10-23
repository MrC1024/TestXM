package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.User;
import com.example.demo.pojo.User_sign;
import com.example.demo.service.User_signService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/sign")
public class User_signController {
    @Autowired
    private User_signService user_signService;
    @ResponseBody
    @RequestMapping("/selsf")
    public String selsf(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
        User user=(User)application.getAttribute("users");
        User_sign user_sign=user_signService.sel(user.getUser_id());
        application.setAttribute("user_sign",user_sign);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");//可以方便地修改日期格式
        int res=user_signService.selsf(user.getUser_id());
        if(res>0){
            if(user_signService.selyf(Integer.parseInt(sdf.format(now)))>0){
                res=0;
            }else{
                res=1;
            }
        }else{
            res=0;
        }
        return JSON.toJSONString(res);
    }
    @ResponseBody
    @RequestMapping("/addus")
    public String addus(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
        User user=(User)application.getAttribute("users");
        Calendar cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);
        int hour = cale.get(Calendar.HOUR_OF_DAY);
        int minute = cale.get(Calendar.MINUTE);
        int second = cale.get(Calendar.SECOND);
        int dow = cale.get(Calendar.DAY_OF_WEEK);
        int dom = cale.get(Calendar.DAY_OF_MONTH);
        int doy = cale.get(Calendar.DAY_OF_YEAR);

       /* System.out.println("Current Date: " + cale.getTime());
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Second: " + second);
        System.out.println("Day of Week: " + dow);
        System.out.println("Day of Month: " + dom);
        System.out.println("Day of Year: " + doy);*/

        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String dqrq=sdf.format(now);
        int h=Integer.parseInt(dqrq.substring(8,10));
        User_sign user_sign=new User_sign();
        user_sign.setCount(h);
        user_sign.setUser_id(user.getUser_id());
        user_sign.setSign_count(0);
        user_sign.setCreate_time(firstday);
        user_sign.setLast_modify_time(sdf.format(now));
        int res=user_signService.addus(user_sign);
        return JSON.toJSONString(res);
    }
}
