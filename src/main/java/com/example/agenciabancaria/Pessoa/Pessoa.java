package com.example.agenciabancaria.Pessoa;

import com.example.agenciabancaria.Endereco.Cidade;
import com.example.agenciabancaria.Endereco.Estado;

import java.util.Date;

public interface Pessoa {
    String getNome();
    String getCpf();
    Date getNascimento();
    Cidade getCidade();
    Estado getEstado();
}
