package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class AjaxController {
    @GetMapping("/time")
    public String showIndex(Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("timenow", dtf.format(now));
        return "index";
    }

    @PostMapping(value = "/gettimezone")
    public String createSmartPhone(@RequestParam("val") String timezone) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-đd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        String currentDate = dateFormat.format(date);
        return currentDate;
    }
}
