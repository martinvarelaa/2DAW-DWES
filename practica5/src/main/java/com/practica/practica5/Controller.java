package com.practica.practica5;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/links/{num}")
    public String controller(Model model, @PathVariable int num) {

        model.addAttribute("num", num);

        return "template";
    }

}
