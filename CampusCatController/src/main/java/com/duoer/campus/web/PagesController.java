package com.duoer.campus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PagesController {
    @RequestMapping("/login")
    public String login() {
        return "forward:/pages/login.html";
    }

    /**
     * 检查用户是否为管理员
     *
     * @return 状态
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "forward:/pages/register.html";
    }

    @RequestMapping({"/home", "/"})
    public String home() {
        return "forward:/pages/home.html";
    }

    @RequestMapping("/records")
    public String records() {
        return "forward:/pages/recordsList.html";
    }

    @RequestMapping("/userRecords")
    public String userRecords() {
        return "forward:/pages/userRecordsList.html";
    }

    @RequestMapping("/catRecords")
    public String catRecords() {
        return "forward:/pages/catRecordsList.html";
    }

    @RequestMapping("/addRecord")
    public String addRecord() {
        return "forward:/pages/addRecord.html";
    }

    @RequestMapping("/updateRecord")
    public String updateRecord() {
        return "forward:/pages/updateRecord.html";
    }

    @RequestMapping("/catsList")
    public String catsList() {
        return "forward:/pages/catsList.html";
    }

    @RequestMapping("/addCat")
    public String addCat() {
        return "forward:/pages/addCat.html";
    }

    @RequestMapping("/adminRecords")
    public String adminRecords() {
        return "forward:/pages/adminRecordsCheck.html";
    }

    @RequestMapping("/adminCats")
    public String adminCats() {
        return "forward:/pages/adminCatsCheck.html";
    }

    @RequestMapping("/adminUpdateCat")
    public String adminUpdateCat() {
        return "forward:/pages/adminUpdateCat.html";
    }
}
