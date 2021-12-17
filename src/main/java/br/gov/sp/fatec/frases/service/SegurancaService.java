package br.gov.sp.fatec.frases.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.frases.entity.Usuario;

public interface SegurancaService extends UserDetailsService{

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
}
