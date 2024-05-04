package com.example.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

//  declaramos la clase Vehiculo y la comparamos con la tabla de la base
@Data
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

    public Vehiculo(int id, String marca, String modelo, String matricula, String color, String anio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
        this.anio = anio;
    }

    public Vehiculo() {
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty
    private String marca;
    
    @NotEmpty
    private String modelo;
    
    @NotEmpty
    private String matricula;
    
    @NotEmpty
    private String color;
    
    @NotEmpty
    private String anio;
}
