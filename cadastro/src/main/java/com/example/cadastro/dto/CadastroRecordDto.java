package com.example.cadastro.dto;

import com.example.cadastro.model.Cadastro;

public record CadastroRecordDto(int id, String nome, String email, String password) {

    public Cadastro toEntity() {
        Cadastro cadastro = new Cadastro();
        cadastro.setId(this.id);
        cadastro.setName(this.nome);
        cadastro.setPassword(this.password);
        cadastro.setEmail(this.email);
        return cadastro;
    }

    public static CadastroRecordDto fromEntity(Cadastro cadastro) {
       return new CadastroRecordDto(cadastro.getId(),
               cadastro.getEmail(), cadastro.getPassword(), cadastro.getName());
    }
}
