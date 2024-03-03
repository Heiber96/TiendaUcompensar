package com.example.tienda.service;

import com.example.tienda.model.Resena;

import java.util.List;

public interface ResenaService {
    List<Resena> obtenerUltimas10Resenas();
    List<Resena> obtenerResenasPorDispositivo(Long dispositivoId);
    void guardarResena(Resena resena);
    void eliminarResena(Long resenaId);
    // Otros métodos según sea necesario
}



