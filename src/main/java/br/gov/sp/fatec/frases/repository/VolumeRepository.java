package br.gov.sp.fatec.frases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.frases.entity.Volume;

public interface VolumeRepository extends JpaRepository<Volume, Long>{
    public List<Volume> findByLivroTitulo(String titulo);
}
