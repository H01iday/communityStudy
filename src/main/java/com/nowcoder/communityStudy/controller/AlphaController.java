package com.nowcoder.communityStudy.controller;

import com.nowcoder.communityStudy.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello() {
        return "hello Spring Boot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    // 获取请求对象和响应对象
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println(s + ": " + request.getHeader(s));
        }
        System.out.println(request.getParameter("code"));

        // 获取响应数据
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = response.getWriter();) {
            writer.write("<h1>sdasa<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GET请求
    // /student?current=2&limit=20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "1") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some student";
    }

    // /student/123
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    // POST请求
    // @RequestMapping(path = "/student", method = RequestMethod.POST)
    // @ResponseBody
    // public String saveStudent(String name, String age){
    //     System.out.println(name);
    //     System.out.println(age);
    //     return "success";
    // }

    // 响应html数据
    // @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    // public ModelAndView getTeacher(){
    //     ModelAndView mv = new ModelAndView();
    //     mv.addObject("name", "zhangxiao");
    //     mv.addObject("age", "20");
    //     mv.setViewName("/demo/view");
    //     return mv;
    // }

    // 如果返回类型是String 代表要返回视图文件的路径
    // @RequestMapping(path = "/school", method = RequestMethod.GET)
    // public String getSchool(Model model){
    //     model.addAttribute("name", "miongzi");
    //     model.addAttribute("age", 80);
    //     return "/demo/view";
    // }

    // 响应JSON数据
    // java对象
    // @RequestMapping(path = "/emp", method = RequestMethod.GET)
    // @ResponseBody
    // public Map<String, Object> getEmp(){
    //     Map<String, Object> emp = new HashMap<>();
    //     emp.put("name", "zhangsan");
    //     emp.put("age", 22);
    //     emp.put("salary", 800.00);
    //     return emp;
    // }
    //
    // @RequestMapping(path = "/emps", method = RequestMethod.GET)
    // @ResponseBody
    // public List<Map<String, Object>> getEmps(){
    //     List<Map<String, Object>> list = new ArrayList<>();
    //     Map<String, Object> emp = new HashMap<>();
    //     emp.put("name", "zhangsan");
    //     emp.put("age", 22);
    //     emp.put("salary", 800.00);
    //     list.add(emp);
    //     emp = new HashMap<>();
    //     emp.put("name", "zhansda");
    //     emp.put("age", 12);
    //     emp.put("salary", 90.00);
    //     list.add(emp);
    //     return list;
    // }

    // 响应json数据
    @RequestMapping(path = "json1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showjson(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Holdia");
        map.put("age", 222);
        map.put("locate", "guangzhou");
        return map;
    }

    @RequestMapping(path = "json2", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> showjson1(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "yiyi");
        map.put("age", 12);
        list.add(map);
        map.put("name", "erer");
        map.put("age", 13);
        list.add(map);
        map.put("name", "sansan");
        map.put("age", 14);
        list.add(map);
        return list;
    }
}
