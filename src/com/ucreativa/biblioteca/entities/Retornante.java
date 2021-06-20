package com.ucreativa.biblioteca.entities;

public class Retornante extends Persona {
    private String referencia;

    public Retornante(String name, String referencia) {
        super(name);
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }
}
