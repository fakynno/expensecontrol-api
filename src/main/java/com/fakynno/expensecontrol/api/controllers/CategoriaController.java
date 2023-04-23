package com.fakynno.expensecontrol.api.controllers;

import com.fakynno.expensecontrol.api.events.RecursoCriadoEvent;
import com.fakynno.expensecontrol.api.models.Categoria;
import com.fakynno.expensecontrol.api.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {

        Categoria categoriaSalva = categoriaRepository.save(categoria);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscaPeloCodigo(@PathVariable Long codigo) {

        Optional<Categoria> categoria = categoriaRepository.findById(codigo);

        return categoria.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(categoria);

        // Optional<Categoria> categoriaSalva =categoriaRepository.findById(codigo);

    }
}
