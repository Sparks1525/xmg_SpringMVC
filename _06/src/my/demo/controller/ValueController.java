package my.demo.controller;

import my.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 传入值
 */

@Controller
public class ValueController {

    @RequestMapping("/value1")
    public ModelAndView value1(HttpServletRequest request) throws UnsupportedEncodingException {
        //request.setCharacterEncoding("utf-8");
        System.out.println("ValueController.value1()");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User u = new User(userName, password);
        System.out.println(u);
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

    // 前端传到后端的parameter和顺序必须和value2(xxx,xxx)里的参数一致
    @RequestMapping("/value2")
    public ModelAndView value2(String userName, String password) {
        System.out.println("ValueController.value2()");
        System.out.println("userName:" + userName + ",password:" + password);
        User u = new User(userName, password);
        System.out.println(u);
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

    // 前端一共三个parameter:userName password other 后端只接收到两个
    @RequestMapping("/value3")
    public ModelAndView value3(Integer userName, String password) {
        System.out.println("ValueController.value2()");
        System.out.println("userName:" + userName + ",password:" + password);
//        User u = new User(userName,password);
//        System.out.println(u);
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

    //前端传入后端的parameter,后端接收可以在参数上打@RequestParam("前端parameter名")标签来唯一标识
    @RequestMapping("/value4")
    public ModelAndView value4(@RequestParam("password") String password,@RequestParam("name") String userName){
        System.out.println("ValueController.value4()");
        User u = new User(userName,password);
        System.out.println(u);
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

    //前端传入后端的parameter,后端参数可以使用对象来接收,值传入对象是根据parameter名和对象setXXX值,也就是属性注入的方式
    @RequestMapping("/value5")
    public ModelAndView value5(User u){
        System.out.println("value5");
        System.out.println(u);
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

    //前端传入后端的parameter,后端参数可以使用对象来接收,值传入对象是根据parameter名和对象setXXX值,也就是属性注入的方式
    @RequestMapping("/value6")
    public ModelAndView value6(User u){
        System.out.println("value6");
        System.out.println(u);
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

    //地址栏传參  localhost/delete/5
    @RequestMapping("/delete/{id}")
    public ModelAndView value7(@PathVariable("id") Long id){
        System.out.println("delete");
        System.out.println(id);
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

}
