package com.springio.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArshaController {
  @GetMapping("arsha")
  public String hello(Model model){
    model.addAttribute("data", "");
    return "/arsha";
  }
}
