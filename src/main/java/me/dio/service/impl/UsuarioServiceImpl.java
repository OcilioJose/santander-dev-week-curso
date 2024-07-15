package me.dio.service.impl;

import java.util.NoSuchElementException;

import me.dio.dominio.model.Usuario;
import me.dio.repository.UsuarioRepository;
import me.dio.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario buscarPeloId(Long id) {
        //usa um supplier
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario criar(Usuario usuario) {
        if (usuarioRepository.existsByContaNumero(usuario.getConta().getNumero()))
            throw new IllegalArgumentException("Este conta " + usuario.getConta().getNumero() + " já existe.");


        return usuarioRepository.save(usuario);
    }
}
