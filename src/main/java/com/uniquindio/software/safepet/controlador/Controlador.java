package com.uniquindio.software.safepet.controlador;

import com.uniquindio.software.safepet.interfaceService.*;
import com.uniquindio.software.safepet.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class Controlador {

    @Autowired
    private IpersonaService serviceAfiliado;

    @Autowired
    private IveterinatiaService serviceVeterinaria;

    @Autowired
    private IcomprobanteService serviceComprobante;

    @Autowired
    private IplanService servicePlan;

    @Autowired
    private IservicioService serviceServicio;

    @Autowired
    private IbeneficiarioService serviceMascota;

    @Autowired
    private IhistorialService serviceHistorial;


    @GetMapping({"/"})
    public String index() {
        return "index";
    }

    //AFILIADOS

    @GetMapping("/listarAfiliado")
    public String buscarCliente(RedirectAttributes atributo,
                                Model model, Integer codigo) {

        if (codigo != null) {
            Optional<Afiliado> afiliado = serviceAfiliado.listarId(codigo);
            if (!afiliado.isEmpty()) {
                model.addAttribute("afiliados", afiliado.get());
            } else {
                atributo.addFlashAttribute("error", "No se han encontrado registros");
                return "redirect:/listarAfiliado";
            }
        } else {

            List<Afiliado> afiliados = serviceAfiliado.listar();
            model.addAttribute("afiliados", afiliados);

        }
        return "indexAfiliado";
    }

    @RequestMapping(value = "/newAfiliado", method = RequestMethod.GET)
    public String agregarAfiliado(Model model) {
        model.addAttribute("afiliado", new Afiliado());
        return "formAfiliado";
    }

    @RequestMapping(value = "/saveAfiliado", method = RequestMethod.POST)
    public String saveAfiliado(@Valid Afiliado afiliado, Model model) {
        serviceAfiliado.save(afiliado);
        return "redirect:/listarAfiliado";
    }

    @RequestMapping(value = "/editarAfiliado/{codigo}", method = RequestMethod.GET)
    public String editarAfiliado(@PathVariable int codigo, Model model) {
        Optional<Afiliado> afiliado = serviceAfiliado.listarId(codigo);
        model.addAttribute("afiliado", afiliado);

        return "formAfiliado";
    }

    @RequestMapping(value = "/listarAfiliado/{codigo}", method = RequestMethod.GET)
    public String deleteAfiliado(Model model, @PathVariable int codigo) {
        serviceAfiliado.delete(codigo);
        return "redirect:/listarAfiliado";
    }

    //VETERINARIA

    @RequestMapping(value = "/listarVeterinaria", method = RequestMethod.GET)
    public String listarveterinaria(Model model) {
        List<Veterinaria> veterinarias = serviceVeterinaria.listar();
        model.addAttribute("veterinarias", veterinarias);
        return "indexVeterinarios";
    }

    @RequestMapping(value = "/visitarVeterinaria", method = RequestMethod.GET)
    public String verveterinarias(Model model) {
        List<Veterinaria> veterinarias = serviceVeterinaria.listar();
        model.addAttribute("veterinarias", veterinarias);
        return "vistaVeterinaria";
    }

    @RequestMapping(value = "/newVeterinaria", method = RequestMethod.GET)
    public String agregarVeterinaria(Model model) {
        model.addAttribute("veterinaria", new Veterinaria());
        return "formVeterinaria";
    }

    @RequestMapping(value = "/saveVeterinaria", method = RequestMethod.POST)
    public String saveVeterinaria(@Valid Veterinaria veterinaria, Model model) {
        serviceVeterinaria.save(veterinaria);
        return "redirect:/listarVeterinaria";
    }

    @RequestMapping(value = "/editarVeterinaria/{codigo}", method = RequestMethod.GET)
    public String editarVeterinaria(@PathVariable int codigo, Model model) {
        Optional<Veterinaria> veterinaria = serviceVeterinaria.listarId(codigo);
        model.addAttribute("veterinaria", veterinaria);

        return "formVeterinaria";
    }

    @RequestMapping(value = "/eliminarVeterinaria/{codigo}", method = RequestMethod.GET)
    public String deleteVeterinaria(Model model, @PathVariable int codigo) {
        serviceVeterinaria.delete(codigo);
        return "redirect:/listarVeterinaria";
    }

    /////////// Comprobante

    @GetMapping("/contratos")
    public String buscarContratos(RedirectAttributes atributo,
                                Model model, Integer codigo) {

        if (codigo != null) {
            Optional<Comprobante> comprobante = serviceComprobante.listarId(codigo);
            if (!comprobante.isEmpty()) {
                model.addAttribute("comprobantes", comprobante.get());
            } else {
                atributo.addFlashAttribute("error", "No se han encontrado registros");
                return "redirect:/contratos";
            }
        } else {

            atributo.addFlashAttribute("info", "Puedes consultar la informacion de tu plan" +
                    "buscando por el codigo de tu contrato");


        }
        return "indexCliente";
    }


    @RequestMapping(value = "/visitarComprobante/{codigo}", method = RequestMethod.GET)
    public String visitarComprobante(@PathVariable int codigo, Model model) {
        Optional<Comprobante> comprobante = serviceComprobante.listarId(codigo);
        if (!comprobante.isEmpty()){

            model.addAttribute("comprobante", comprobante.get());

        }

        return "formCliente";
    }




    ///Servicios
    @GetMapping("/listarServicios/{codigo}")
    public String mostrarServicios(RedirectAttributes atributo,
                                   Model model, @PathVariable int codigo) {

        Optional<Plan> plan = servicePlan.listarId(codigo);

        if (!plan.isEmpty()) {
            List<Servicio> servicios = serviceServicio.listarPorPlan(plan.get());
            model.addAttribute("servicios", servicios);
        }
        return "indexServicios";
    }

    ///Mascotas
    @GetMapping("/listarMascotas/{codigo}")
    public String mostrarMascotas(RedirectAttributes atributo,
                                  Model model, @PathVariable int codigo) {

        Optional<Afiliado> afiliado = serviceAfiliado.listarId(codigo);

        if (!afiliado.isEmpty()) {
            List<Beneficiario> mascotas = (serviceMascota.listarPorAfiliado(afiliado.get()));
            model.addAttribute("mascotas", mascotas);
        }
        return "indexMascotas";
    }

    ///Historiales
    @GetMapping("/listarHistoriales/{codigo}")
    public String mostrarHistorial(RedirectAttributes atributo,
                                  Model model, @PathVariable int codigo) {

        Optional<Afiliado> afiliado = serviceAfiliado.listarId(codigo);

        if (!afiliado.isEmpty()) {
            List<Historial> historiales = (serviceHistorial.listarPorAfiliado(afiliado.get()));
            model.addAttribute("historiales", historiales);
        }
        return "indexHistorial";
    }

}
