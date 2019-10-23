package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.User;
import com.example.demo.pojo.User_sign;
import com.example.demo.pojo.User_sign_log;
import com.example.demo.service.User_signService;
import com.example.demo.service.User_sign_logService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("/log")
public class User_sign_logController {
    @Autowired
    private User_sign_logService user_sign_logService;
    @ResponseBody
    @RequestMapping("/addlog")
    public String addtt(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");//可以方便地修改日期格式
        String dqrq=sdf.format(now);
        int h=Integer.parseInt(dqrq.substring(8,10));
        User_sign_log user_sign_log=new User_sign_log();
        int res=0;
        String[] f=dqrq.split("-");
        Date date1=new Date();
        User_sign user_sign=(User_sign) application.getAttribute("user_sign");
        String maxdate=user_sign_logService.selmaxDate(user_sign.getId());
        int maxdate1=0;
        if(maxdate==null){
            maxdate1=0;
        }else{
            maxdate1=Integer.parseInt(maxdate.substring(8,10));
        }

        for(int i=maxdate1;i<h;i++){

            GregorianCalendar gc = new GregorianCalendar();
            gc.set(Calendar.YEAR,Integer.parseInt(f[0]));//设置年
            gc.set(Calendar.MONTH,Integer.parseInt((f[1]))-1);//这里0是1月..以此向后推
            gc.set(Calendar.DAY_OF_MONTH, i+1);//设置天
            date1 = gc.getTime();

            user_sign_log.setCreate_time(sdf.format(date1));
            user_sign_log.setSign_status("0");
            user_sign_log.setUpdate_time(sdf.format(now));

            user_sign_log.setUser_sign_id(user_sign.getId());
            res=user_sign_logService.addtt(user_sign_log);
            if(res==0){
                break;
            }
        }
        return JSON.toJSONString(res);
    }
    @ResponseBody
    @RequestMapping("/selall")
    public String selall(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
        User_sign user_sign=(User_sign) application.getAttribute("user_sign");
        List<User_sign_log>  list=user_sign_logService.selall(user_sign.getId());
        return JSON.toJSONString(list);
    }
    @ResponseBody
    @RequestMapping("/sfqd/{id}")
    public String sfqd(@PathVariable("id")int id){
        String status=user_sign_logService.sfqd(id);
        return JSON.toJSONString(status);
    }
    @ResponseBody
    @RequestMapping("/qd")
    public String qd(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
        User_sign user_sign=(User_sign) application.getAttribute("user_sign");
        int res=user_sign_logService.sfqd1(user_sign.getId());

        return JSON.toJSONString(res);
    }
    @ResponseBody
    @RequestMapping("/qd1")
    public String qd1(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
        User_sign user_sign=(User_sign) application.getAttribute("user_sign");
        int res1=user_sign_logService.sfqd1(user_sign.getId());
        int res=0;
        if(res1==0) {
            res = user_sign_logService.qd(user_sign.getId());
        }
        return JSON.toJSONString(res);
    }
    @ResponseBody
    @RequestMapping("/lx")
    public String lx(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
        User_sign user_sign=(User_sign) application.getAttribute("user_sign");
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

     /*   System.out.println("Current Date: " + cale.getTime());
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");//可以方便地修改日期格式
        String dqrq=sdf.format(now);
        int h=Integer.parseInt(dqrq.substring(8,10));
        User_sign_log user_sign_log=new User_sign_log();
        String[] f=dqrq.split("-");
        Date date1=new Date();

        int res=0;

        for(int i=1;i<h;i++){
            int res1=0;
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(Calendar.YEAR,Integer.parseInt(f[0]));//设置年
            gc.set(Calendar.MONTH,Integer.parseInt((f[1]))-1);//这里0是1月..以此向后推
            gc.set(Calendar.DAY_OF_MONTH, i+1);//设置天
            date1 = gc.getTime();
            res1=user_sign_logService.lx(user_sign.getId(),sdf.format(date1));
            if(res1==1){
                res=res+1;

            }else{
                res=0;
            }
        }

        return JSON.toJSONString(res);
    }
}
