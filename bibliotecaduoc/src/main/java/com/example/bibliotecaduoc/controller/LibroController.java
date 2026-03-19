package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.getLibros();
    }

    @GetMapping("/{id}")
    public Libro buscarLibroPorId(@PathVariable int id) {
        return libroService.getLibroId(id);
    }

    @GetMapping("/isbn/{isbn}")
    public Libro buscarLibroPorIsbn(@PathVariable String isbn) {
        return libroService.getLibroIsbn(isbn);
    }

    @PostMapping
    public Libro guardarLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    @PutMapping
    public Libro actualizarLibro(@RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable int id) {
        libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibros() {
        return libroService.totalLibros();
    }


}