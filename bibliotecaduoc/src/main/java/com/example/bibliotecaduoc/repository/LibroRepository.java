package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    // Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository(){
            listaLibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
            listaLibros.add(new Libro(2, "9789634944510", "Quique Hache: El Mall Embrujado y Otras Historias", "SM Ediciones", 2014, "Sergio Gómez"));
            listaLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
            listaLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
            listaLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
            listaLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
            listaLibros.add(new Libro(7, "9780321127426", "Effective Java", "Addison-Wesley", 2008, "Joshua Bloch"));
            listaLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin"));
            listaLibros.add(new Libro(9, "9780201633610", "Design Patterns", "Addison-Wesley", 1994, "Erich Gamma"));
            listaLibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));


    }


    // Metodo que retorna todos los libros
    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    // Metodo que busca un libro por su id
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    // Metodo que busca un libro por su isbn
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // Metodo que guarda un libro
    public Libro guardar(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }

    // Metodo que actualiza un libro
    public Libro actualizar(Libro libro) {
        int idPosicion = 0;
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == libro.getId()) {
                idPosicion = i;
                break;
            }
        }
        listaLibros.set(idPosicion, libro);
        return libro;
    }


    // Metodo que elimina un libro por su id
    public void eliminar(int id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
    }
}