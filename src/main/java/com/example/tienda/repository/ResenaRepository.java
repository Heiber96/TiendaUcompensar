package com.example.tienda.repository;

import com.example.tienda.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResenaRepository extends JpaRepository<Resena, Long> {
    List<Resena> findByDispositivoId(Long dispositivoId);
    List<Resena> findTop10ByOrderByIdDesc();
}
