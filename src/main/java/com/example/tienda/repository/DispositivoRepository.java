package com.example.tienda.repository;

import com.example.tienda.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    @Query("SELECT d FROM Dispositivo d LEFT JOIN FETCH d.caracteristicas WHERE d.id = :id")
    Dispositivo obtenerDispositivoConCaracteristicas(@Param("id") Long id);
}
