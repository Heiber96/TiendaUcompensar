package com.example.tienda.service;

import com.example.tienda.model.Dispositivo;
import com.example.tienda.repository.DispositivoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DispositivoServiceImpl implements DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Override
    public List<Dispositivo> obtenerTodosLosDispositivos() {
        return dispositivoRepository.findAll();
    }

    @Override
    public Dispositivo agregarDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    @Override
    public Dispositivo obtenerDispositivoPorId(Long id) {
        return dispositivoRepository.findById(id).orElse(null);
    }

    @Override
    public Dispositivo obtenerDispositivoConCaracteristicas(Long id) {
        return dispositivoRepository.obtenerDispositivoConCaracteristicas(id);
    }

    @Override
    public void eliminarDispositivo(Long id) {
        // Lógica para eliminar el dispositivo con el ID proporcionado
        dispositivoRepository.deleteById(id);
    }

    @Override
    public void actualizarDispositivo(Dispositivo dispositivo) {
        // Lógica para actualizar el dispositivo
        dispositivoRepository.save(dispositivo);
    }
}



