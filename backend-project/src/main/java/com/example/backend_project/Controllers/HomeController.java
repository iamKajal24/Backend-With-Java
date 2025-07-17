package com.example.backend_project.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController()
@RequestMapping("/home")
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

   
   /*
    * Important of log message
    1. error
    2. warn
    3. info
    4. debug
    5. trace
    */
   
    @GetMapping
    public String home(@RequestParam(defaultValue = "kajal",required=false)String value){
        //System.out.println("api calling home");
        logger.info("This is api calling {}",value);
        logger.debug("This is api calling {}",value);
        logger.error("This is api calling {}",value);
        logger.warn("This is api calling {}",value);
        logger.trace("This is api calling {}",value);
        return "This is home api";
    }
    
}
