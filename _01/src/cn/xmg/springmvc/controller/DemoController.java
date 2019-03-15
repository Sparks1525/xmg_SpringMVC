package cn.xmg.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@RequestMapping("/demo6")
	public ModelAndView demo6(){
		System.out.println("demo6");
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("hello.jsp");
		return mv;
	}
}
