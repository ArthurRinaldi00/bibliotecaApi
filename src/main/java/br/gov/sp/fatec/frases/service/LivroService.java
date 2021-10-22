package br.gov.sp.fatec.frases.service;

import java.util.List;

import br.gov.sp.fatec.frases.entity.Livro;

public interface LivroService {
    public Livro novoLivro(String titulo, long isbn , String nome);

    public List<Livro> buscarTodosLivros();
}
