package com.example.tienda.controller;

import com.example.tienda.model.Dispositivo;
import com.example.tienda.model.Resena;
import com.example.tienda.model.Caracteristicas;
import com.example.tienda.service.CaracteristicasService;
import com.example.tienda.service.DispositivoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @ResponseBody
    public List<Dispositivo> listaDispositivos() {
        return dispositivoService.obtenerTodosLosDispositivos();
    }

    
    private static final Logger logger = LoggerFactory.getLogger(DispositivoController.class);
    @PostMapping("/agregardispositivo")
    @ResponseBody
    public Dispositivo agregarDispositivo(@RequestBody Dispositivo dispositivo) {
        logger.info("Objeto de entrada: {}", dispositivo);
        if (dispositivo.getUrlImagen() == null || dispositivo.getUrlImagen().isEmpty()) {
            dispositivo.setUrlImagen("ruta/a/tu/imagen.jpg");
        }
    
        Caracteristicas caracteristicas = dispositivo.getCaracteristicas();
        
        dispositivo.setCaracteristicas(caracteristicas);
        dispositivoService.agregarDispositivo(dispositivo);
    
        return dispositivo;
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

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String eliminarDispositivo(@PathVariable Long id) {
        logger.info("Eliminando dispositivo con ID: {}", id);
        dispositivoService.eliminarDispositivo(id);

        return "Dispositivo eliminado correctamente.";
    }


    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizarDispositivo(@PathVariable Long id, Model model) {
        Dispositivo dispositivo = dispositivoService.obtenerDispositivoPorId(id);
        model.addAttribute("dispositivo", dispositivo);
        return "actualizar"; 
    }

    @PutMapping("/actualizardispositivo/{id}")
    @ResponseBody
    public String actualizarDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        logger.info("Actualizando dispositivo con ID: {}", id);
        dispositivoService.actualizarDispositivoPorId(id, dispositivo);
        return "Dispositivo actualizado correctamente.";
    }
}
