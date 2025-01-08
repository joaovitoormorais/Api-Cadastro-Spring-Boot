package com.example.cadastro.service;

import com.example.cadastro.model.Cadastro;
import com.example.cadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Cadastro> cadastro = Optional.ofNullable(cadastroRepository.findById(id));
        if(cadastro.isEmpty()) {
            return cadastro.get();
        }else{
            return null;
        }
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
