package com.example.tienda.service;

import com.example.tienda.model.Dispositivo;
import com.example.tienda.repository.DispositivoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        
        dispositivoRepository.deleteById(id);
    }

    public void actualizarDispositivoPorId(Long id, Dispositivo dispositivo) {
        
        Optional<Dispositivo> optionalDispositivo = dispositivoRepository.findById(id);
        if (optionalDispositivo.isPresent()) {
           
            Dispositivo dispositivoExistente = optionalDispositivo.get();
            
            
            dispositivoExistente.setNombre(dispositivo.getNombre());
            dispositivoExistente.setTipo(dispositivo.getTipo());
            dispositivoExistente.setMarca(dispositivo.getMarca());
            dispositivoExistente.setCaracteristicas(dispositivo.getCaracteristicas());
            dispositivoExistente.setFechaLanzamiento(dispositivo.getFechaLanzamiento());
            dispositivoExistente.setCamara(dispositivo.getCamara());
            dispositivoExistente.setUrlImagen(dispositivo.getUrlImagen());
            
          
            dispositivoRepository.save(dispositivoExistente);
        } else {
           
            throw new IllegalArgumentException("No se encontró ningún dispositivo con el ID proporcionado: " + id);
        }
    }

    @Override
    public void actualizarDispositivo(Dispositivo dispositivo) {
       
        throw new UnsupportedOperationException("Unimplemented method 'actualizarDispositivo'");
    }
}




