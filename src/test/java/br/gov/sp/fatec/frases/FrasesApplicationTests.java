package br.gov.sp.fatec.frases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.frases.entity.Autor;
import br.gov.sp.fatec.frases.entity.Livro;
import br.gov.sp.fatec.frases.entity.Volume;
import br.gov.sp.fatec.frases.repository.LivroRepository;
import br.gov.sp.fatec.frases.repository.AutorRepository;
import br.gov.sp.fatec.frases.repository.VolumeRepository;
import br.gov.sp.fatec.frases.service.LivroService;


@SpringBootTest
@Transactional
@Rollback
class FrasesApplicationTests {

	@Autowired
	private LivroRepository livroRepo;

	@Autowired
	private AutorRepository autorRepo;

	@Autowired
	private VolumeRepository volRepo;

	@Autowired
	private LivroService livroService;

	@Test
	void contextLoads() {
	}

	@Test
	void findByTituloTest() {
		Livro livro = new Livro();
		livro.setTitulo("titulo");
		livro.setIsbn(1l);
		livro.setEditora("editora");
		livroRepo.save(livro);

		assertNotNull(livroRepo.findByTitulo("titulo"));
	}

	@Test
	void findByisbnOreditoraTest() {
		Livro livro = new Livro();
		livro.setTitulo("titulo");
		livro.setIsbn(1l);
		livro.setEditora("editora");
		livroRepo.save(livro);

		assertFalse(livroRepo.findByIsbnOrEditoraContains(1l, "editora").isEmpty());
	}

	@Test
	void findByAutoresNomeTest() {
		Autor autor = new Autor();
		autor.setNome("Arthur");
		autor.setBio("Biografia do Autor");
		autor.setPais("Brasil");
		autorRepo.save(autor);

		Livro livro = new Livro();
		livro.setTitulo("titulo");
		livro.setIsbn(1l);
		livro.setEditora("editora");
		livro.setAutor(new HashSet<Autor>());
		livro.getAutor().add(autor); 
		livroRepo.save(livro);

		assertFalse(livroRepo.findByAutoresNome("Arthur").isEmpty());
	}


	@Test
	void findByLivrosTituloTest() {
		Autor autor = new Autor();
		autor.setNome("Arthur");
		autor.setBio("Biografia do Autor");
		autor.setPais("Brasil");
		autorRepo.save(autor);

		Livro livro = new Livro();
		livro.setTitulo("titulo");
		livro.setIsbn(1l);
		livro.setEditora("editora");
		livro.setAutor(new HashSet<Autor>());
		livro.getAutor().add(autor); 
		livroRepo.save(livro);

		assertFalse(autorRepo.findByLivrosTitulo("titulo").isEmpty());
	}

	@Test
	void findByVolumesLivrosObservacaoTest() {
		Livro livros = new Livro();
		livros.setTitulo("titulo");
		livros.setIsbn(1l);
		livros.setEditora("editora");
		livroRepo.save(livros);
		
		Volume volume = new Volume();
		volume.setDataAqui(new Date());
		volume.setObservacao("teste");
		volume.setSituacao("teste");
		volume.setLivro(livros);
		volRepo.save(volume);

		assertFalse(livroRepo.findByVolumesObservacao("teste").isEmpty());
	}

	@Test
	void findByLivroEditoraTest() {
		Livro livros = new Livro();
		livros.setTitulo("titulo");
		livros.setIsbn(1l);
		livros.setEditora("editora");
		livroRepo.save(livros);
		
		Volume volume = new Volume();
		volume.setDataAqui(new Date());
		volume.setObservacao("teste");
		volume.setSituacao("teste");
		volume.setLivro(livros);
		volRepo.save(volume);

	assertFalse(volRepo.findByLivroTitulo("titulo").isEmpty());
}



@Test
void novoLivroTest() {
	 livroService.novoLivro("Teste Titulo", 1l, "Teste nome");

	assertNotNull(livroRepo.findByTitulo("Teste Titulo"));
}


}
