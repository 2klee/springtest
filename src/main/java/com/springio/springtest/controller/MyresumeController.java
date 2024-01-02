package com.springio.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyresumeController {
  @GetMapping("myresume")
  public String hello(Model model){
    model.addAttribute("data", "");
    return "/myresume";
  }
}