package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/tiao")
public class HtmlController {
    @RequestMapping("demo.html")
    public String demo() {
        return "demo";
    }

    @RequestMapping("login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("404.html")
    public String FoF() {
        return "404";
    }

    @RequestMapping("calendar.html")
    public String calendar() {
        return "calendar";
    }

    @RequestMapping("chart.html")
    public String chart() {
        return "chart";
    }


    @RequestMapping("form.html")
    public String form() {
        return "form";
    }

    @RequestMapping("table-list.html")
    public String table() {
        return "table-list";
    }

    @RequestMapping("table-list-video.html")
    public String tablelist(HttpServletRequest request) {
        return "table-list-video";
    }

    @RequestMapping("tables.html")
    public String tables() {
        return "tables";
    }

    @RequestMapping("formT.html")
    public String formT() {
        return "formT";
    }

    @RequestMapping("wrong-list.html")
    public String wrongList() {
        return "wrong-list";
    }

    @RequestMapping("test.html")
    public String test() {
        return "test";
    }

    @RequestMapping("test-page.html")
    public String testPage() {
        return "test-page";
    }
}

