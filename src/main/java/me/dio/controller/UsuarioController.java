package me.dio.controller;

import java.net.URI;

import me.dio.dominio.model.Usuario;
import me.dio.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPeloId(@PathVariable("id") Long id){
        var user =  usuarioService.buscarPeloId(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario novo){
        usuarioService.criar(novo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novo.getId()).toUri();

        return ResponseEntity.created(location).body(novo);
    }
}
