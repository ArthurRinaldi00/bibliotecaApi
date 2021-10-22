package br.gov.sp.fatec.frases.entity;

import java.util.Set;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "vol_volume")
public class Volume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vol_id")
    private long id;

    @Column(name="vol_data_aquisicao")
    private Date dataAqui;

    @Column(name="vol_observacao")
    private String observacao;

    @Column(name="vol_situacao")
    private String situacao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liv_id")
    private Livro livro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataAqui() {
        return dataAqui;
    }

    public void setDataAqui(Date dataAqui) {
        this.dataAqui = dataAqui;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    
}
