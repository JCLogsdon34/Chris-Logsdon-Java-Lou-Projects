package com.sg.llamajdbc;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
        
    public MainController() {
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String sayHi(Map<String, Object> model) {
        model.put("message", "Hello from the controller" );
        return "index";
    }
}
