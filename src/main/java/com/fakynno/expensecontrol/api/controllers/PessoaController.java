package com.fakynno.expensecontrol.api.controllers;

import com.fakynno.expensecontrol.api.events.RecursoCriadoEvent;
import com.fakynno.expensecontrol.api.models.Pessoa;
import com.fakynno.expensecontrol.api.repositories.PessoaRepository;
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
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Pessoa> listar() {

        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {

        Pessoa novaPessoa = pessoaRepository.save(pessoa);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, novaPessoa.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPessoaPeloCodigo(@PathVariable Long codigo) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);

        return pessoa.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        pessoaRepository.deleteById(codigo);
    }
}
