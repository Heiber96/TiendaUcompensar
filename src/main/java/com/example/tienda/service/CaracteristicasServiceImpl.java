package com.example.tienda.service;

import com.example.tienda.model.Caracteristicas;
import com.example.tienda.repository.CaracteristicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaracteristicasServiceImpl implements CaracteristicasService {

    private final CaracteristicasRepository caracteristicasRepository;

    @Autowired
    public CaracteristicasServiceImpl(CaracteristicasRepository caracteristicasRepository) {
        this.caracteristicasRepository = caracteristicasRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Caracteristicas obtenerCaracteristicasPorId(Long id) {
        return caracteristicasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardarCaracteristicas(Caracteristicas caracteristicas) {
        caracteristicasRepository.save(caracteristicas);
    }
}