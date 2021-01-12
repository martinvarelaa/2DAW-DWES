package com.spring.practica6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Usuario usuario;

    private ArrayList<Anuncio> anuncioArrayList = new ArrayList<Anuncio>();


    @RequestMapping("/tmp")
    public String main1(Model model, HttpSession session, @RequestParam(required = false) String name) {


        if (session.isNew()) {


            return "welcome";

        } else {
            if (name != null) {
                usuario.setUsername(name);
            }

            model.addAttribute("nAnc", usuario.getnAnuncios());
            model.addAttribute("anuncios", anuncioArrayList);
            return "template";
        }

    }

    @RequestMapping("/tmp/crearAnuncio")
    public String main2(Model model) {
        System.out.println(usuario.getUsername());
        model.addAttribute("name", usuario.getUsername());
        return "crear";
    }

    @RequestMapping("/tmp/añadido")
    public String main3(Model model, @RequestParam String titulo, @RequestParam String autor, @RequestParam String cuerpo) {


        anuncioArrayList.add(new Anuncio(titulo, autor, cuerpo));


        usuario.setnAnuncios(usuario.getnAnuncios() + 1);
        System.out.println(usuario.getnAnuncios());


        return "ok";


    }

    @RequestMapping("/tmp/anuncio/{num}")
    public String main4(Model model, @PathVariable int num) {

        model.addAttribute("anuncio", anuncioArrayList.get(num - 1));

        return "anuncio";
    }


}
