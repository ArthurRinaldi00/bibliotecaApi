package br.gov.sp.fatec.frases.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.frases.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

    public List<Autor> findByLivrosTitulo(String titulo);

    public Autor findByNome(String nome);
}
