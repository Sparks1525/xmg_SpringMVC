package my.demo.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("HelloWorldController");
        String user = request.getParameter("user");
        request.setAttribute("user", user);
        System.out.println(user);

        ModelAndView mv = new ModelAndView();
        mv.addObject("milk", "chocolate");
        mv.setViewName("hello.jsp");
        return mv;
    }
}
