package com.tsguild.surveymvc;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {
        
    private List<Integer> ages;
    private List<String> favColors;
    private List<String> names;
    
    public SurveyController() {
        
        ages = new ArrayList<>();
        favColors = new ArrayList<>();
        names = new ArrayList<>();
        
    }
    
    @RequestMapping(value="/processForm", method=RequestMethod.POST)
    public String processForm(HttpServletRequest request){
        System.out.println("GOT TO THE PROCESSING METHOD!");
        
        String x = request.getParameter("name");
        Integer y = this.getIntFromString(request.getParameter("age"));
        String z = request.getParameter("color");
        
        
        if(x == null || y == null || z== null || 
                x.isEmpty() || y <=0 || z.isEmpty()){
            
            if(x == null || x.isEmpty()){
                request.setAttribute("nameWuzBad", true);
            }else{
                request.setAttribute("nameInput", x);
            }
            
            if(y == null || y <=0 ){
                request.setAttribute("ageWuzBad", true);
            }else{
                request.setAttribute("ageInput", y);
            }
            
            if(z == null || z.isEmpty()){
                request.setAttribute("colorWuzBad", true);
            }else{
                request.setAttribute("colorInput", z);
            }
            
            return "someonewasbad";
        }
        
        // Therefore if I get to here, I know I have a name, age and color.
        names.add(x);
        ages.add(y);
        favColors.add(z);
        
        return "thankyou";
    }
    
    
    @RequestMapping(value="/results", method=RequestMethod.GET)
    public String showAllResults(Model model){
        System.out.println("GOT TO THE RESULTS PAGE");
        model.addAttribute("nameList", names);
        model.addAttribute("ageList", ages);
        model.addAttribute("colorList", favColors);
        
        return "surveyresults";
    }
    
    @RequestMapping(value="/llama", method=RequestMethod.GET)
    public String showLlama(){
        System.out.println("GOT TO THE CONTROLLER! (llama get method)");
        return "llama";
    }
    
    private Integer getIntFromString(String numString){
        try{
            return Integer.parseInt(numString);
        } catch(NumberFormatException e){
            return null;
        }
    }
}
