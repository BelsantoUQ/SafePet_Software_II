package com.uniquindio.software.safepet.controlador;

import com.uniquindio.software.safepet.interfaceService.IpersonaService;
import com.uniquindio.software.safepet.modelo.Afiliado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IpersonaService service;

    @GetMapping("/listarAfiliado")
    public String listarAfiliado(Model model){
        List<Afiliado>afiliados = service.listar();
        model.addAttribute("afiliados", afiliados);
        return "indexAfiliado";
    }

    @GetMapping("/newAfiliado")
    public  String agregarAfiliado(Model model){
        model.addAttribute("afiliado",new Afiliado());
        return "formAfiliado";
    }
    @PostMapping("/saveAfiliado")
    public String saveAfiliado(@Valid Afiliado afiliado, Model model){
        service.save(afiliado);
        return "redirect:/listarAfiliado";
    }

    @GetMapping("/editarAfiliado/{codigo}")
    public String editarAfiliado(@PathVariable int codigo, Model model){
        Optional<Afiliado> afiliado=service.listarId(codigo);
        model.addAttribute("afiliado",afiliado);

        return"formAfiliado";
    }

    @GetMapping("/eliminar/{codigo}")
    public String deleteAfiliado(Model model, @PathVariable int codigo){
        service.delete(codigo);
        return "redirect:/listarAfiliado";
    }
}
