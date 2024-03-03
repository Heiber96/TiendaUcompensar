// CaracteristicasService.java
package com.example.tienda.service;

import com.example.tienda.model.Caracteristicas;

public interface CaracteristicasService {
    Caracteristicas obtenerCaracteristicasPorId(Long id);
    void guardarCaracteristicas(Caracteristicas caracteristicas);
}

