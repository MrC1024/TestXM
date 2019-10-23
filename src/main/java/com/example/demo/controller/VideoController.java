package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.*;
import com.example.demo.service.BadanwerService;
import com.example.demo.service.TestpaperService;
import com.example.demo.service.UserService;
import com.example.demo.service.VideoService;
import com.example.demo.util.Page;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Resource(name="userService")
    private UserService userService;
    @Autowired
    private TestpaperService testpaperService;
    @Autowired
    private BadanwerService badanwerService;
   /* @ResponseBody
    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){
        Integer pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        Page page = new Page();
        page.setCount(3);
        page.setContent(videoService.getAllByPage((pageIndex-1)*page.getPageCount(), page.getPageCount()));
        return JSON.toJSONString(page);
    }*/
    @ResponseBody
    @RequestMapping("/getIndexById")
    public String getIndexById(int vTypeId,String vName, HttpServletRequest request){
        Integer pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        int zongTS=0;
        Page page = new Page();
        if(vTypeId==0){
            zongTS = videoService.getCount();
        }else{
            zongTS = videoService.getCountT(vTypeId);
        }
        page.setCount(zongTS);
        page.setContent(videoService.getIndexById(vTypeId,vName,(pageIndex-1)*page.getPageCount(),page.getPageCount()));
        return JSON.toJSONString(page);
    }
    @RequestMapping("/getAuthor/{authorId}")
    public String author(@PathVariable("authorId") Integer authorId,HttpServletRequest request){
        author au = videoService.selectAuthor(authorId);
        request.setAttribute("au",au);
        return "author";
    }
    @RequestMapping("/pinglun/{vid}")
    public  String pinglun(@PathVariable("vid") Integer vid,HttpServletRequest request){
        VPingLun vPingLun = new VPingLun();
        vPingLun.setVid(vid);
        vPingLun.setUser_id(1);
        /*List<VPingLun> pingLuns = videoService.getPL(1,vid);*/
        request.setAttribute("vPingLun",vPingLun);
        return "pinglun";
    }
    @ResponseBody
    @RequestMapping("/getPingLun")
    public  String getPingLun(HttpServletRequest request){
        Integer vid = Integer.parseInt(request.getParameter("vid"));
        List<VPingLun> pingLuns = videoService.getPL(vid);
        return JSON.toJSONString(pingLuns);
    }
    @ResponseBody
    @RequestMapping("/getHF")
    public  String getHF(HttpServletRequest request){
        Integer pinglunId = Integer.parseInt(request.getParameter("pinglunId"));
        List<huiFu> huiFus = videoService.getHF(pinglunId);
        return JSON.toJSONString(huiFus);
    }
    @ResponseBody
    @RequestMapping("/addPL")
    public String addPL(HttpServletRequest request,VPingLun vPingLun){
        ServletContext application = request.getSession().getServletContext();
        User user=new User();
        user=(User)application.getAttribute("users");
        Integer vid = Integer.parseInt(request.getParameter("vid"));
        String neirong = request.getParameter("neirong");
        String time = request.getParameter("time");
        user = userService.getMessage(user.getAccount());
        vPingLun.setVid(vid);
        vPingLun.setNeirong(neirong);
        vPingLun.setTime(time);
        vPingLun.setName(user.getUserName());
        vPingLun.setUser_id(user.getUser_id());
        Integer add = videoService.addPL(vPingLun);
       /* System.out.print(vPingLun.getName()+vPingLun.getNeirong()+vPingLun.getVid()+add);*/
        return JSON.toJSONString(add);
    }
    @ResponseBody
    @RequestMapping("/addHF")
    public String addPL(HttpServletRequest request,huiFu huiFu){
        ServletContext application = request.getSession().getServletContext();
        User user=new User();
        user=(User)application.getAttribute("users");
        String hfText = request.getParameter("hfText");
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        Integer pinglunId = Integer.parseInt(request.getParameter("pinglunId"));
        user = userService.getMessage(user.getAccount());
        huiFu.setName(user.getUserName());
        huiFu.setHfText(hfText);
        huiFu.setUser_id(user_id);
        huiFu.setPinglunId(pinglunId);
        Integer add = videoService.addHF(huiFu);
       /* System.out.print(vPingLun.getName()+vPingLun.getNeirong()+vPingLun.getVid()+add);*/
        return JSON.toJSONString(add);
    }

    /**
     * 删除回复
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/del/{hfId}")
    public String del(@PathVariable Integer hfId) {
        Integer res=videoService.del(hfId);
        return JSON.toJSONString(res);
    }
    /**
     * 增加试卷
     */
    @ResponseBody
    @RequestMapping("/addTest")
    public String addTest(HttpServletRequest request,TestPaper testPaper){
        Integer testpaper_step_id = Integer.parseInt(request.getParameter("testpaper_step_id"));
        Integer t_grade = Integer.parseInt(request.getParameter("t_grade"));
        double t_correctness = Double.parseDouble(request.getParameter("t_correctness"));
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        TestpaperStep step = new TestpaperStep();
        step = testpaperService.getTest(testpaper_step_id);
        String t_name = step.getTestpaper_step_name();
        testPaper.setT_name(t_name);
        testPaper.setTestpaperstep_step_id(testpaper_step_id);
        testPaper.setT_grade(t_grade);
        testPaper.setT_correctness(t_correctness);
        testPaper.setUser_id(user_id);
        Integer res = testpaperService.addTest(testPaper);
        return JSON.toJSONString(res);
    }
    /**
     * 增加错题
     */
    @ResponseBody
    @RequestMapping("/addCuoTi")
    public String addCuoTi(HttpServletRequest request,Badanswer badanswer){
        Integer answer_id = Integer.parseInt(request.getParameter("answer_id"));
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        String bad_option = request.getParameter("bad_option");
        badanswer.setAnswer_id(answer_id);
        badanswer.setUser_id(user_id);
        badanswer.setBad_option(bad_option);
        Integer res = badanwerService.addCuoTi(badanswer);
        return  JSON.toJSONString(res);

    }
}
