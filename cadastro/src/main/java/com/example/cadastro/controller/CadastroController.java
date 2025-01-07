package com.example.cadastro.controller;

import com.example.cadastro.model.Cadastro;
import com.example.cadastro.repository.CadastroRepository;
import com.example.cadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")

public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PutMapping
    public ResponseEntity<Cadastro> create(@PathVariable Cadastro cadastro) {
      Cadastro novoCadastro = cadastroService.create(cadastro);
      return ResponseEntity.status(HttpStatus.CREATED).body(novoCadastro);

    }

   @GetMapping
    public ResponseEntity<List<Cadastro>> findALl() {
      List<Cadastro> cadastros = cadastroService.findALl();
      return ResponseEntity.ok(cadastros);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Cadastro> findById(@PathVariable Integer id) {
      Cadastro cadastro = cadastroService.findById(id);
      return ResponseEntity.ok(cadastro);

 }

    @PutMapping("/{id}")
    public ResponseEntity<Cadastro> update(@PathVariable Integer id, @RequestBody Cadastro cadastro) {
      Cadastro atualizado = cadastroService.update(id, cadastro);
      return ResponseEntity.ok(atualizado);
 }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
      cadastroService.delete(id);
      return ResponseEntity.noContent().build();
    }

}
