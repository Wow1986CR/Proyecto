package com.ucreativa.biblioteca.services;

import com.ucreativa.biblioteca.entities.*;
import com.ucreativa.biblioteca.repositories.Repository;
import com.ucreativa.biblioteca.ui.ErrorException;

import java.util.Date;
import java.util.List;

import static com.ucreativa.biblioteca.repositories.Repository.estaPrestado;
import static com.ucreativa.biblioteca.repositories.Repository.fueDevuelto;

public class BitacoraPrestamosService {
    private Repository loanRepository;

    public BitacoraPrestamosService(Repository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void guardar(String name, String book, boolean devolucion, String phoneNumber,
                        String email, Retornante retornante) throws ErrorException {
        int phoneNumberEntero;
        try {
            phoneNumberEntero =Integer.parseInt(phoneNumber);
        } catch (NumberFormatException x){
            throw new ErrorException(phoneNumber);
        }
        Persona persona;
        Libro libro;
        String estadoPrestamo;
        if (devolucion){
            persona = new Retornante(name,retornante.getReferencia());
            libro = new Libro(book);
            book = libro.getBookName();
        }else{
            persona = new Deudor(name,phoneNumberEntero,email);
        }

        if (devolucion){
            estadoPrestamo=fueDevuelto;
        }else {
            estadoPrestamo=estaPrestado;
        }
        this.loanRepository.guardarBitacoraPrestamo(persona,book,new Date(),retornante,estadoPrestamo);
    }

    public List<String> get(){
        return this.loanRepository.get();
    }
}//class
