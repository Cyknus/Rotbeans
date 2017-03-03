/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.practica1;


import java.util.Calendar;
import java.util.List;
import is.mapeo.*;
import is.modelo.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    PersonaDAO dbPersona;
    
    @Autowired
    UserDAO dbUser;

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
    
    @RequestMapping(value="/email", method = RequestMethod.GET)
    public ModelAndView el_correo_ya_llego(ModelMap model,HttpServletRequest request){
        String email = request.getParameter("email");
       
        User u = dbUser.getByEmail(email);
        if (u == null) {
            model.addAttribute("error", "No hay tal");
            return new ModelAndView("inicio", model);
        }
        System.out.println("kha");
        model.addAttribute("user", u);
        return new ModelAndView("resu", model);

    }
    
    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public ModelAndView dar_de_alta(ModelMap model,HttpServletRequest request){
        String email = request.getParameter("email");
        String psswd = request.getParameter("psswd");
        String name = request.getParameter("name");
        String career = request.getParameter("career");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        
        Persona persona = dbPersona.getByName(name);
        if (persona != null) {
            model.addAttribute("error", "No eres único e irrepetible");   
            return new ModelAndView("registro", model);
        }
        
        User user = dbUser.getByEmail(email);
        if (user != null) {
            model.addAttribute("error", "Tu correo no es único e irrepetible.. wait");
            return new ModelAndView("registro", model);
        }
        
        int iyear = Integer.parseInt(year);
        int imonth = Integer.parseInt(month) - 1;
        int iday = Integer.parseInt(day);
        Calendar c = Calendar.getInstance();
        c.set(iyear, imonth, iday);
        
        Persona p = new Persona(name, c.getTime(), career);
        User u = new User(email, psswd);
        u.setPersona(p);
        boolean e = dbUser.save(u);
        
        if (!e) {
            model.addAttribute("error", "No se pudo registrar.");
            return new ModelAndView("registro", model);
        }
        
        model.addAttribute("email", email);
        model.addAttribute("psswd", psswd);
        model.addAttribute("career", career);
        model.addAttribute("name", name);
        model.addAttribute("bday", day + "/" + month + "/" + year);
        
        return new ModelAndView("registrado", model);
}
}
