package br.gov.sp.fatec.frases.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.frases.entity.Usuario;
import br.gov.sp.fatec.frases.service.SegurancaService;


@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private SegurancaService usuarioServiceimpl;

    @GetMapping
    @JsonView(View.UsuarioSimplificado.class)
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioServiceimpl.buscarTodosUsuarios();
    }

    @PostMapping
    @JsonView(View.UsuarioCompleto.class)
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return usuarioServiceimpl.novoUsuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), "ROLE_USUARIO");
    }
    
}
