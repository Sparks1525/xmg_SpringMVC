package my.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public ModelAndView test1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Hello World!");
        return null;
    }
}
