package br.gov.sp.fatec.frases.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.frases.controller.View;

@Entity
@Table(name = "aur_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="aur_id")
    @JsonView(View.LivroCompleto.class) 
    private long id;

    @Column(name="aur_nome")
    @JsonView(View.LivroComum.class)
    private String nome;

    @Column(name="aur_bio")
    private String bio;

    @Column(name="aur_pais")
    private String pais;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autores")
    private Set<Livro> livros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        livros = livros;
    }    
}
