package com.ucreativa.biblioteca.repositories;

import com.ucreativa.biblioteca.entities.Persona;
import com.ucreativa.biblioteca.entities.Retornante;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepository implements Repository {
    private final String FILE_PATH_LOANS = "prestamos.txt";

    @Override
    public void guardarBitacoraPrestamo(Persona persona,String book, Date fecha,
                                        Retornante retornante, String estado) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String texto = "DEUDOR: "+persona.getName()+
                " | OBRA: "+book+
                " | FECHA: "+format.format(fecha)+
                " | CONTACTO: "+persona.getPhoneNumber()+
                " - "+persona.getEmail()+
                " | REFERENCIA: "+retornante.getReferencia()+
                " | "+estado+"\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_LOANS,true));
            writer.append(texto);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_LOANS));
            return reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
