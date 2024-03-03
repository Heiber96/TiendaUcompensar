package com.example.tienda.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private String marca;

    // Relación con Caracteristicas
    @OneToOne(cascade = CascadeType.ALL)
    private Caracteristicas caracteristicas;

    private String fechaLanzamiento;
    private String camara;
    private String urlImagen;

    // Constructores, getters y setters...

    public Dispositivo() {
        // Constructor vacío necesario para JPA
    }

    public Dispositivo(String nombre, String tipo, String marca, Caracteristicas caracteristicas, String fechaLanzamiento, String camara) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.caracteristicas = caracteristicas;
        this.fechaLanzamiento = fechaLanzamiento;
        this.camara = camara;
    }

    // Getter y Setter para id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter y Setter para nombre

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para tipo

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter y Setter para marca

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter y Setter para Caracteristicas

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    // Getter y Setter para fechaLanzamiento

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    // Getter y Setter para camara

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    // Getter y Setter para urlImagen

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
