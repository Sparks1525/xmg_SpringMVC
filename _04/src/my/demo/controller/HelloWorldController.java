package my.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public ModelAndView test1(){

        System.out.println("Hello World!");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo.html");
        return mv;
    }

}
