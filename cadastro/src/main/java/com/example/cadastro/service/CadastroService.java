package com.example.cadastro.service;

import com.example.cadastro.model.Cadastro;
import com.example.cadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;


    public Cadastro create(Cadastro cadastro) {
      return cadastroRepository.save(cadastro);
    }

    public List<Cadastro> findALl() {
        return cadastroRepository.findALl();
    }

    public Cadastro findById(Integer id) {
        return cadastroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cadastro não encontrado!"));
    }

    public Cadastro update(Integer id, Cadastro cadastro) {
    Cadastro existente = findById(id);
    cadastro.setEmail(cadastro.getEmail());
    cadastro.setPassword(cadastro.getPassword());
    cadastro.setName(cadastro.getName());
    return cadastroRepository.save(cadastro);
    }

    public void delete(Integer id) {
        Cadastro cadastro = cadastroRepository.findById(id);
        cadastroRepository.delete(cadastro);
    }
}
