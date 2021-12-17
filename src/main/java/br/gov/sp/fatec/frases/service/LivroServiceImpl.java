package br.gov.sp.fatec.frases.service;

import java.util.HashSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.frases.entity.Autor;
import br.gov.sp.fatec.frases.entity.Livro;
import br.gov.sp.fatec.frases.repository.AutorRepository;
import br.gov.sp.fatec.frases.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {
 
    @Autowired
     LivroRepository livroRepo;

     @Autowired
     AutorRepository autorRepo;

    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public Livro novoLivro(String titulo, long isbn , String nome){
 
        Autor autor = autorRepo.findByNome(nome);
        if(autor == null){
            autor = new Autor();
            autor.setNome(nome);
            autorRepo.save(autor);
        }
        

        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setIsbn(isbn);
        livro.setAutor(new HashSet<Autor>());
        livro.getAutor().add(autor);
        livroRepo.save(livro);

        return livro;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    public List<Livro> buscarTodosLivros(){
       return livroRepo.findAll();
    }

}
