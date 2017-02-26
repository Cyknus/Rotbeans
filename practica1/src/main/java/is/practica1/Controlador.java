/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.practica1;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jonathan
 */
@Controller 
public class Controlador {
    
    @RequestMapping(value="/")
    public String inicio(){
        return "inicio";
    }
    
    @RequestMapping(value="/registro")
    public String registro(){
        return "registro";
    }   
    
    @RequestMapping(value="/sesion", method = RequestMethod.POST)
    public ModelAndView comoSea(ModelMap model,HttpServletRequest request){
        String email = request.getParameter("email");
        String psswd = request.getParameter("psswd");
        model.addAttribute("email", email);
        model.addAttribute("psswd", psswd);
        return new ModelAndView("sesion",model);
    
    }
    
    @RequestMapping(value="/registrado", method = RequestMethod.GET)
    public ModelAndView noImporta(ModelMap model,HttpServletRequest request){
        String name = request.getParameter("name");
        String career = request.getParameter("career");
        String birthdate = request.getParameter("day");
        birthdate += "-" + request.getParameter("month");
        birthdate += "-" + request.getParameter("year");
        String email = request.getParameter("email");
        String psswd = request.getParameter("psswd");
        model.addAttribute("name", name);
        model.addAttribute("career", career);
        model.addAttribute("birthdate", birthdate);
        model.addAttribute("email", email);
        model.addAttribute("psswd", psswd);
        return new ModelAndView("registrado",model);
    }
    
    
}
