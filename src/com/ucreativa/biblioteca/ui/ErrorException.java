package com.ucreativa.biblioteca.ui;

public class ErrorException extends Throwable {

    public ErrorException(String data) {
        super("El valor ingresado es incorrecto: " + data);
    }
}
