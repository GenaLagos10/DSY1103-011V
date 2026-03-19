package com.example.bibliotecaduoc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data //Genera getter setters tostring, equals hsahcode y un constructor con los campos requeridos.
@NoArgsConstructor // Genera constructor vacio.
@AllArgsConstructor // Genera un constructor con todos los campos
public class Libro {

    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;

}