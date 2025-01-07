package com.example.cadastro.repository;

import com.example.cadastro.model.Cadastro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository {
    Cadastro save(Cadastro cadastro);

    List<Cadastro> findALl();

    Cadastro findById(Integer id);

    void delete(Cadastro cadastro);
}
