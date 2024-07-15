package me.dio.repository;

import me.dio.dominio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //busca a Conta pelo campo Numero - Conta::Numero
    boolean existsByContaNumero(String numero);
}
