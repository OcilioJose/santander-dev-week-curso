package me.dio.service;

import me.dio.dominio.model.Usuario;

public interface UsuarioService {

    public Usuario buscarPeloId(Long id);

    public Usuario criar(Usuario usuario);
}
