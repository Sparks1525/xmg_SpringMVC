package my.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {
    @RequestMapping("/test1")
    public ModelAndView test1(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("test1");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","test11");
        mv.setViewName("hello.jsp");
        return mv;
    }

    @RequestMapping("/test2")
    public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("test2");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","test22");
        mv.setViewName("hello.jsp");
        return null;
    }

    @RequestMapping("/test3")
    public ModelAndView test3(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("test3");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","test33");
        // mv.setViewName("hello.jsp");
        return null;
    }

    @RequestMapping("/test4")  // Error
    public ModelAndView test4(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("test4");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","test44");
        // mv.setViewName("hello.jsp");
        return mv;
    }

    @RequestMapping("/test5")
    public ModelAndView test5() throws Exception{
        System.out.println("test5");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","test55");
        mv.setViewName("hello.jsp");
        return mv;
    }

    @RequestMapping("/test6")
    public ModelAndView test6() throws Exception{
        System.out.println("test6");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","test66");
        mv.setViewName("hello.jsp");
        return mv;
    }

    @RequestMapping("/test7")
    public ModelAndView test7() throws Exception{
        System.out.println("test7");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","test77");
        mv.setViewName("hello.jsp");
        return null;
    }

}
