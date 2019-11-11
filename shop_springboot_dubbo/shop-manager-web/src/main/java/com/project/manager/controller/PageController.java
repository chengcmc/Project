package com.project.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用页面跳转，实现页面的跳转
 */
@RequestMapping("/restful/page")
@Controller
public class PageController {
    //写一个实现通用页面跳转的方法
    @GetMapping(value = "{pageName}")
    public String toPage(@PathVariable("pageName") String pageName, Model model){
        System.out.println("/"+pageName);
     return "/"+pageName;
    }
}
