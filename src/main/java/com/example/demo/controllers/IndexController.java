package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  //si esta en gris queire decir que esta en el codigo pero no se esta utulizando

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    //@RequestMapping(value ="/index"; method = RequestMethod.GET) otra forma de usar

    @GetMapping({"/index","/","","/home"})
    public String  index(ModelMap model){
        model.addAttribute("titulo","hola Sring frameowrk");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        User user = new User();
        user.setName("ivan");
        user.setLastName("chirinos");
        user.setEmail("ivan.correo.com");
        model.addAttribute("user",user);
        model.addAttribute("titulo","Perfil del usuario:".concat(user.getName()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar (Model model){

        List<User> users = new ArrayList<>();

        model.addAttribute("titulo","Listado de usuarios");
        model.addAttribute("users",users);
        return "listar";

    }
}
