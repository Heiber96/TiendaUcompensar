package com.example.tienda.service;

import com.example.tienda.model.Dispositivo;

import java.util.List;

public interface DispositivoService {
    List<Dispositivo> obtenerTodosLosDispositivos();
    Dispositivo agregarDispositivo(Dispositivo dispositivo);
    Dispositivo obtenerDispositivoPorId(Long id);
    Dispositivo obtenerDispositivoConCaracteristicas(Long id);
    void eliminarDispositivo(Long id);
    void actualizarDispositivo(Dispositivo dispositivo);
}
