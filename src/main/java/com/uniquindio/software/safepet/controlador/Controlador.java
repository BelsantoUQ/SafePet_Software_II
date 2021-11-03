package com.uniquindio.software.safepet.controlador;

import com.uniquindio.software.safepet.interfaceService.IcomprobanteService;
import com.uniquindio.software.safepet.interfaceService.IpersonaService;
import com.uniquindio.software.safepet.interfaceService.IveterinatiaService;
import com.uniquindio.software.safepet.modelo.Afiliado;
import com.uniquindio.software.safepet.modelo.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class Controlador {

    @Autowired
    private IpersonaService serviceAfiliado;


    @Autowired
    private IveterinatiaService serviceVeterinaria;


    @Autowired
    private IcomprobanteService serviceComprobante;


    //AFILIADOS

    @GetMapping("/listarAfiliado")
    public String buscarCliente(RedirectAttributes atributo,
                                Model model, Integer codigo){

        if(codigo!=null ){
        Optional<Afiliado> afiliado=serviceAfiliado.listarId(codigo);
        if(!afiliado.isEmpty()) {
            model.addAttribute("afiliados", afiliado.get());
        }else{
            atributo.addFlashAttribute("error","No se han encontrado registros");
            return "redirect:/listarAfiliado";
        }
        }else{

            List<Afiliado>afiliados = serviceAfiliado.listar();
            model.addAttribute("afiliados", afiliados);

        }
        return "indexAfiliado";
    }



    @RequestMapping(value = "/newAfiliado", method = RequestMethod.GET)
    public  String agregarAfiliado(Model model){
        model.addAttribute("afiliado",new Afiliado());
        return "formAfiliado";
    }
    @RequestMapping(value = "/saveAfiliado", method = RequestMethod.POST)
    public String saveAfiliado(@Valid Afiliado afiliado, Model model){
        serviceAfiliado.save(afiliado);
        return "redirect:/listarAfiliado";
    }

    @RequestMapping(value = "/editarAfiliado/{codigo}", method = RequestMethod.GET)
    public String editarAfiliado(@PathVariable int codigo, Model model){
        Optional<Afiliado> afiliado=serviceAfiliado.listarId(codigo);
        model.addAttribute("afiliado",afiliado);

        return"formAfiliado";
    }

    @RequestMapping(value = "/listarAfiliado/{codigo}", method = RequestMethod.GET)
    public String deleteAfiliado(Model model, @PathVariable int codigo){
        serviceAfiliado.delete(codigo);
        return "redirect:/listarAfiliado";
    }

    //VETERINARIA

    @RequestMapping(value = "/listarVeterinaria", method = RequestMethod.GET)
    public String listarveterinaria(Model model){
        List<Veterinaria> veterinarias = serviceVeterinaria.listar();
        model.addAttribute("veterinarias", veterinarias);
        return "indexVeterinarios";
    }

    @RequestMapping(value = "/newVeterinaria", method = RequestMethod.GET)
    public  String agregarVeterinaria(Model model){
        model.addAttribute("veterinaria",new Veterinaria());
        return "formVeterinaria";
    }
    @RequestMapping(value = "/saveVeterinaria", method = RequestMethod.POST)
    public String saveVeterinaria(@Valid Veterinaria veterinaria, Model model){
        serviceVeterinaria.save(veterinaria);
        return "redirect:/listarVeterinaria";
    }

    @RequestMapping(value = "/editarVeterinaria/{codigo}", method = RequestMethod.GET)
    public String editarVeterinaria(@PathVariable int codigo, Model model){
        Optional<Veterinaria> veterinaria=serviceVeterinaria.listarId(codigo);
        model.addAttribute("veterinaria",veterinaria);

        return"formVeterinaria";
    }

    @RequestMapping(value = "/eliminarVeterinaria/{codigo}", method = RequestMethod.GET)
    public String deleteVeterinaria(Model model, @PathVariable int codigo){
        serviceVeterinaria.delete(codigo);
        return "redirect:/listarVeterinaria";
    }

}
