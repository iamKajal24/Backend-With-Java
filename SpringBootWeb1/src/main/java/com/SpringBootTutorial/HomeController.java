package com.SpringBootTutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @ModelAttribute("course")
    public String courseName(){
        return "java";
    }


   @RequestMapping(value = "/")
    public String Home(){
        System.out.println("home controller :");

        return "index";
    }


    @RequestMapping(value = "/index")
    public String Home1(){
        System.out.println("home controller 1:");

        return "index1";
    }



    // @RequestMapping("add")
    // public String add(HttpServletRequest req,HttpSession session){
    //     System.out.println("in add");
    //      int num1 = Integer.parseInt(req.getParameter("num1"));
    //       int num2 = Integer.parseInt(req.getParameter("num2"));
    //       int result = num1+num2;
    //     //  System.out.println(result);

    //     session.setAttribute("result", result);
       
    //       return "result.jsp";
    // }

    // Modyfy the code

    // @RequestMapping("add")
    //  public String add(@RequestParam("num1")int num1,@RequestParam("num2")int num2,HttpSession session){
    //     System.out.println("in add");
        
    //       int result = num1+num2;
    //     //  System.out.println(result);

    //     session.setAttribute("result", result);
       
    //       return "result.jsp";
    // }

    // removed session 
    // @RequestMapping("add")
    //  public String add(@RequestParam("num1")int num1,@RequestParam("num2")int num2,Model model){
    //     System.out.println("in add");
        
    //       int result = num1+num2;
    //     //  System.out.println(result);

    //   model.addAttribute("result",result);
       
    //       return "result";
    // }

    //using modelandView
     @RequestMapping("add")
     public ModelAndView add(@RequestParam("num1")int num1,@RequestParam("num2")int num2,ModelAndView mv){
        System.out.println("in add");
        
          int result = num1+num2;
        //  System.out.println(result);

      mv.addObject("result",result);
      mv.setViewName("result");
       
          return mv;
    }

    //  @RequestMapping("addAlien")
    //  public ModelAndView addObject(@RequestParam("aid")int aid,@RequestParam("aname")String aname,ModelAndView mv){
    //     System.out.println("in add in object");
        
    //     Alien alien = new Alien();
    //     alien.setAid(aid);
    //     alien.setAname(aname);

    //   mv.addObject("alien",alien);
    //   mv.setViewName("result2");
       
    //       return mv;
    // }

     @RequestMapping("addAlien")
     public String addObject(@ModelAttribute Alien alien){
        System.out.println("in add in object");
        
      //  Alien alien = new Alien();
        //alien.setAid(aid);
        //alien.setAname(aname);

    //   mv.addObject("alien",alien);
    //   mv.setViewName("result2");
       
          return "result2";
    }
   
}
