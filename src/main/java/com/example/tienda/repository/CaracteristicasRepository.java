package com.example.tienda.repository;

import com.example.tienda.model.Caracteristicas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristicasRepository extends JpaRepository<Caracteristicas, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}
