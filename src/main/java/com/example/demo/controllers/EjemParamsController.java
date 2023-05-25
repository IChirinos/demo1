package com.example.demo.controllers;

import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
@RequestMapping("/params" )

public class EjemParamsController {
    private static final Logger LOG= Logger.getLogger("mylog");
    @GetMapping("/")
    public String index(){
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name="text" , required = false,defaultValue = "no hay nada") String text, Model model){
        model.addAttribute("result","El texto enviado es : ".concat(text) );
        return "params/see";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String greeting , @RequestParam Integer number, Model model){
        LOG.info("El saludo enviado es: ".concat(greeting).concat(" y el numero es ").concat( number.toString() ));

            model.addAttribute("result","El saludo enviado es: ".concat(greeting).concat(" y el numero es ").concat( number.toString() ) );

        return "params/see";
    }
}
