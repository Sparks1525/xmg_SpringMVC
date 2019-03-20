package my.demo.controller;

import my.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * 返回值
 */

@Controller
public class DataController {

    //最原始方式
    @RequestMapping("/data1")
    public ModelAndView data1(HttpServletRequest request) {
        request.setAttribute("msg", "data111");
        /**
         * 设置了视图解析器,就不用写成 ModelAndView mv = new ModelAndView("/data1.jsp");
         */
        ModelAndView mv = new ModelAndView("/data1");
        return mv;
    }

    //通过ModelAndView的方式
    @RequestMapping("/data2")
    public ModelAndView data2() {

        ModelAndView mv = new ModelAndView("/data2");
        mv.addObject("msg", "data222");
        mv.addObject("Hello Data222");//默认的key:数据类型(全小写)string
        mv.addObject(new Date());//key:date
        mv.addObject(new User("a", "123"));
        mv.addObject(new User("b", "234"));//后面的值覆盖前面的值
        return mv;
    }
    //通过ModelAndView的方式
    @RequestMapping("/data3")
    public ModelAndView data3(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/data3");

        request.setAttribute("msg1", "setAttribute msg1");
        mv.addObject("msg2", "addObject msg2");

        /**
         * 对于setAttribute和addObject标识名称相同,不存在后面的值覆盖前面的值,只会使用addObject
         * 但是对于setAttribute和addObject 两个相同set/add的标识名称,则后面的值覆盖前面的值
         */
        request.setAttribute("msg3", "before setAttribute msg3");
        mv.addObject("msg3", "after addObject  msg3");
        mv.addObject("msg4", "before addObject  msg4");
        request.setAttribute("msg4", "after setAttribute msg4");

        request.setAttribute("msg5", "before setAttribute msg5");
        request.setAttribute("msg5", "after setAttribute msg5");

        mv.addObject("Hello Data333");//默认的key:数据类型(全小写)string
        mv.addObject(new Date());//key:date
        mv.addObject(new User("a", "321"));
        mv.addObject(new User("b", "432"));//后面的值覆盖前面的值
        return mv;
    }

    /**
     * 设置ModelAttribute("myUser),前端使用 ${myUser} 取值
     * 并且不能使用数据类型取值
     */
    @RequestMapping("/data4")
    @ModelAttribute("myUser")
    public User data4() {
        return new User("mary4", "444");//响应的视图 前缀+请求路径+后缀  /WEB-INF/view/data4.jsp
    }

    /**
     * 若没有设置ModelAttribute,
     * 前端默认的key为:数据类型(全小写)${user}
     * 也可以使用${user.password} 取属性值
     */
    @RequestMapping("/data5")
    public User data5() {
        return new User("mary5", "555");//响应的视图 前缀+请求路径+后缀  /WEB-INF/view/data5.jsp
    }

    /**
     * 对于setAttribute和ModelAttribute标识名称相同,不存在后面的值覆盖前面的值,只会使用ModelAttribute
     * 但是对于setAttribute和ModelAttribute 两个相同set/Mode的标识名称,则后面的值覆盖前面的值
     */
    @RequestMapping("/data6")
    @ModelAttribute("myUser")
    public User data6(HttpServletRequest request) {
        request.setAttribute("myUser", "setAttribute myUser");
        request.setAttribute("requestTest", "setAttribute requestTest");
        return new User("mary6", "666");//响应的视图 前缀+请求路径+后缀  /WEB-INF/view/data5.jsp
    }

    @RequestMapping("/data7")
    public String data7(Model model){
        model.addAttribute("msg","data777");
        return "data7";//响应的视图 前缀+返回值+后缀  /WEB-INF/view/data7.jsp
    }

    /**
     * 可以省略Model参数名
     * @return
     */
    @RequestMapping("/data8")
    public String data8(){
        return "data8";//响应的视图 前缀+返回值+后缀  /WEB-INF/view/data8.jsp
    }

    /**
     * 可以同时添加ModelAttribute标签和Model HttpServletRequest参数
     * 并且ModelAttribute不会被相同标识名称的Model和request所覆盖
     * model会覆盖相同标识名称的request,无论request在前或在后
     */
    @RequestMapping("/data9")
    @ModelAttribute("msg3")
    public String data9(Model model, HttpServletRequest request){
        model.addAttribute("msg1","model data");
        request.setAttribute("msg2", "attribute data");

        request.setAttribute("msg4", "before attribute data msg4");
        model.addAttribute("msg4","after model data msg4");

        model.addAttribute("msg5","before model data msg5");
        request.setAttribute("msg5", "after attribute data msg5");

        return "data9";//响应的视图 前缀+返回值+后缀  /WEB-INF/view/data9.jsp
    }

    /**
     * 请求转发会附带值 从/web/目录下开始找xxx.jsp
     */
    @RequestMapping("/data10")
    public String data10(Model model){
        model.addAttribute("key","data10");
        return "forward:hello.jsp";//
    }

    /**
     * 重定向不会附带任何值 从/web/目录下开始找xxx.jsp
     */
    @RequestMapping("/data11")
    public String data11(Model model){
        model.addAttribute("key","data11");
        return "redirect:hello.jsp";
    }

    /**
     * ModelAttribute("msg4")的值为空
     *
     * 相同标识名称取值优先顺序 ModelAndView > model > request
     */
    @RequestMapping("/data12")
    @ModelAttribute("msg4")
    public ModelAndView data12(HttpServletRequest request, Model model) {
        ModelAndView mv = new ModelAndView("/data12");

        mv.addObject("msg1", "ModelAndView msg1");
        request.setAttribute("msg2", "request msg2");
        model.addAttribute("msg3","model msg3");

        mv.addObject("msg4", "ModelAndView msg4");
        request.setAttribute("msg4", "request msg4");
        model.addAttribute("msg4","model msg4");

        model.addAttribute("msg5","model msg5");
        request.setAttribute("msg5", "request msg5");

        return mv;
    }


    /**
     * 总结:
     *
     * 若返回ModelAndView对象
     * 1. mv对象和ModelAndView,model,request有相同标识名称,则相同标识名称取值优先顺序 ModelAndView > @ModelAttribute > model > request
     * 2.若无相同标识名称  则其他相同标识名称取值优先顺序 @ModelAttribute > model > request
     *
     * 若返回其他对象
     * 1.则相同标识名称取值优先顺序 @ModelAttribute > 数据类型(全小写) > model > request
     * 2.若@ModelAttribute无相同标识名称 则相同标识名称取值优先顺序 数据类型(全小写) > model > request
     */
}
