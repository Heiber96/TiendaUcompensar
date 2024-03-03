package com.example.tienda.controller;

import com.example.tienda.model.Dispositivo;
import com.example.tienda.model.Resena;
import com.example.tienda.model.Caracteristicas;
import com.example.tienda.service.CaracteristicasService;
import com.example.tienda.service.DispositivoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.tienda.service.ResenaService;
import java.util.List;

@Controller
@RequestMapping("/dispositivos")
public class DispositivoController {

    private final DispositivoService dispositivoService;
    private final CaracteristicasService caracteristicasService;
    private final ResenaService resenaService;

    public DispositivoController(DispositivoService dispositivoService, CaracteristicasService caracteristicasService, ResenaService resenaService) {
        this.dispositivoService = dispositivoService;
        this.caracteristicasService = caracteristicasService;
        this.resenaService = resenaService;
    }

    @GetMapping({ "/", "/listadodispositivos" })
    public String listaDispositivos(Model model) {
        List<Dispositivo> dispositivos = dispositivoService.obtenerTodosLosDispositivos();
        model.addAttribute("dispositivos", dispositivos);
        return "listadodispositivos";
    }

    @GetMapping("/agregardispositivo")
    public String mostrarFormularioAgregarDispositivo(Model model) {
        model.addAttribute("newDispositivo", new Dispositivo());
        return "agregardispositivo";
    }

    @PostMapping("/agregardispositivo")
    public String agregarDispositivo(@ModelAttribute("newDispositivo") Dispositivo dispositivo) {

        if (dispositivo.getUrlImagen() == null || dispositivo.getUrlImagen().isEmpty()) {
            dispositivo.setUrlImagen("ruta/a/tu/imagen.jpg");
        }

        // Obtener las características del dispositivo
        Caracteristicas caracteristicas = dispositivo.getCaracteristicas();

        // Guardar las Caracteristicas antes de guardar el Dispositivo
        caracteristicasService.guardarCaracteristicas(caracteristicas);

        // Asignar las Caracteristicas al Dispositivo
        dispositivo.setCaracteristicas(caracteristicas);

        // Guardar el Dispositivo
        dispositivoService.agregarDispositivo(dispositivo);

        return "redirect:/dispositivos/listadodispositivos";
    }

    @GetMapping("/detalle/{id}")
public String mostrarDetalles(@PathVariable Long id, Model model) {
    Dispositivo dispositivo = dispositivoService.obtenerDispositivoConCaracteristicas(id);
    Caracteristicas caracteristicas = dispositivo.getCaracteristicas();

    // Obtener las últimas 10 reseñas del dispositivo
    List<Resena> resenas = resenaService.obtenerUltimas10Resenas();

    model.addAttribute("dispositivo", dispositivo);
    model.addAttribute("caracteristicas", caracteristicas);
    model.addAttribute("resenas", resenas); // Agregar las últimas 10 reseñas al modelo

    // Agregar una nueva reseña al modelo para el formulario
    model.addAttribute("resena", new Resena());

    return "detallesdispositivos";
}

    @PostMapping("/agregarresena/{id}")
    public String agregarResena(@PathVariable Long id, @ModelAttribute("resena") Resena resena) {
        // Obtener el dispositivo al que se agregará la reseña
        Dispositivo dispositivo = dispositivoService.obtenerDispositivoPorId(id);

        // Asignar el dispositivo a la reseña
        resena.setDispositivo(dispositivo);

        // Guardar la reseña
        resenaService.guardarResena(resena);

        return "redirect:/dispositivos/detalle/" + id;
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarDispositivoDesdeDetalles(@PathVariable Long id) {
        dispositivoService.eliminarDispositivo(id);
        return "redirect:/dispositivos/listadodispositivos";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizarDispositivo(@PathVariable Long id, Model model) {
        Dispositivo dispositivo = dispositivoService.obtenerDispositivoPorId(id);
        model.addAttribute("dispositivo", dispositivo);
        return "actualizar";
    }

    @PostMapping("/actualizardispositivo")
    public String actualizarDispositivo(@ModelAttribute("dispositivo") Dispositivo dispositivo) {
        dispositivoService.actualizarDispositivo(dispositivo);
        return "redirect:/dispositivos/listadodispositivos";
    }
}
