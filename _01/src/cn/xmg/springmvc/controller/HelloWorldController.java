package cn.xmg.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("HelloWorldController");
		String user = request.getParameter("user");
		//request.setAttribute("key", "今天天气转凉");
		//request.getRequestDispatcher("hello.jsp").forward(request, response);
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "今天天气转凉");
		mv.setViewName("hello.jsp");
		System.out.println(user);
		return mv;
	}

}
