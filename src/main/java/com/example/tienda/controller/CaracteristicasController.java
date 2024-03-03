package com.example.tienda.controller;

import com.example.tienda.model.Caracteristicas;
import com.example.tienda.service.CaracteristicasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CaracteristicasController {

    private final CaracteristicasService caracteristicasService;

    public CaracteristicasController(CaracteristicasService caracteristicasService) {
        this.caracteristicasService = caracteristicasService;
    }

    @GetMapping("/caracteristicas/{id}")
    public String mostrarDetallesCaracteristicas(@PathVariable Long id, Model model) {
        Caracteristicas caracteristicas = caracteristicasService.obtenerCaracteristicasPorId(id);
        model.addAttribute("caracteristicas", caracteristicas);
        return "detallesservicio";
    }
}

