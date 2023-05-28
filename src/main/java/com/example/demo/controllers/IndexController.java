package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  //si esta en gris queire decir que esta en el codigo pero no se esta utulizando

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    //@RequestMapping(value ="/index"; method = RequestMethod.GET) otra forma de usar
    @Value("${text.title.primary}")
    private String textIndex;
    @Value("${text.title.secondary}")
    private String textPerfil;
    @Value("${text.title.third}")
    private String textListar;
    @GetMapping({"/index","/","","/home"})
    public String  index(ModelMap model){
        model.addAttribute("titulo",textIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        User user = new User();
        user.setName("ivan");
        user.setLastName("chirinos");
        user.setEmail("ivan.correo.com");
        model.addAttribute("user",user);
        model.addAttribute("titulo",textPerfil.concat(user.getName()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar (Model model){
       /*  List<User> users = Arrays.asList(new User("ivan","chirinos","ivan.correo.com"),
                new User("macoto","charaqui","charaqui.correo.com"),                      Esto se podria utilizar como otra opcion de arrays
                new User("loco","valla","valla.correo.com"));   */

        List<User> users = new ArrayList<>();
        users.add(new User("ivan","chirinos","ivan.correo.com"));
        users.add(new User("macoto","charaqui","charaqui.correo.com"));
        users.add(new User("loco","valla","valla.correo.com"));
        model.addAttribute("titulo",textListar);
        model.addAttribute("users",users);
        return "listar";

    }
}
