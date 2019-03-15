package cn.xmg.springmvc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.xmg.springmvc.domain.User;

@Controller
public class DataController {

	//最原始方式
	@RequestMapping("/data1")
	public ModelAndView data1(HttpServletRequest request){
		request.setAttribute("msg", "阳光不错");
		ModelAndView mv = new ModelAndView("data1.jsp");
		return mv;
	}
	//通过modelandview的方式
	@RequestMapping("/data2")
	public ModelAndView data2(){
		ModelAndView mv = new ModelAndView("data1.jsp");
		mv.addObject("msg", "下午去打球吧");
		mv.addObject("明天上课");//默认的key:数据类型(全小写)string
		mv.addObject(new Date());//key:date
		mv.addObject(new User("a","123"));
		mv.addObject(new User("b","234"));//后面的值覆盖前面的值
		return mv;
	}
	@RequestMapping("/data3")
	@ModelAttribute("myUser")
	public User data3(){
		return new User("mary","345");//响应的视图 前缀+请求路径+后缀  /WEB-INF/view/data3.jsp
	}
	
	@RequestMapping("/data4")
	public String data4(Model model){
		model.addAttribute("msg","data4");
		return "show";//响应的视图 前缀+返回值+后缀  /WEB-INF/view/show.jsp
	}
	@RequestMapping("/data5")
	public String data5(Model model){
		model.addAttribute("key","data5");
		return "forward:hello.jsp";//
	}
	@RequestMapping("/data6")
	public String data6(Model model){
		model.addAttribute("key","data6");
		return "redirect:hello.jsp";//
	}
}
