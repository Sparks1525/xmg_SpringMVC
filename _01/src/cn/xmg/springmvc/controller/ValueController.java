package cn.xmg.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.xmg.springmvc.domain.User;

@Controller
public class ValueController {
	/*
	 * 1,action
	 * 定义对象
	 * user
	 * get
	 * 前台
	 * user.userName
	 * user.password
	 * 2.
	 * ModelDriven
	 * 
	 * 
	 * 
	 */
	
	//最原始方式
	@RequestMapping("/value1")
	public ModelAndView value1(HttpServletRequest request){
		System.out.println("ValueController.value1()");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User u = new User(userName,password);
		System.out.println(u);
		ModelAndView mv = new ModelAndView("input.jsp");
		return mv;
	}
	@RequestMapping("/value2")
	public ModelAndView value2(String userName,String password){
		System.out.println("ValueController.value2()");
		User u = new User(userName,password);
		System.out.println(u);
		ModelAndView mv = new ModelAndView("input.jsp");
		return mv;
	}
	@RequestMapping("/value3")
	public ModelAndView value3(@RequestParam("name") String userName,String password){
		System.out.println("ValueController.value3()");
		User u = new User(userName,password);
		System.out.println(u);
		ModelAndView mv = new ModelAndView("input.jsp");
		return mv;
	}
	@RequestMapping("/value4")
	public ModelAndView value4(User u){
		System.out.println("value4");
		System.out.println(u);
		ModelAndView mv = new ModelAndView("input.jsp");
		return mv;
	}
	@RequestMapping("/delete/{id}")
	public ModelAndView value5(@PathVariable("id") Long id){
		System.out.println("delete");
		System.out.println(id);
		ModelAndView mv = new ModelAndView("input.jsp");
		return mv;
	}
	
}
