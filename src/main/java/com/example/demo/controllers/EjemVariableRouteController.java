package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemVariableRouteController {
    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text , Model model){
        model.addAttribute("title","Recibir parametros de la ruta(@PathVariable)");
        model.addAttribute("result","El texto enviado es ".concat(text) );
        return "/variables/see";
    }

}
