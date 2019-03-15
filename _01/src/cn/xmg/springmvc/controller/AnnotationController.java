package cn.xmg.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationController {
	@RequestMapping("/demo1")
	public ModelAndView method(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("AnnotationController");
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "今天天气转凉");
		mv.setViewName("hello.jsp");
		return mv;
	}
	@RequestMapping("/demo2")
	public ModelAndView method2(HttpServletResponse response,HttpServletRequest request) throws Exception {
		System.out.println("method2");
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "method2");
		mv.setViewName("hello.jsp");
		return mv;
	}
	@RequestMapping("/demo3")
	public ModelAndView method3(HttpServletResponse response,HttpSession session) throws Exception {
		System.out.println(session);
		System.out.println("method2");
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "method2");
		mv.setViewName("hello.jsp");
		return mv;
	}
	@RequestMapping("/demo4")
	public ModelAndView method4(HttpServletResponse response,HttpSession session) throws Exception {
		System.out.println(session);
		System.out.println("method2");
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "method2");
		mv.setViewName("hello.jsp");
		return null;
	}
	@RequestMapping("/demo5")
	public ModelAndView method5(HttpSession session) throws Exception {
		System.out.println(session);
		System.out.println("method2");
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "method2");
		mv.setViewName("hello.jsp");
		return mv;
	}
}
