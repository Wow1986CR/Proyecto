package com.ucreativa.biblioteca.repositories;

import com.ucreativa.biblioteca.entities.Persona;
import com.ucreativa.biblioteca.entities.Retornante;

import java.util.Date;
import java.util.List;

public interface Repository {
    String fueDevuelto = "DEVUELTO";
    String estaPrestado = "PRESTADO";


    void guardarBitacoraPrestamo(
            Persona persona, String book, Date fecha,
            Retornante retornante, String estado);

    List<String> get();

}
