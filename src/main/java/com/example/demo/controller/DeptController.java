package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.Dept;
import com.example.demo.service.DeptService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @ResponseBody
    @RequestMapping("/seldept/{id}")
    public String seldept(@PathVariable Integer id){
        Dept dept=new Dept();
        dept=deptService.seldept(id);
        return JSON.toJSONString(dept);
    }
}
