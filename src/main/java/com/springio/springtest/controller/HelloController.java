package com.springio.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
  @GetMapping("hello")
  public String hello(Model model){
    model.addAttribute("data", "hello String Boot!");
    return "hello";
  }

  @GetMapping("sample")
  public String sample(Model model){
    model.addAttribute("data", "");
    return "sample";
  }

  @GetMapping("myresume")
  public String myresume(Model model){
    model.addAttribute("data", "");
    return "myresume";
  }

  @GetMapping("arsha")
  public String arsha(Model model) {
    model.addAttribute("data", "");
    return "arsha";
  }



  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
    // @RequestParam 는 기본적으로 반듯이 필요한 required = true 상태이기 때문에 없어도 오류가 뜨기 않게 required = false 설정
    model.addAttribute("name", name); //http://localhost/hello-mvc?name=jp 로 들어가면 hello jp 가 뜸
    return "hello-template";
  }

  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("name") String name){
    return "hello " + name;
  }

  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("name")String name){
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
  }

  static class Hello{
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }


}
