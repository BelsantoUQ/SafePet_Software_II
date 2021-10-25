package com.uniquindio.software.safepet.controlador;

import com.uniquindio.software.safepet.interfaceService.IpersonaService;
import com.uniquindio.software.safepet.modelo.Afiliado;
import com.uniquindio.software.safepet.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IpersonaService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Afiliado>afiliados = service.listar();
        model.addAttribute("afiliados", afiliados);
        return "index";
    }

    @GetMapping("/new")
    public  String agregar(Model model){
        model.addAttribute("afiliado",new Afiliado());
        return "form";
    }
    @PostMapping("/save")
    public String save(@Valid Afiliado afiliado, Model model){
        service.save(afiliado);
        return "redirect:/listar";
    }
}
