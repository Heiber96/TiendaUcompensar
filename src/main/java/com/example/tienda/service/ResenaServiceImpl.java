package com.example.tienda.service;

import com.example.tienda.model.Resena;
import com.example.tienda.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaServiceImpl implements ResenaService {

    private final ResenaRepository resenaRepository;

    @Autowired
    public ResenaServiceImpl(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    @Override
    public List<Resena> obtenerUltimas10Resenas() {
        return resenaRepository.findTop10ByOrderByIdDesc();
    }

    @Override
    public List<Resena> obtenerResenasPorDispositivo(Long dispositivoId) {
        return resenaRepository.findByDispositivoId(dispositivoId);
    }

    @Override
    public void guardarResena(Resena resena) {
        resenaRepository.save(resena);
    }

    @Override
    public void eliminarResena(Long resenaId) {
        resenaRepository.deleteById(resenaId);
    }

    // Otros métodos según sea necesario
}
