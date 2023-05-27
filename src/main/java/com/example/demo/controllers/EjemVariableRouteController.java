package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemVariableRouteController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title","enviar parametros de la ruta(@PathVariable)");
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text , Model model){
        model.addAttribute("title","Recibir parametros de la ruta(@PathVariable)");
        model.addAttribute("result","El texto enviado es ".concat(text) );
        return "/variables/see";
    }
    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text, @PathVariable Integer number , Model model){
        model.addAttribute("title","Recibir parametros de la ruta(@PathVariable)");
        model.addAttribute("result","El texto enviado es ".concat(text) .concat(" y el numero enviado en el path es : " .concat(number.toString())) );
        return "/variables/see";
    }

}
